package com.aghairsalon.authorizationserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.Exception;

@RestController
public class SentryTestController {

    @GetMapping("/sentry-test")
    public String triggerException() throws Exception {
        throw new Exception("¡Esta es una prueba de error para Sentry desde la POC!");
    }
}