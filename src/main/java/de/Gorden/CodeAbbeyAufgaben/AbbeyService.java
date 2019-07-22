package de.Gorden.CodeAbbeyAufgaben;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AbbeyService {
	
	private List<Integer> zahlen = new ArrayList<>();
			

	public List<Integer> addNum(String zahl) {
		
		try
		{	
			int parseInt = Integer.parseInt(zahl);
			zahlen.add(parseInt);
		}
		catch (NumberFormatException ex){
			zahlen.add(0);
		}
		finally {
			
		}
		
		
		 
		 return zahlen;
	}
	
	public Integer getMaxInteger() {
		int max=Integer.MIN_VALUE;
		for( Integer i : zahlen ) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}
}
