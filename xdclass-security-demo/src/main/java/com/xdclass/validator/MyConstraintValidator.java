package com.xdclass.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.xdclass.service.Helloservice;

/**
 * 自定义注解处理方法
 * @author terry.liu
 *
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

	@Autowired
	private Helloservice Helloservice;
	
	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		// TODO Auto-generated method stub
		System.out.println(" chu shi hua ok");
		
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		Helloservice.hello("terry");
		System.out.println(value);
		return false;
	}

}
