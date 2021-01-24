package com.archu.gussoapintegration.config.rest.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class ApiError {

    /**
     * Http Status
     */
    @NonNull
    @NotNull
    private HttpStatus status;

    /**
     * internal error message for a developer
     */
    @NonNull
    @NotBlank
    private String message;

    /**
     * error code in a string representation; it can be an exception name e.g. MissingDeliveryPointException
     */
    @NonNull
    @NotBlank
    private String code;

    /**
     * localized message (based on Accept-Language header) to be presented to an application user (much more general than a message); can be null
     */
    private String userMessage;

    /**
     * more specific message for an internal developer; it will be null in case of a production environment
     */
    private String details;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp = LocalDateTime.now();

    /**
     * information about failed parameters validation; can be null
     */
    private List<BaseApiSubError> subErrors = new ArrayList<>();

    private void addSubError(BaseApiSubError subError) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();
        }
        subErrors.add(subError);
    }

    private void addValidationError(String object, String field, Object rejectedValue, String message) {
        addSubError(new ApiValidationError(object, field, rejectedValue, message));
    }

    private void addValidationError(String object, String message) {
        addSubError(new ApiValidationError(object, message));
    }

    private void addValidationError(FieldError fieldError) {
        this.addValidationError(
                fieldError.getObjectName(),
                fieldError.getField(),
                fieldError.getRejectedValue(),
                fieldError.getDefaultMessage());
    }

    public void addValidationErrors(List<FieldError> fieldErrors) {
        fieldErrors.forEach(this::addValidationError);
    }

    private void addValidationError(ObjectError objectError) {
        this.addValidationError(
                objectError.getObjectName(),
                objectError.getDefaultMessage());
    }

    public void addValidationError(List<ObjectError> globalErrors) {
        globalErrors.forEach(this::addValidationError);
    }
}