package com.library.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("NameSurnameValidator")
public class NameSurnameValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		String nameOrSurname = (String)value;


		if(!nameOrSurname.matches("^[a-zA-Z\\\\s]+") || nameOrSurname.length()< 3)
		{
			FacesMessage message = new FacesMessage();
			message.setDetail("Niepoprawne imie lub nazwisko");
			message.setSummary("Niepoprawne imie lub nazwisko");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}

	}
}
