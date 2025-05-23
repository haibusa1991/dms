//package com.dms.beiam.restapi.validation;
//
//import com.dms.beiam.restapi.base.RestApiResult;
//import com.dms.beiam.restapi.models.RestApiError;
//import io.vavr.control.Either;
//import jakarta.validation.ConstraintViolation;
//import jakarta.validation.Validation;
//import jakarta.validation.Validator;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Set;
//
//@Aspect
//@Component
//public class ValidationAspect {
//    private final Validator validator;
//
//    public ValidationAspect() {
//        validator = Validation
//                .buildDefaultValidatorFactory()
//                .getValidator();
//    }
//
//    @Around("execution(* com.dms.beiam.restapi.base.adapters.*Adapter.*(..))")
//    public Either<RestApiError, ? extends RestApiResult> validate(ProceedingJoinPoint pjp) throws Throwable {
//        Object restApiInput = pjp.getArgs()[0];
//
//        Set<ConstraintViolation<Object>> validate = validator.validate(restApiInput);
//
//        if (validate.isEmpty()) {
//            return (Either<RestApiError, ? extends RestApiResult>) pjp.proceed();
//        }
//
//        List<String> errors = validate
//                .stream()
//                .map(this::formatMessage)
//                .toList();
//
//        RestApiError error = RestApiError
//                .builder()
//                .httpStatus(HttpStatus.BAD_REQUEST)
//                .message(errors)
//                .errorCode("BEIAM-VALIDATION-ERROR")
//                .build();
//
//        return Either.left(error);
//    }
//
//    private String formatMessage(ConstraintViolation<Object> violation) {
//        return String.format("field '%s' - %s", violation.getPropertyPath().toString(), violation.getMessage());
//    }
//}
