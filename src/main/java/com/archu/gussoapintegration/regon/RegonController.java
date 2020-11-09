package com.archu.gussoapintegration.regon;

import com.archu.gussoapintegration.integration.regon.model.DaneSzukajPodmiotRoot;
import com.archu.gussoapintegration.regon.dto.SessionDTO;
import com.gus.regon.wsdl.DanePobierzPelnyRaportResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/regon", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class RegonController {

    private final RegonService regonService;

    @GetMapping("/login")
    public SessionDTO login() {
        return regonService.login();
    }

    @GetMapping("/subjects")
    public List<DaneSzukajPodmiotRoot.DaneSzukajPodmiotData> getSubject(@Valid SearchingParams searchingParams) {
        return regonService.getSubjects(searchingParams);
    }

    @GetMapping("/full-report")
    public DanePobierzPelnyRaportResponse getFullReport(@RequestParam String regon, @RequestParam(defaultValue = "") String reportName) {
        return regonService.getFullReport(regon, reportName);
    }
}
