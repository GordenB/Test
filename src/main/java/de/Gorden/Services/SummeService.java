package de.Gorden.Services;

import org.springframework.stereotype.Service;

@Service
public class SummeService {

	public Integer summieren(String fieldOne, String fieldTwo) {
		int a = Integer.parseInt(fieldOne);
		int b = Integer.parseInt(fieldTwo);
		Integer ergebnis = a + b;
		return ergebnis;
		
	}
}
