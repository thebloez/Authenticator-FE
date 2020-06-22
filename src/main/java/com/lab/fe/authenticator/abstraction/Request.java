package com.lab.fe.authenticator.abstraction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;

public abstract class Request {
    public abstract ResponseEntity<String> getAll(@RequestHeader(value = "API-Key") String apikey);
}
