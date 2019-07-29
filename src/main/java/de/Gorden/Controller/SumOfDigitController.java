package de.Gorden.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.Gorden.Services.SumOfDigitService;

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
		List<String> resultSet = service.extractNumbers(num, num2, num3);
		
		model.put("Array", resultSet);
		model.put("ergebnis", service.getResultList());
		
		if(resultSet == null) {
			model.addAttribute("nullList", true);
		}
		
		return "sumOfDigit";
		
	}
}
