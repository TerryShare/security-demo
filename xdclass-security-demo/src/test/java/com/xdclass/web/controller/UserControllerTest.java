package com.xdclass.web.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * user测试
 * @author pengfei.liu
 *
 */
@RunWith(SpringRunner.class)//启动方式
@SpringBootTest//springboot测试用例
public class UserControllerTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	//构建mvc环境
	@Before
	public void setup() {
		mockMvc=MockMvcBuilders.webAppContextSetup(wac).build();
	}
	//
	@Test
	public void whenQuerySuccess() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/user") //请求地址
				.param("username", "terry")//请求参数
				.param("age", "11")//请求参数
				.param("ageTo", "22")//请求参数
				.param("xxx", "yyy")//请求参数
//				.param("size", "15")//请求参数
//				.param("page", "3")//请求参数
//				.param("sort", "age,desc")//请求参数
				.contentType(MediaType.APPLICATION_JSON_UTF8)) //编码格式
				.andExpect(MockMvcResultMatchers.status().isOk()) //请求状态
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3));//返回长度
				
	}

}
