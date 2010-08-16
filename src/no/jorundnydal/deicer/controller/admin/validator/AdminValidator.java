package no.jorundnydal.deicer.controller.admin.validator;

import no.jorundnydal.deicer.entity.Admin;
import no.jorundnydal.deicer.entity.User;
import no.jorundnydal.deicer.shop.entity.Customer;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class AdminValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class aClass) {
		return User.class.equals(aClass)||Customer.class.equals(aClass)||Admin.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		@SuppressWarnings("unused")
		User user = (User) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "field.required", "Required field");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "Required field");
		
		/*if ( ! errors.hasFieldErrors("price")) {
			if (car.getPrice().intValue() == 0)
				errors.rejectValue("price", "not_zero", "Can't be free!");
		}*/		
	}
}
