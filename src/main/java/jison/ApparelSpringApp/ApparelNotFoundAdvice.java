package jison.ApparelSpringApp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApparelNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler(ApparelNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String apparelNotFoundHandler(ApparelNotFoundException e) {
		return e.getMessage();
	}
}
