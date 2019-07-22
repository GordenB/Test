package de.Gorden.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class RoundingService {

	private List<Double> results = new ArrayList<>();
	Model model;

	public List<Double> getResults() {
		return results;
	}

	public List<Double>roundNums(@ModelAttribute String zahl1, String zahl2) {
		try
		{	
			double erste = Double.parseDouble(zahl1);
			double zweite = Double.parseDouble(zahl2);
			double answer = erste / zweite ;
			double rounded = Math.round(answer);
			results.add(rounded);
		}
		catch (NumberFormatException ex){
			//model.addAttribute("falscheEingabe", true);
			results.add(Math.E);
			
		}
		finally {

		}

		return results;
	}
	
}
