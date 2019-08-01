package de.Gorden.Services;

import org.springframework.stereotype.Service;

@Service
public class ModularCalculatorService {

	private int total;
	private int modulo;
	private int result;
	
	public String[] splitInput(String fieldOne) {                

		String[] values = fieldOne.split(" ");
		return values;
	}
	
	
	public int getResult() {
		return result;
	}
	
	public int calculate(String[] values) {
		
		total = Integer.parseInt(values[0]);
		modulo = Integer.parseInt(values[values.length - 1]);
		
		for (int i = 0; i < values.length - 1; i++) {
			int temp;
			switch (values[i]) {
			case "+":
				temp = total + Integer.parseInt(values[i + 1]);
				total = temp % modulo;
				break;

			case "*":
				temp = total * Integer.parseInt(values[i + 1]);
				total = temp % modulo;
				break;

			case "%":
				result = total % Integer.parseInt(values[i + 1]);
				break;
			}
		}
		return result;
		

	
	

	
	}

	
}
