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
package org.springframework.social.quickstart;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.quickstart.user.SecurityContext;
import org.springframework.social.weibo.api.CursoredList;
import org.springframework.social.weibo.api.Weibo;
import org.springframework.social.weibo.api.WeiboProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Simple little @Controller that invokes Facebook and renders the result.
 * The injected {@link Facebook} reference is configured with the required authorization credentials for the current user behind the scenes.
 * @author Keith Donald
 */
@Controller
public class HomeController {

	private final Weibo weibo;
	
	@Inject
	public HomeController(Weibo weibo) {
		this.weibo = weibo;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
	    
		List<WeiboProfile> friends = weibo.friendOperations().getFriends(SecurityContext.getCurrentUser().getUserId());

		model.addAttribute("friends", friends);
		model.addAttribute("next",((CursoredList)friends).getNextCursor());
		model.addAttribute("previous",((CursoredList)friends).getPreviousCursor());
		return "home";
	}
	
	   @RequestMapping(value = "/page", method = RequestMethod.GET)
	    public String gotoPage(@RequestParam("cursor") String cursor,Model model) {
	        
	        List<WeiboProfile> friends = weibo.friendOperations().getFriends(SecurityContext.getCurrentUser().getUserId(),cursor);
	        long nextCursor = ((CursoredList)friends).getNextCursor();
	        model.addAttribute("friends", friends);
	        model.addAttribute("next",nextCursor);
	        return "home";
	    }

}
