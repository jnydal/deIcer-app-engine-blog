package no.jorundnydal.deicer.shop.controller.product.validator;

import no.jorundnydal.deicer.entity.Page;
import no.jorundnydal.deicer.shop.entity.Product;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ProductValidator implements Validator {

	@SuppressWarnings("unchecked")
	public boolean supports(Class aClass) {
		return Product.class.equals(aClass);
	}

	public void validate(Object obj, Errors errors) {
		@SuppressWarnings("unused")
		Product p = (Product) obj;

		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required", "Required field");
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required", "Required field");
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "field.required", "Required field");
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stock", "field.required", "Required field");
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "releasedate", "field.required", "Required field");
		
		/*if (! errors.hasFieldErrors("price")) {
			if (p.getPrice().longValue() == 0)
				errors.rejectValue("price", "not_zero", "Has to be a number");
		}	*/
	}
}
