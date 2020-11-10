package com.archu.gussoapintegration.regon;

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
    @Size(min = 10, max = 10)
    @Pattern(regexp = "[0-9]{10}")
    private String nip;

    @Size(min = 9, max = 14)
    @Pattern(regexp = "(?=[0-9]*$)(?:.{9}|.{14})$")
    private String regon;

    @Size(min = 10, max = 10)
    @Pattern(regexp = "[0-9]{10}")
    private String krs;

    /**
     * Max 20 values
     */
    @Size(max = 20)
    private List<String> regonsWith9Chars;

    @Size(max = 20)
    private List<String> regonsWith14Chars;

    @Size(max = 20)
    private List<String> krses;

    @Size(max = 20)
    private List<String> nips;
}
