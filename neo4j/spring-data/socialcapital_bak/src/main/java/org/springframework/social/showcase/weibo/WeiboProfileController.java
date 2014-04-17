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

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.weibo.api.Weibo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WeiboProfileController {

	@Inject
	private ConnectionRepository connectionRepository;
	
	@RequestMapping(value="/weibo", method=RequestMethod.GET)
	public String home(Principal currentUser, Model model) {
		Connection<Weibo> connection = connectionRepository.findPrimaryConnection(Weibo.class);
		if (connection == null) {
			return "redirect:/connect/weibo";
		}
		model.addAttribute("profile", connection.getApi().userOperations().getUserProfileByScreenName(connection.getDisplayName()));
		return "weibo/profile";
	}
	
}
