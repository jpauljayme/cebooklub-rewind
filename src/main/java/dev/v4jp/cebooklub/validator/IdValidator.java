package dev.v4jp.cebooklub.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdValidator implements ConstraintValidator<Id, Long> {

  private boolean optional;

  @Override
  public void initialize(Id constraintAnnotation) {
    optional = constraintAnnotation.optional();
  }

  @Override
  public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
    return optional ? (value != null || value > 0) : (value != null && value > 0);
  }
}
