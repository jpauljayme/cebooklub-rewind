package dev.v4jp.cebooklub.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = IdValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
  boolean optional() default false;
  String message() default "Invalid id - value must be always greater than 0";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
