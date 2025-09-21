
package com.devnologix.exploria_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class UserAlreadyExistException extends RuntimeException{
	private String message;

    public UserAlreadyExistException() {
        message = "User Already exist";
    }

    public UserAlreadyExistException(String message) {
        this.message = message;
    }


    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
            " message='" + getMessage() + "'" +
            "}";
    }
	
}
