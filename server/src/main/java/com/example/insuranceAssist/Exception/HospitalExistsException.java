package com.example.insuranceAssist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class HospitalExistsException extends Exception{

    public HospitalExistsException(){
        super();
    }

    public HospitalExistsException(String message){
        super(message);
    }
}
