package com.archu.gussoapintegration.regon.subject;

import com.archu.gussoapintegration.regon.subject.dto.SubjectDTO;
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
@RequestMapping(path = "/api/regon/subjects", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public List<SubjectDTO> getSubject(@Valid SubjectSearchingParams searchingParams) {
        return subjectService.getSubjects(searchingParams);
    }

}
