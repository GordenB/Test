package de.Gorden.Services;

import org.springframework.stereotype.Service;

@Service
public class SummeService {

	public Integer summieren(Integer fieldOne, Integer fieldTwo) {
		int a = fieldOne;
		int b = fieldTwo;
		Integer ergebnis = a + b;
		return ergebnis;
		
	}
}
