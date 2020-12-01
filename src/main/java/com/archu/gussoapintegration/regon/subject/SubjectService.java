package com.archu.gussoapintegration.regon.subject;

import com.archu.gussoapintegration.integration.regon.subject.SubjectClient;
import com.archu.gussoapintegration.regon.subject.dto.SubjectDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class SubjectService {

    private final SubjectClient subjectClient;
    private final SubjectConverter regonConverter;

    public List<SubjectDTO> getSubjects(SubjectSearchingParams searchingParams) {
        var result = subjectClient.getDaneSzukajPodmiot(searchingParams);
        return result.stream().map(regonConverter::convert).collect(Collectors.toList());
    }
}