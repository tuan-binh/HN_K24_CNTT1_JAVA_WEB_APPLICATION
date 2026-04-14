package org.example.ss08.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.ss08.controller.PersonController;

public class EmailExistValidator implements ConstraintValidator<EmailExist,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // Quy ước:
        // false thì sẽ giữ bắt và báo lỗi
        // true thì sẽ cho thông qua

        boolean exist = PersonController.luonGiuBinhTinh
                .stream()
                .anyMatch(p -> p.getEmail().equals(s));

        return !exist;
    }
}
