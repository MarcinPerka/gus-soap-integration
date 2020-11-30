package com.archu.gussoapintegration.regon.subject;

import com.archu.gussoapintegration.integration.regon.subject.model.DaneSzukajPodmiotRoot;
import com.archu.gussoapintegration.regon.subject.dto.SubjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SubjectConverter {

    public SubjectDTO convertDaneSzukajPodmiotDataToSubjectDTO(DaneSzukajPodmiotRoot.DaneSzukajPodmiotData data) {
        return SubjectDTO.builder()
                .regon(data.getRegon())
                .nip(data.getNip())
                .statusNip(data.getStatusNip())
                .name(data.getNazwa())
                .voivodeship(data.getWojewodztwo())
                .district(data.getPowiat())
                .municipality(data.getGmina())
                .city(data.getMiejscowosc())
                .postalCode(data.getKodPocztowy())
                .street(data.getUlica())
                .houseNumber(data.getNrNieruchomosci())
                .apartmentNumber(data.getNrLokalu())
                .type(data.getTyp())
                .silosId(data.getSilosID())
                .businessEndDate(data.getDataZakonczeniaDzialalnosci())
                .postTown(data.getMiejscowoscPoczty())
                .build();
    }
}
