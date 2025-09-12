package com.example.insuranceAssist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DependentNotFoundException extends RuntimeException{

    public DependentNotFoundException(){
        super();
    }

    public DependentNotFoundException(String message){
        super(message);
    }

}
