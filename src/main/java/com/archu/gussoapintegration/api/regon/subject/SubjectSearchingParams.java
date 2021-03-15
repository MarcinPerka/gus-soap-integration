package com.archu.gussoapintegration.api.regon.subject;

import com.archu.gussoapintegration.validation.KrsFields;
import com.archu.gussoapintegration.validation.NipFields;
import com.archu.gussoapintegration.validation.Regon14DigitsFields;
import com.archu.gussoapintegration.validation.Regon9DigitsFields;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Params which will be converted to gus "ParametryWyszukiwania"
 * User should use only one of parameters listed below.
 */
@Getter
@ToString
@Slf4j
public final class SubjectSearchingParams {

    /**
     * One value
     */
    @Pattern(regexp = "[0-9]{10}", message = "{validator.pattern.searching-params.nip.message}")
    private String nip;

    @Pattern(regexp = "(?=[0-9]*$)(?:.{9}|.{14})$", message = "{validator.pattern.searching-params.regon.message}")
    private String regon;

    @Pattern(regexp = "[0-9]{10}", message = "{validator.pattern.searching-params.krs.message}")
    private String krs;

    /**
     * Max 20 values
     */
    @Size(max = 20, message = "{validator.size.searching-params.regons-with-9-digits.message}")
    @Regon9DigitsFields(message = "{validator.regons-with-9-digits.searching-params.regons-with-9-digits.message}")
    private List<String> regonsWith9Digits;

    @Size(max = 20, message = "{validator.size.searching-params.regons-with-14-digits.message}")
    @Regon14DigitsFields(message = "{validator.regons-with-14-digits.searching-params.regons-with-14-digits.message}")
    private List<String> regonsWith14Digits;

    @Size(max = 20, message = "{validator.size.searching-params.krses.message}")
    @KrsFields(message = "{validator.krses.searching-params.krses.message}")
    private List<String> krses;

    @Size(max = 20, message = "{validator.size.searching-params.nips.message}")
    @NipFields(message = "{validator.nips.searching-params.nips.message}")
    private List<String> nips;


    public boolean checkIfAnyParamIsPresent() {
        return Stream.of(krs, krses, nip, nips, regon, regonsWith9Digits, regonsWith14Digits).anyMatch(Objects::nonNull);
    }
}
