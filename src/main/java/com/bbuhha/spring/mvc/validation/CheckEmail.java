package com.bbuhha.spring.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) //к какой области применяется аннотация - поля
@Retention(RetentionPolicy.RUNTIME) //информация о нашей аннотация сохраняется вплоть до выполнения кода
@Constraint(validatedBy = CheckEmailValidator.class) //вся бизнес-логика содержится тут,
// этот интерфейс лишь аннтоация, которая говорит, что нужно что-то делать
public @interface CheckEmail {

    public String value() default "xyz.com";

    public String message() default "email must ends with xyz.com";

    public Class<?>[] groups() default {}; //не обращаем внимание
    public Class<? extends Payload> payload()[] default {}; //не обращаем внимание
}
