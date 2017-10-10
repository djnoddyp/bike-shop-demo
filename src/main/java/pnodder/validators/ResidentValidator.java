package pnodder.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pnodder.model.Resident;

public class ResidentValidator implements Validator {

    // Supports just Resident instances
    @Override
    public boolean supports(Class<?> aClass) {
        return Resident.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "address", "address.empty");
    }
}
