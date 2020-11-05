package com.archu.gussoapintegration.gus.regon;

import com.archu.gus.regon.ZalogujResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.soap.SOAPException;

@RestController
@AllArgsConstructor
public class RegonController {

    RegonClient regonClient;

    @GetMapping("regon/zaloguj")
    public ZalogujResponse getZaloguj() throws SOAPException {
        return regonClient.getZaloguj();
    }
}
