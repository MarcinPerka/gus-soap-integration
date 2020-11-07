package com.archu.gussoapintegration.regon;

import com.archu.gussoapintegration.integration.regon.SoapRegonClient;
import com.gus.regon.ZalogujResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class RegonService {

    private final SoapRegonClient soapRegonClient;

    public ZalogujResponse login(){
        var zalogujResponse = soapRegonClient.getZaloguj();
        //TODO convert to dtos to rid off of useless stuff.
        return zalogujResponse;
    }
}
