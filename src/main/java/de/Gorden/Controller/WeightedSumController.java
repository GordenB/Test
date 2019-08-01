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

import de.Gorden.Form.WeightedSumForm;
import de.Gorden.Services.WeightedSumService;

@SessionAttributes("username")
@Controller
public class WeightedSumController {

	@Autowired
	private WeightedSumService service;
	
	@RequestMapping(value="/weightedSum-form", method=RequestMethod.GET)
	public String showSumForm(Model theModel) {
		theModel.addAttribute("issue", new WeightedSumForm());
		return "weightedSum-form";
	}
	
	@RequestMapping(value="/weightedSum-form", method=RequestMethod.POST)
	public String processForm(
			@Valid @ModelAttribute("issue") WeightedSumForm theIssue,
			BindingResult theBindingResult, Model theModel) {
		
		if(theBindingResult.hasErrors()) {
			
			return "weightedSum-form";
		}else {
			Integer result = service.iterate(theIssue.getFieldOne());
			theModel.addAttribute("ergebnis", result);
			
			return "weightedSum-form";
		}
		
	}
}
