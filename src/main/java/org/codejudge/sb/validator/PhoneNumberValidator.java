package org.codejudge.sb.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.codejudge.sb.annotation.ValidPhoneNumber;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, Long>{

	@Override
	public boolean isValid(Long phone, ConstraintValidatorContext context) {
		String strVal = phone.toString();
		Pattern pattern = Pattern.compile("\\d{10}");
		Matcher match = pattern.matcher(strVal);
		return match.find();
	}

}
