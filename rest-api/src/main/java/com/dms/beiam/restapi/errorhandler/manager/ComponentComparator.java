package com.dms.beiam.restapi.errorhandler.manager;

import com.dms.beiam.restapi.errorhandler.base.ErrorHandlerComponent;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.Comparator;

public class ComponentComparator implements Comparator<ErrorHandlerComponent> {
    /**
     * Compares two ErrorHandlerComponent objects based on their Order annotation value. Used to build the
     * chain of responsibility for error handling.
     * @param component1 the first object to be compared.
     * @param component2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(ErrorHandlerComponent component1, ErrorHandlerComponent component2) {
        Integer component1order = Arrays.stream(component1.getClass().getAnnotations())
                .filter(annotation -> annotation.annotationType().equals(Order.class))
                .findFirst()
                .map(annotation -> (Order) annotation)
                .map(Order::value)
                .orElse(2);

        Integer component2order = Arrays.stream(component2.getClass().getAnnotations())
                .filter(annotation -> annotation.annotationType().equals(Order.class))
                .findFirst()
                .map(annotation -> (Order) annotation)
                .map(Order::value)
                .orElse(2);

        if (component1order == 2 && component2order == 2) {
            return 0;
        }

        return Integer.compare(component1order, component2order);
    }
}
