package de.Gorden.Form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Issue {

	@NotNull
	@Min(value=-2147483648)
	@Max(value=2147483647)
	private Integer fieldOne;
	
	@NotNull
	@Min(value=-2147483648)
	@Max(value=2147483647)
	private Integer fieldTwo;
	
	private Integer ergebnis;
	
	public Integer getFieldOne() {
		return fieldOne;
	}
	public void setFieldOne(Integer fieldOne) {
		this.fieldOne = fieldOne;
	}
	public Integer getFieldTwo() {
		return fieldTwo;
	}
	public void setFieldTwo(Integer fieldTwo) {
		this.fieldTwo = fieldTwo;
	}
	public Integer getErgebnis() {
		return ergebnis;
	}
	public void setErgebnis(Integer ergebnis) {
		this.ergebnis = ergebnis;
	}
	
	
}
