package com.archu.gussoapintegration.regon;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.Size;

/**
 * Params which will be converted to gus "ParametryWyszukiwania"
 * User should use only one of parameters listed below.
 */
@Getter
public class SearchingParams {

    /**
     * One value
     */
    @Size(min = 10, max = 10)
    private String nip;
    @Size(min = 9, max = 14)
    private String regon;
    @Size(min = 10, max = 10)
    private String krs;

    /**
     * Max 20 values
     */
    @Size(max = 20)
    private String[] regonsWith9Chars;
    @Size(max = 20)
    private String[] regonsWith14Chars;
    @Size(max = 20)
    private String[] krses;
    @Size(max = 20)
    private String[] nips;
}
