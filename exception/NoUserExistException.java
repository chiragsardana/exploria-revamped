
package com.devnologix.exploria_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NoUserExistException extends RuntimeException{
	private String message;

    public NoUserExistException() {
        this.message = "User doesn't exist";
    }

    public NoUserExistException(String message) {
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
