package com.archu.gussoapintegration.regon.session;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping(path = "/api/regon/session", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class SessionController {

    private final SessionService sessionService;

    @GetMapping
    public String getSessionId() {
        return sessionService.getSessionId();
    }
}
