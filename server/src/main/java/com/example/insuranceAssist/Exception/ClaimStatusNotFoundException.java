package com.example.insuranceAssist.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClaimStatusNotFoundException extends Exception {
    public ClaimStatusNotFoundException(){super();}
    public ClaimStatusNotFoundException(String message) {
        super(message);
    }
}
