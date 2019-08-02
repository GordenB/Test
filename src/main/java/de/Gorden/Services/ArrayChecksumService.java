package de.Gorden.Services;

import org.springframework.stereotype.Service;

@Service
public class ArrayChecksumService {
	
	final int SEED = 113;
	final int LIMIT = 10000007;
	int result = 0;

	public String[] splitInput(String fieldOne) {
		String[] values = fieldOne.split(" ");
		
		return values;
	}
	
	public int checkSum(String[] values) {	
		
		for(int i = 0 ;i < values.length; i++) {
			
			int count = Integer.parseInt(values[i]);
			
			result = result + count;
			result %= LIMIT;
			result *= SEED;
			result %= LIMIT;
			
		}
		return result;
	}
}
