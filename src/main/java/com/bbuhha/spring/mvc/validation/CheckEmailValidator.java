package com.bbuhha.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator
        implements ConstraintValidator<CheckEmail, String> {
                                    //аннотация, типа данных к которым применяется аннотация

    private String endOfEmaill;

    @Override
    public void initialize(CheckEmail constraintAnnotation) {
        //получаем из аннотации конец email
        endOfEmaill = constraintAnnotation.value();
    }

    @Override
    //то значение, которые ввекли и хз что за значение
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.endsWith(endOfEmaill); //кончается ли на введенный endOfEmail?
    }


}
