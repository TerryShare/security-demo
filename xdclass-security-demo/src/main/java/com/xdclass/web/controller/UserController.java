package com.xdclass.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.xdclass.Exception.UserNotExistexception;
import com.xdclass.domain.User;
import com.xdclass.domain.User.UserDatailView;
import com.xdclass.domain.User.UserSimpleView;
import com.xdclass.domain.UserQueryCondition;



@RestController //表明该类提供RestAPI
@RequestMapping("/user")
@ResponseBody
public class UserController {
// @RequestParam 映射请求参数到java方法参数 @PageableDefault 分页默认值
	
	@GetMapping() //映射 请求url到java方法
	@JsonView(UserSimpleView.class)
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
	
	@GetMapping("/{id:\\d+}")
	@JsonView(UserDatailView.class)
	public User gitInfo(@PathVariable String id) {
	//	throw new UserNotExistexception(id); //使用自定义异常处理
		System.out.println("进入 getinfo 服务");
		User user=new User();
		user.setUsername("tom");
		return user;
	}
	
	@PostMapping()
	public User creat(@Valid @RequestBody User user,BindingResult erros) {
		if(erros.hasErrors()) {
			erros.getAllErrors().stream().forEach(error ->System.out.printf(error.getDefaultMessage()));;
		}
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		user.setId("1");
		return user;
	}
	
	@PutMapping("/{id:\\d+}")
	public User update(@Valid @RequestBody User user,BindingResult erros) {
		if(erros.hasErrors()) {
			erros.getAllErrors().stream().forEach(error ->{
//				FieldError fieldError=(FieldError) error;
//				String message=fieldError.getField()+" "+error.getDefaultMessage();
				System.out.println(error.getDefaultMessage());
			}
			);
		}
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getBirthday());
		user.setId("1");
		return user;
	}
	
	@DeleteMapping("/{id:\\d+}")
	public void delete(@PathVariable int id) {
		System.out.println(id);
	}
	
	
}
