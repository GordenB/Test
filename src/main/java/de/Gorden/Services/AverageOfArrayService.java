package de.Gorden.Services;

import org.springframework.stereotype.Service;

@Service
public class AverageOfArrayService {
	
	private double totalArray = 0;
	private double average = 0;

	public String[] splitInput(String fieldOne) {
		String[] values = fieldOne.split(" ");
		return values;
	}
	
	public double getAverage(String[] values) {
		int[] iArray = new int[values.length];
		for(int i = 0; i < values.length; i ++ ) {
			iArray[i] = Integer.parseInt(values[i]);
			totalArray += iArray[i];
		}
		average = totalArray / (iArray.length);
		return average;
	}
}
