package com.techguy.gkeep_bkend.controllerAdvice;

import com.techguy.gkeep_bkend.apiReponse.APIResponse;
import com.techguy.gkeep_bkend.apiReponse.ApiResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<APIResponse> handleGenericException(Exception ex)
	{
		APIResponse response=new APIResponse();
		response.setIsError(Boolean.TRUE);
		response= ApiResponseError.returnApiResponse(response, ex);
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
