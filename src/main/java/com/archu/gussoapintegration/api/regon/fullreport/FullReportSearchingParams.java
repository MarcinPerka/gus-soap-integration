package com.archu.gussoapintegration.api.regon.fullreport;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public final class FullReportSearchingParams {

    @Pattern(regexp = "(?=[0-9]*$)(?:.{9}|.{14})$", message = "{validator.pattern.searching-params.regon.message}")
    @NotNull(message = "{validator.not-null.searching-params.regon.message}")
    private final String regon;
}
