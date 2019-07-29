package de.Gorden.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.Gorden.Services.SumOfDigitService;

@SessionAttributes("username")
@Controller
public class SumOfDigitController {

	@Autowired
	SumOfDigitService service;
	
	@RequestMapping(value="/sumOfDigit", method=RequestMethod.GET)
	public String showForm() {
		return "sumOfDigit";
	}
	
	@RequestMapping(value="/sumOfDigit", method=RequestMethod.POST)
	public String handleUserInput(ModelMap model, String num, String num2, String num3) {
		
		int digitsNum = service.extractNumber(num, num2, num3);
			List<String> result = service.extractDigit(digitsNum);
		
		model.put("Array", digitsNum);
		model.put("ergebnis", service.getResultList());
		
		if(result == null) {
			model.addAttribute("nullList", true);
		}
		
		return "sumOfDigit";
		
	}
}
