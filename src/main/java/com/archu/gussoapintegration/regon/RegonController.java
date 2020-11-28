package com.archu.gussoapintegration.regon;

import com.archu.gussoapintegration.regon.subject.dto.SubjectDTO;
import com.archu.gussoapintegration.regon.fullreport.FullReportSearchingParams;
import com.archu.gussoapintegration.regon.subject.SubjectSearchingParams;
import com.archu.gussoapintegration.regon.summaryreport.SummaryReportSearchingParams;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String login() {
        return regonService.login();
    }

    @GetMapping("/subjects")
    public List<SubjectDTO> getSubject(@Valid SubjectSearchingParams searchingParams) {
        return regonService.getSubjects(searchingParams);
    }

    @GetMapping("/full-report")
    public Object getFullReport(@Valid FullReportSearchingParams searchingParams) {
        return regonService.getFullReport(searchingParams);
    }

    @GetMapping("/summary-report")
    public Object getSummaryReport(@Valid SummaryReportSearchingParams searchingParams) {
        return regonService.getSummaryReport(searchingParams);
    }
}
