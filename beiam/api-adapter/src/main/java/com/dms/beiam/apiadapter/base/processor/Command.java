package com.dms.beiam.apiadapter.base.processor;


public interface Command<R extends CommandResult, I extends CommandInput> {
    R execute(I input);
}
