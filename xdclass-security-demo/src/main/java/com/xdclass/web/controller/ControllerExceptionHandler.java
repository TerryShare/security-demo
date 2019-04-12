/**
 * 
 */
package com.xdclass.web.controller;

import java.util.HashMap;
import java.util.Map;



import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.xdclass.Exception.UserNotExistexception;

/**
 * @author terry.liu
 *
 */
@ControllerAdvice
public class ControllerExceptionHandler {//用来处理其他controller异常

	@ExceptionHandler(UserNotExistexception.class)//指定处理那个异常
	@ResponseBody
	@ResponseStatus(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> handlerUserNotExistException(UserNotExistexception ex){
		Map<String, Object> map=new HashMap<>();
		map.put("id", ex.getId());
		map.put("message", ex.getMessage());
		return map;
		
	}
}
