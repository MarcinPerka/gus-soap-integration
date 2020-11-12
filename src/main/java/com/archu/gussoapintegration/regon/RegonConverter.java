package com.archu.gussoapintegration.regon;

import com.archu.gussoapintegration.integration.regon.model.DaneSzukajPodmiotRoot;
import com.archu.gussoapintegration.regon.dto.SubjectDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class RegonConverter {

    public List<SubjectDTO> convertDaneSzukajPodmiotRootToSubjectDTO(List<DaneSzukajPodmiotRoot.DaneSzukajPodmiotData> data) {
        return data.stream().map(it -> SubjectDTO.builder()
                .regon(it.getRegon())
                .nip(it.getNip())
                .statusNip(it.getStatusNip())
                .name(it.getNazwa())
                .voivodeship(it.getWojewodztwo())
                .district(it.getPowiat())
                .municipality(it.getGmina())
                .city(it.getMiejscowosc())
                .postalCode(it.getKodPocztowy())
                .street(it.getUlica())
                .houseNumber(it.getNrNieruchomosci())
                .apartmentNumber(it.getNrLokalu())
                .type(it.getTyp())
                .silosId(it.getSilosID())
                .businessEndDate(it.getDataZakonczeniaDzialalnosci())
                .postTown(it.getMiejscowoscPoczty())
                .build()).collect(Collectors.toList());
    }
}
