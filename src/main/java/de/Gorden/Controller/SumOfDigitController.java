package de.Gorden.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	public String handleUserInput(@ModelAttribute(name="sumOfDigitForm") SumOfDigitForm form, Model model){
		try {
			int digitsNum = service.extractNumber(form.getNum(), form.getNum2(), form.getNum3());
			model.addAttribute("Array", digitsNum);
			model.addAttribute("ergebnis", digitsNum);
		} catch (Exception e) {
			// Wenn man das so macht, dann fängt man JEDE Exception. 
			// Wenn das eine Excpetion ist, die nix mit der Anwendung zu tun hat (e.g. Speicher), dann
			// wird man hier Verhalten haben, die unvorhersehbar sind. 
			e.printStackTrace();
			model.addAttribute("invalideValue", true);
		}
		
		return "sumOfDigit";
	}
}
