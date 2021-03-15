package com.archu.gussoapintegration.api.regon.subject;

import com.archu.gussoapintegration.exception.BadRequestException;
import com.archu.gussoapintegration.api.regon.subject.dto.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@AllArgsConstructor
@RequestMapping(path = "/regon/subjects", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public List<SubjectDTO> getSubjects(@ModelAttribute @Valid SubjectSearchingParams searchingParams) {
        if (!searchingParams.checkIfAnyParamIsPresent())
            throw new BadRequestException("No request parameter was entered");

        return subjectService.getSubjects(searchingParams);
    }

}
