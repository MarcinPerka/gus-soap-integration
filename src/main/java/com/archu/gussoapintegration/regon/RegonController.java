package com.archu.gussoapintegration.regon;

import com.archu.gussoapintegration.regon.dto.SessionDTO;
import com.archu.gussoapintegration.regon.dto.SubjectDTO;
import com.gus.regon.wsdl.DanePobierzPelnyRaportResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping(path = "/api/regon", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class RegonController {

    private final RegonService regonService;

    @GetMapping("/login")
    public SessionDTO login() {
        return regonService.login();
    }

    @GetMapping("/subjects")
    public List<SubjectDTO> getSubject(@Valid SearchingParams searchingParams) {
        return regonService.getSubjects(searchingParams);
    }

    @GetMapping("/full-report")
    public DanePobierzPelnyRaportResponse getFullReport(@RequestParam String regon, @RequestParam FullReportName fullReportName) {
        return regonService.getFullReport(regon, fullReportName);
    }
}
