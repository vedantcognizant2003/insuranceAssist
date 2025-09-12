package com.example.insuranceAssist.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class RelationNotFoundException extends RuntimeException{

    public RelationNotFoundException(){
        super();
    }

    public RelationNotFoundException(String message){
        super(message);
    }

}
