package de.Gorden.Form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MaxMinInListForm {

	@NotNull
	@Min(value=-2147483648)
	@Max(value=2147483647)
	private String fieldOne;
	
	
	private Integer ergebnis;
	
	public String getFieldOne() {
		return fieldOne;
	}
	public void setFieldOne(String fieldOne) {
		this.fieldOne = fieldOne;
	}
	
	public Integer getErgebnis() {
		return ergebnis;
	}
	public void setErgebnis(Integer ergebnis) {
		this.ergebnis = ergebnis;
	}
	
	
}
