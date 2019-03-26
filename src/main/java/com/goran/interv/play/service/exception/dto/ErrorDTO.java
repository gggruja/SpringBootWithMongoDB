package com.goran.interv.play.service.exception.dto;

/**
 * Error DTO
 */
public class ErrorDTO {

    private String code;

    private String message;

    private SeverityEnum severity;

    /**
     * Default Constructor
     */

    public ErrorDTO() {

    }

    /**
     * Advanced Constructor
     *
     * @param code     The errorCode.
     * @param message  The fallback error message.
     * @param severity The frontend severity which should be used.
     */

    public ErrorDTO(String code, String message, SeverityEnum severity) {

        this.code = code;
        this.message = message;
        this.severity = severity;
    }

    public String getCode() {

        return code;
    }

    public void setCode(String code) {

        this.code = code;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public SeverityEnum getSeverity() {

        return severity;
    }

    public void setSeverity(SeverityEnum severity) {

        this.severity = severity;
    }

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", severity=" + severity +
                '}';
    }

}

