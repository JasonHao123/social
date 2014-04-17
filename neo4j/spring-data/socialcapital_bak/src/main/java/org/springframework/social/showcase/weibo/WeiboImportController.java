/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.showcase.weibo;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.showcase.dao.FriendDao;
import org.springframework.social.weibo.api.CursoredList;
import org.springframework.social.weibo.api.Weibo;
import org.springframework.social.weibo.api.WeiboProfile;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WeiboImportController {

	@Inject
	private ConnectionRepository connectionRepository;
	
	@Autowired
	private FriendDao friendDao;
	
	@RequestMapping(value="/weibo/import", method=RequestMethod.GET)
	public ModelAndView home(Principal currentUser,@RequestParam(value="cursor",required=false) String cursor) {
		Connection<Weibo> connection = connectionRepository.findPrimaryConnection(Weibo.class);
		if (connection == null) {
			return new ModelAndView("redirect:/connect/weibo");
		}
		ModelAndView model = new ModelAndView("weibo/import");
		CursoredList<WeiboProfile> friends = null;
		if(cursor!=null) {
		    friends =  connection.getApi().friendOperations().getFriendsByDisplayName(connection.getDisplayName(),cursor);
		}else {
		    friends =  connection.getApi().friendOperations().getFriendsByDisplayName(connection.getDisplayName());
		}
		model.addObject("friends", friends);
		model.addObject("previous", friends.getPreviousCursor());
		model.addObject("next", friends.getNextCursor());
		model.addObject("total", friends.getTotalNumber());
		model.addObject("form",new WeiboImportForm());
		return model;
	}
	
	 @RequestMapping(value="/weibo/import",method=RequestMethod.POST)
	    public String processSubmit(Principal currentUser,@ModelAttribute("form") WeiboImportForm form, BindingResult result, SessionStatus status)
	   {
	     System.out.println(form.getFriends().toArray());
	     for(String friend:form.getFriends()) {
	         String[] segments = friend.split(";");
	         friendDao.saveFriend(currentUser.getName(), "weibo", segments[0], segments[1], segments[2], segments[3]);
	     }
	     return "redirect:/weibo/import";
	   }
	
}
