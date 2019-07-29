package de.Gorden.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class RoundingService {

	private List<Double> resultList = new ArrayList<>();
	private Model model;

	public List<Double> getResults() {
		return resultList;
	}

	public List<Double>roundNums(@ModelAttribute String num1, String num2) {
		
		try
		{	
			double number = Double.parseDouble(num1);
			double number2 = Double.parseDouble(num2);
			double answer = number / number2 ;
			double rounded = Math.round(answer);
			resultList.add(rounded);
		}
		catch (NumberFormatException ex){
			
			resultList.add(0.0);
			
		}
		finally {

		}

		return resultList;
	}
	
}
