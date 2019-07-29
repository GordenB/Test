package de.Gorden.Services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class SumOfDigitService {
			
	

	public Integer extractNumber (String num, String num2, String num3)throws Exception  
	
{
		 if(num == null || num.isEmpty()) return null ;
		 if(num2 == null || num2.isEmpty()) return null;
		 if(num3 == null || num3.isEmpty()) return null;
		 
		 int a = Integer.parseInt(num);
		 int b = Integer.parseInt(num2);
		 int c = Integer.parseInt(num3);
		 
		 int digitsNum = a * b + c;
		 
		 digitsNum = extractDigit(digitsNum);
		return digitsNum;
	}
	private int extractDigit( int digitsNum){
		
		 int result = 0;
		while(digitsNum > 0) {
			 result += digitsNum % 10;
			 digitsNum /= 10;
			 
		 }
		
		 return result;
	}
}
