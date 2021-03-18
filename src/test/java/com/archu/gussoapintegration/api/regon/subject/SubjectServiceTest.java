package com.archu.gussoapintegration.api.regon.subject;

import com.archu.gussoapintegration.api.regon.subject.dto.SubjectDTO;
import com.archu.gussoapintegration.integration.regon.subject.SubjectClient;
import com.archu.gussoapintegration.integration.regon.subject.model.DaneSzukajPodmiotRoot;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SubjectServiceTest {

    @InjectMocks
    private SubjectService subjectService;

    @Mock
    private SubjectConverter subjectConverter;

    @Mock
    private SubjectClient subjectClient;

    private final SubjectSearchingParams correctSubjectSearchingParams = SubjectSearchingParams.builder()
            .regon("471043763")
            .build();


    private final DaneSzukajPodmiotRoot.DaneSzukajPodmiotData correctDaneSzukajPodmiotData = createCorrectDaneSzukajPodmiotData();

    private final SubjectDTO correctSubjectDTO = createCorrectSubjectDTO();

    @Test
    public void testGetSubjectsWhenCorrectRegonIsGiven() {
        when(subjectClient.getDaneSzukajPodmiot(correctSubjectSearchingParams)).thenReturn(List.of(correctDaneSzukajPodmiotData));
        when(subjectConverter.convert(correctDaneSzukajPodmiotData)).thenReturn(correctSubjectDTO);

        var result = subjectService.getSubjects(correctSubjectSearchingParams);

        assertEquals(List.of(correctSubjectDTO), result);
    }

    private DaneSzukajPodmiotRoot.DaneSzukajPodmiotData createCorrectDaneSzukajPodmiotData() {
        var result = new DaneSzukajPodmiotRoot.DaneSzukajPodmiotData();
        result.setRegon("471043763");
        result.setNip("7271010965");
        result.setNazwa("\"PIXEL-TECHNOLOGY\" S.C. TOMASZ SZELER, JAKUB MUSIAŁEK, ADAM SZCZEPANIK");
        result.setWojewodztwo("ŁÓDZKIE");
        result.setPowiat("m. Łódź");
        result.setGmina("Łódź-Górna");
        result.setMiejscowosc("Łódź");
        result.setKodPocztowy("93-558");
        result.setUlica("ul. Test-Wilcza");
        result.setNrLokalu("1");
        result.setTyp("P");
        result.setSilosID(6);
        result.setMiejscowoscPoczty("Łódź");
        return result;
    }

    private SubjectDTO createCorrectSubjectDTO() {
        return SubjectDTO.builder()
                .regon("471043763")
                .nip("7271010965")
                .name("\"PIXEL-TECHNOLOGY\" S.C. TOMASZ SZELER, JAKUB MUSIAŁEK, ADAM SZCZEPANIK")
                .voivodeship("ŁÓDZKIE")
                .district("m. Łódź")
                .municipality("Łódź-Górna")
                .city("Łódź")
                .postalCode("93-558")
                .street("ul. Test-Wilcza")
                .apartmentNumber("1")
                .type("P")
                .silosId(6)
                .postTown("Łódź").build();
    }

}