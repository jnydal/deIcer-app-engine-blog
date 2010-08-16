package no.jorundnydal.deicer.shop.controller.category.validator;

import no.jorundnydal.deicer.entity.Page;
import no.jorundnydal.deicer.shop.entity.Category;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



public class CategoryValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class aClass) {
		return Category.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		@SuppressWarnings("unused")
		Category category = (Category) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required", "Required field");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required", "Required field");
	
	}
}
