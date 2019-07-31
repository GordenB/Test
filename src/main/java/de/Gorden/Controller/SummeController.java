package de.Gorden.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.Gorden.Form.Issue;
import de.Gorden.Services.SummeService;

@SessionAttributes("username")
@Controller
public class SummeController {
	
	@Autowired
	private SummeService service;
	
	@RequestMapping(value="/summe-form", method=RequestMethod.GET)
	public String showSumForm(Model theModel) {
		theModel.addAttribute("issue", new Issue());
		return "summe-form";
	}
	
	@RequestMapping(value="/summe-form", method=RequestMethod.POST)
	public String processForm(
			@Valid @ModelAttribute("issue") Issue theIssue,
			BindingResult theBindingResult, Model theModel) {
		
		if(theBindingResult.hasErrors()) {
			
			return "summe-form";
		}else {
			Integer result = service.summieren(theIssue.getFieldOne(), theIssue.getFieldTwo());
			theModel.addAttribute("ergebnis", result);
			
			return "summe-form";
		}
		
	}

}
