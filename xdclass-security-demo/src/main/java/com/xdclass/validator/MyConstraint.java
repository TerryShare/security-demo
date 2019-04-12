package com.xdclass.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD,ElementType.FIELD})//表明注解在哪里用
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =  MyConstraintValidator.class)//校验器
public @interface MyConstraint {
	String message();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
