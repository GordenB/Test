package de.Gorden.Services;

import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Service;

@Service
public class WeightedSumService {

	public Integer iterieren(Integer fieldOne) {
		ArrayList<Integer> digits = new ArrayList<>();
		Integer digitsNum = fieldOne;
		int result = 0;
		
		while(digitsNum > 0) {
			digits.add(digitsNum % 10);
			digitsNum = digitsNum / 10;
		}
		
		Collections.reverse(digits);
	
		for(int j = 0; j < digits.size(); j++) {
			int digit = digits.get(j);
			result += digit * (j +1);
		}
		
	
		return result;
		
	}
}
