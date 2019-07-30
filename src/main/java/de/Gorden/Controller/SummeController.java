package de.Gorden.Controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.Gorden.Form.Issue;


@Controller
@RequestMapping(value="/summe", method=RequestMethod.GET)
public class SummeController {
	
	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("issue", new Issue());
		return "summe-form";
	}
	
	@RequestMapping(value="/processForm", method=RequestMethod.POST)
	public String processForm(
			@Valid @ModelAttribute("issue") Issue theIssue,
			BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()) {
			
			return "summe-form";
		}else {
			Integer ergebnis = theIssue.getErgebnis();
			
			return "summe-result";
		}
		
	}

}
