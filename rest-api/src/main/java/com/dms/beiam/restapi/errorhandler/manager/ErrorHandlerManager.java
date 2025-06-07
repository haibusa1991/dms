package com.dms.beiam.restapi.errorhandler.manager;

import com.dms.beiam.restapi.errorhandler.base.ErrorHandler;
import com.dms.beiam.restapi.errorhandler.base.ErrorHandlerComponent;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class ErrorHandlerManager implements ErrorHandler {
    private final ApplicationContext applicationContext;
    private List<ErrorHandlerComponent> components;

    @PostConstruct
    private void init() {
        components = applicationContext
                .getBeansOfType(ErrorHandlerComponent.class)
                .values()
                .stream()
                .sorted(new ComponentComparator())
                .toList();

        IntStream.range(0, components.size() - 1)
                .forEach(i -> components
                        .get(i)
                        .setNext(components.get(i + 1))
                );
    }

    @Override
    public ProblemDetail handle(Throwable throwable) {
        return components.getFirst().handle(throwable);
    }
}
