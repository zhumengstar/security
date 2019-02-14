package com.xupt.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xupt.dto.User;
import com.xupt.dto.UserQueryCondition;

@RestController
public class UserController {
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public List<User> query(UserQueryCondition condition,
			@PageableDefault(page = 2, size = 17, sort = "username desc") Pageable pageable) {
		System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getSort());
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}

	@RequestMapping(value="/user/{id:\\d+}",method=RequestMethod.GET)
	public User getInfo(@PathVariable(name="id") String idxxxxx) {
		User user=new User();
		user.setUsername("tom");
		return user;
	}

}
