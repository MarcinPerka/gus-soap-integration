package com.archu.gussoapintegration.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
class ApiValidationError extends BaseApiSubError {

    @NotBlank
    private String object;

    private String field;

    private Object rejectedValue;

    @NotBlank
    private String message;


    public ApiValidationError(@NotBlank String object, @NotBlank String message) {
        this.object = object;
        this.message = message;
    }
}