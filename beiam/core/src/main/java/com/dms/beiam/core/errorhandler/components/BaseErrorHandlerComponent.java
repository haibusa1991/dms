package com.dms.beiam.core.errorhandler.components;

import com.dms.beiam.core.errorhandler.base.ErrorHandlerComponent;

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
}
