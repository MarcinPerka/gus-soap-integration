package com.archu.gussoapintegration.regon;

import com.gus.regon.ZalogujResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/regon", produces = MediaType.APPLICATION_JSON_VALUE)
public class RegonController {

    private final RegonService regonService;

    @GetMapping("/login")
    public ZalogujResponse login() {
        return regonService.login();
    }
}
