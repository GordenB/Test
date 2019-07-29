package de.Gorden.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.Gorden.Form.LoginForm;
import de.Gorden.Form.SumOfDigitForm;
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
	public String handleUserInput(@ModelAttribute(name="sumOfDigitForm") SumOfDigitForm form , Model model){
		int digitsNum = 0;
		String num = form.getNum();
		String num2 = form.getNum2();
		String num3 = form.getNum3();
		
		
		
		try {
			digitsNum = service.extractNumber(num, num2, num3);

			
		} catch (Exception e) {
			if ( num == null || num2 == null || num3 == null ){
				model.addAttribute("invalideValue", true);
				
				return "sumOfDigit";
			}
			e.printStackTrace();
		}
		
		model.addAttribute("Array", digitsNum);
		model.addAttribute("ergebnis", digitsNum);
		
		
		return "sumOfDigit";
		
	}
}
