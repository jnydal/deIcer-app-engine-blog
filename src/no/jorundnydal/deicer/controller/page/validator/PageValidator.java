package no.jorundnydal.deicer.controller.page.validator;

import no.jorundnydal.deicer.entity.Page;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class PageValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class aClass) {
		return Page.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		@SuppressWarnings("unused")
		Page page = (Page) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "content", "field.required", "Required field");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required", "Required field");
		
		/*if ( ! errors.hasFieldErrors("price")) {
			if (car.getPrice().intValue() == 0)
				errors.rejectValue("price", "not_zero", "Can't be free!");
		}*/		
	}
}
