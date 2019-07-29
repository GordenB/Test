package de.Gorden.Services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class SumOfDigitService {
	
	private List<String> resultList = new ArrayList<>();
	public List<String> getResultList() {
		return resultList;
	}


	private ModelMap model;
	private int remainder;
	private String result = "0";
	

	public List<String> extractNumbers (@ModelAttribute String num, String num2, String num3){
		 if(num == null || num.isEmpty()) return null;
		 if(num2 == null || num2.isEmpty()) return null;
		 if(num3 == null || num3.isEmpty()) return null;
		 
		 int a = Integer.parseInt(num);
		 int b = Integer.parseInt(num);
		 int c = Integer.parseInt(num);
		 
		 int digitsNum = a * b + c;
		 
		 while(digitsNum > 0) {
			 remainder = digitsNum % 10;
			 digitsNum /= 10;
			 result += remainder;
		 }
		 
		 resultList.add(result);
		 
		return resultList;
	}
}
