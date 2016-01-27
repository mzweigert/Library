package com.library.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("dateValidator")
public class DateValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		String date = (String)value;

		if(!date.matches("\\d{4}-\\d{2}-\\d{2}"))
		{
			FacesMessage message = new FacesMessage();
			message.setDetail("Niepoprawny format daty, prawidlowy to (DD-MM-RRRR)");
			message.setSummary("Niepoprawny format daty, prawidlowy to (DD-MM-RRRR)");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

	}
}
