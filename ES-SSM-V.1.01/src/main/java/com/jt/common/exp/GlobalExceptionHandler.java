package com.jt.common.exp;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public String doHandleException(
			Exception e){
		return e.getMessage();
	}
}
