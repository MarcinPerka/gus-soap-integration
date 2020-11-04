package com.archu.gussoapintegration.gus.regon;

import com.archu.gus.regon.ZalogujResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegonController {

    RegonClient regonClient;

    @GetMapping("regon/zaloguj/{pKluczUzytkownika}")
    public ZalogujResponse getZaloguj(@PathVariable String pKluczUzytkownika) {
        return regonClient.getZaloguj(pKluczUzytkownika);
    }
}
