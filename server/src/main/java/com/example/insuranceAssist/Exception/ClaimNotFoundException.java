package com.example.insuranceAssist.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClaimNotFoundException extends Exception {
    public ClaimNotFoundException(){super();}
    public ClaimNotFoundException(String message) {
        super(message);
    }
}
