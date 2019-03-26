package com.goran.interv.play.service.exception.handler;

import com.goran.interv.play.service.annotation.Log;
import com.goran.interv.play.service.exception.constant.ErrorCodes;
import com.goran.interv.play.service.exception.dto.ErrorDTO;
import com.goran.interv.play.service.exception.dto.SeverityEnum;
import com.goran.interv.play.service.exception.utils.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class CommonExceptionHandler {

    @Log
    private static Logger log = LoggerFactory.getLogger(CommonExceptionHandler.class);

    /**
     * Handles IllegalArgumentException exception.
     *
     * @param exception The {@link IllegalArgumentException} which was intercepted.
     * @return A {@link ResponseEntity} containing a {@link ErrorDTO}.
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(HttpServletRequest req, IllegalArgumentException exception) {

        String agrMessages = ExceptionUtil.aggregateMessages(exception);

        log.error("IllegalArgumentException: " + agrMessages + " resource: " + req.getRequestURL(), exception);

        return ResponseEntity.status(BAD_REQUEST).headers(null)
                .body(new ErrorDTO(ErrorCodes.ILLEGAL_ARGUMENT, agrMessages, SeverityEnum.ERROR));
    }

}
