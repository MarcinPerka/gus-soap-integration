package com.archu.gussoapintegration.regon.session;

import com.archu.gussoapintegration.integration.regon.session.SessionClient;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class SessionService {

    private final SessionClient sessionClient;

    public String getSessionId() {
        return sessionClient.getZaloguj();
    }

}