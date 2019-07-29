package de.Gorden.Services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class SumOfDigitService {
	
	private List<String> resultList = new ArrayList<>();
	private String result = null;
	public List<String> getResultList() {
		return resultList;
	}


	private ModelMap model;
	
	
	

	public int extractNumber (@ModelAttribute String num, String num2, String num3){
		 if(num == null || num.isEmpty()) return (Integer) null;
		 if(num2 == null || num2.isEmpty()) return (Integer) null;
		 if(num3 == null || num3.isEmpty()) return (Integer) null;
		 
		 int a = Integer.parseInt(num);
		 int b = Integer.parseInt(num2);
		 int c = Integer.parseInt(num3);
		 
		 int digitsNum = a * b + c;
		 
		
		 
		return digitsNum;
	}
	public List<String> extractDigit(@ModelAttribute int digitsNum){
		 
		while(digitsNum < 0) {
			 this.result += digitsNum % 10;
			 digitsNum /= 10;
			 
		 }
		 resultList.clear();
		 resultList.add(result);
		
		 return resultList;
	}
}
