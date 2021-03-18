package com.archu.gussoapintegration.api.regon.subject;

import com.archu.gussoapintegration.api.regon.subject.dto.SubjectDTO;
import com.archu.gussoapintegration.integration.regon.subject.model.DaneSzukajPodmiotRoot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SubjectConverterTest {

    @InjectMocks
    private SubjectConverter subjectConverter;

    private final DaneSzukajPodmiotRoot.DaneSzukajPodmiotData correctDaneSzukajPodmiotData = createCorrectDaneSzukajPodmiotData();

    private final DaneSzukajPodmiotRoot.DaneSzukajPodmiotData blankDaneSzukajPodmiotData = createBlankDaneSzukajPodmiotData();

    private final SubjectDTO subjectDtoWithSpecifiedValues = createCorrectSubjectDTO();

    private final SubjectDTO subjectDtoWithNullValues = SubjectDTO.builder().build();

    @Test
    @DisplayName("Converting valid values to valid DTO")
    public void testConvertWhenValuesAreValid() {
        var result = subjectConverter.convert(correctDaneSzukajPodmiotData);

        assertEquals(subjectDtoWithSpecifiedValues, result);
    }

    @Test
    @DisplayName("Converting blank values to nulls")
    public void testConvertWhenBlankValuesAreProvided() {
        var result = subjectConverter.convert(blankDaneSzukajPodmiotData);

        assertEquals(subjectDtoWithNullValues, result);
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

    private DaneSzukajPodmiotRoot.DaneSzukajPodmiotData createBlankDaneSzukajPodmiotData() {
        var result = new DaneSzukajPodmiotRoot.DaneSzukajPodmiotData();
        result.setRegon("");
        result.setNip("");
        result.setStatusNip("");
        result.setNazwa("");
        result.setWojewodztwo("");
        result.setGmina("");
        result.setPowiat("");
        result.setMiejscowosc("");
        result.setKodPocztowy("");
        result.setUlica("");
        result.setNrLokalu("");
        result.setNrNieruchomosci("");
        result.setTyp("");
        result.setSilosID(null);
        result.setDataZakonczeniaDzialalnosci("");
        result.setMiejscowoscPoczty("");
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