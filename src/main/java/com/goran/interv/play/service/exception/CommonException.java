package com.goran.interv.play.service.exception;

import com.goran.interv.play.service.exception.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class CommonException extends HttpStatusCodeException {

    private ErrorDTO error;

    public CommonException(ErrorDTO error) {
        super(HttpStatus.I_AM_A_TEAPOT, error.toString());
        this.error = error;
    }

    public ErrorDTO getError() {
        return error;
    }
}
