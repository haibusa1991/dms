package com.dms.beiam.apiadapter.commandexecutor.base;


public interface Command<R extends CommandResult, I extends CommandInput> {
    R execute(I input);
}
