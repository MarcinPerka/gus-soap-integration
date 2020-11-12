package com.archu.gussoapintegration.regon;

import com.archu.gussoapintegration.validation.KrsFields;
import com.archu.gussoapintegration.validation.NipFields;
import com.archu.gussoapintegration.validation.Regon14CharsFields;
import com.archu.gussoapintegration.validation.Regon9CharsFields;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Params which will be converted to gus "ParametryWyszukiwania"
 * User should use only one of parameters listed below.
 */
@Getter
@ToString
public final class SearchingParams {

    /**
     * One value
     */
    @Size(min = 10, max = 10, message = "{validator.size.searching-params.nip.message}")
    @Pattern(regexp = "[0-9]{10}")
    private String nip;

    @Size(min = 9, max = 14, message = "{validator.size.searching-params.regon.message}")
    @Pattern(regexp = "(?=[0-9]*$)(?:.{9}|.{14})$")
    private String regon;

    @Size(min = 10, max = 10, message = "{validator.size.searching-params.krs.message}")
    @Pattern(regexp = "[0-9]{10}")
    private String krs;

    /**
     * Max 20 values
     */
    @Size(max = 20)
    @Regon9CharsFields
    private List<String> regonsWith9Chars;

    @Size(max = 20)
    @Regon14CharsFields
    private List<String> regonsWith14Chars;

    @Size(max = 20)
    @KrsFields
    private List<String> krses;

    @Size(max = 20)
    @NipFields
    private List<String> nips;
}
