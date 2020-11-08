package com.archu.gussoapintegration.regon;

import com.gus.regon.DanePobierzPelnyRaportResponse;
import com.gus.regon.DaneSzukajPodmiotyResponse;
import com.gus.regon.ZalogujResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/regon", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class RegonController {

    private final RegonService regonService;

    @GetMapping("/login")
    public ZalogujResponse login() {
        return regonService.login();
    }

    @GetMapping("/subject")
    public DaneSzukajPodmiotyResponse getSubject(@Valid SearchingParams searchingParams) {
        return regonService.getSubject(searchingParams);
    }

    @GetMapping("/full-report")
    public DanePobierzPelnyRaportResponse getFullReport(@RequestParam String regon, @RequestParam(defaultValue = "") String reportName) {
        return regonService.getFullReport(regon, reportName);
    }
}
