package de.Gorden.Form;

import javax.validation.constraints.NotNull;

public class ModularCalculatorForm {

	@NotNull
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
