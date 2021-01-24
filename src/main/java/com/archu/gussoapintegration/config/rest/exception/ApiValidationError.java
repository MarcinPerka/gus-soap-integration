package com.archu.gussoapintegration.config.rest.exception;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
@ToString
class ApiValidationError extends BaseApiSubError {

    @NotBlank
    private final String object;

    private String field;

    private Object rejectedValue;

    @NotBlank
    private final String message;


    public ApiValidationError(@NotBlank String object, @NotBlank String message) {
        this.object = object;
        this.message = message;
    }
}