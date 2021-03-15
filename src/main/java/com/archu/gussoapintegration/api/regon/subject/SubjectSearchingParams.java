package com.archu.gussoapintegration.api.regon.subject;

import com.archu.gussoapintegration.validation.KrsFields;
import com.archu.gussoapintegration.validation.NipFields;
import com.archu.gussoapintegration.validation.Regon14DigitsFields;
import com.archu.gussoapintegration.validation.Regon9DigitsFields;
import lombok.*;
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
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public final class SubjectSearchingParams {

    /**
     * One value
     */
    @Pattern(regexp = "[0-9]{10}", message = "{validator.pattern.searching-params.nip.message}")
    private final String nip;

    @Pattern(regexp = "(?=[0-9]*$)(?:.{9}|.{14})$", message = "{validator.pattern.searching-params.regon.message}")
    private final String regon;

    @Pattern(regexp = "[0-9]{10}", message = "{validator.pattern.searching-params.krs.message}")
    private final String krs;

    /**
     * Max 20 values
     */
    @Size(max = 20, message = "{validator.size.searching-params.regons-with-9-digits.message}")
    @Regon9DigitsFields(message = "{validator.regons-with-9-digits.searching-params.regons-with-9-digits.message}")
    private final List<String> regonsWith9Digits;

    @Size(max = 20, message = "{validator.size.searching-params.regons-with-14-digits.message}")
    @Regon14DigitsFields(message = "{validator.regons-with-14-digits.searching-params.regons-with-14-digits.message}")
    private final List<String> regonsWith14Digits;

    @Size(max = 20, message = "{validator.size.searching-params.krses.message}")
    @KrsFields(message = "{validator.krses.searching-params.krses.message}")
    private final List<String> krses;

    @Size(max = 20, message = "{validator.size.searching-params.nips.message}")
    @NipFields(message = "{validator.nips.searching-params.nips.message}")
    private final List<String> nips;


    public boolean checkIfAnyParamIsPresent() {
        return Stream.of(krs, krses, nip, nips, regon, regonsWith9Digits, regonsWith14Digits).anyMatch(Objects::nonNull);
    }
}
