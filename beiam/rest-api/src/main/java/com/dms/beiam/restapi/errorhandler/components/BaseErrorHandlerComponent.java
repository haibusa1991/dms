package com.dms.beiam.restapi.errorhandler.components;

import com.dms.beiam.restapi.errorhandler.base.ErrorHandlerComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import static com.dms.beiam.restapi.errorhandler.BeaimErrorCodes.BEIAM_ERROR_CODE_LABEL;

public abstract class BaseErrorHandlerComponent implements ErrorHandlerComponent {

    private ErrorHandlerComponent next;

    @Override
    public void setNext(ErrorHandlerComponent next) {
        this.next = next;
    }

    @Override
    public ErrorHandlerComponent getNext() {
        return next;
    }

    protected ProblemDetail getProblemDetail(HttpStatus status, String message, String beiamErrorCode) {
        ProblemDetail problemDetail = ProblemDetail
                .forStatusAndDetail(status, message);
        problemDetail.setProperty(BEIAM_ERROR_CODE_LABEL, beiamErrorCode);

        return problemDetail;
    }
}
