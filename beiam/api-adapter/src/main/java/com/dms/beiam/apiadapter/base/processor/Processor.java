package com.dms.beiam.apiadapter.base.processor;


import com.dms.beiam.apiadapter.model.BeiamError;
import io.vavr.control.Either;

public interface Processor<R extends ProcessorResult, I extends ProcessorInput> {
    Either<BeiamError, R> process(I input);
}
