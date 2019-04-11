package com.xdclass.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xdclass.domain.User;
import com.xdclass.domain.UserQueryCondition;

@RestController //表明该类提供RestAPI
public class UserController {
// @RequestParam 映射请求参数到java方法参数 @PageableDefault 分页默认值
	
	@GetMapping("/user") //映射 请求url到java方法
	public List<User> query(UserQueryCondition queryCondition,@PageableDefault(page=2,size=17,sort="username.asc")Pageable pageable) {
		System.out.println(queryCondition.toString());
		System.out.println(pageable.getPageSize());
		System.out.println(pageable.getPageNumber());
		System.out.println(pageable.getSort());
		List<User> users=new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		return users;
	}
	
	
	
}
