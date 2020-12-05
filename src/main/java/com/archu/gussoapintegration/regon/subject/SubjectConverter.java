package com.archu.gussoapintegration.regon.subject;

import com.archu.gussoapintegration.integration.regon.subject.model.DaneSzukajPodmiotRoot;
import com.archu.gussoapintegration.regon.subject.dto.SubjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
public class SubjectConverter {

    public SubjectDTO convert(DaneSzukajPodmiotRoot.DaneSzukajPodmiotData data) {
        return SubjectDTO.builder()
                .regon(StringUtils.hasText(data.getRegon()) ? data.getRegon() : null)
                .nip(StringUtils.hasText(data.getNip()) ? data.getNip() : null)
                .statusNip(StringUtils.hasText(data.getStatusNip()) ? data.getStatusNip() : null)
                .name(StringUtils.hasText(data.getNazwa()) ? data.getNazwa() : null)
                .voivodeship(StringUtils.hasText(data.getWojewodztwo()) ? data.getWojewodztwo() : null)
                .district(StringUtils.hasText(data.getPowiat()) ? data.getPowiat() : null)
                .municipality(StringUtils.hasText(data.getGmina()) ? data.getGmina() : null)
                .city(StringUtils.hasText(data.getMiejscowosc()) ? data.getMiejscowosc() : null)
                .postalCode(StringUtils.hasText(data.getKodPocztowy()) ? data.getKodPocztowy() : null)
                .street(StringUtils.hasText(data.getUlica()) ? data.getUlica() : null)
                .houseNumber(StringUtils.hasText(data.getNrNieruchomosci()) ? data.getNrNieruchomosci() : null)
                .apartmentNumber(StringUtils.hasText(data.getNrLokalu()) ? data.getNrLokalu() : null)
                .type(StringUtils.hasText(data.getTyp()) ? data.getTyp() : null)
                .silosId(data.getSilosID())
                .businessEndDate(StringUtils.hasText(data.getDataZakonczeniaDzialalnosci()) ? data.getDataZakonczeniaDzialalnosci() : null)
                .postTown(StringUtils.hasText(data.getMiejscowoscPoczty()) ? data.getMiejscowoscPoczty() : null)
                .build();
    }
}
