package org.example.ss08.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailExistValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface EmailExist {
    // về message
    String message() default "Email is exist";
    // nhóm các annotation validation (ko set default)
    Class<?>[] groups() default {};
    // dữ liệu gửi đi (payload) (ko set default)
    Class<? extends Payload>[] payload() default {};
}
