package de.Gorden.Services;

import org.springframework.stereotype.Service;

@Service
public class SquareRootService {

	public String[] splitInput(String fieldOne) {
		String[] values = fieldOne.split(" ");
		return values;
	}
	
	public double calculate (String[] values) {
		int numToSquare = Integer.parseInt(values[0]);
		int numOfCalculations = Integer.parseInt(values[1]);
		
		double squareRoot = 1;
		double temp;
		
		for(int i = 0 ; i < numOfCalculations; i++) {
			temp = numToSquare / squareRoot;
			squareRoot = (squareRoot + temp) / 2;
		}
		
		return squareRoot;
	}
}
