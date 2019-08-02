package de.Gorden.Form;

import javax.validation.constraints.NotNull;

public class AverageOfArrayForm {

	@NotNull
	private String fieldOne;
	
	private int count;
	
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
