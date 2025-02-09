package com.dms.beiam.apiadapter.base.processor;


import com.dms.beiam.apiadapter.base.error.ProcessorError;
import io.vavr.control.Either;

public interface Processor<R extends ProcessorResult, I extends ProcessorInput> {
    Either<ProcessorError, R> process(I input);
}
