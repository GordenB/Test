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

import de.Gorden.Form.ModularCalculatorForm;
import de.Gorden.Form.WeightedSumForm;
import de.Gorden.Services.ModularCalculatorService;
import de.Gorden.Services.WeightedSumService;

@SessionAttributes("username")
@Controller
public class ModularCalculatorController {

	@Autowired
	private ModularCalculatorService service;
	
	@RequestMapping(value="/modularCalculator", method=RequestMethod.GET)
	public String showSumForm(Model theModel) {
		theModel.addAttribute("issue", new ModularCalculatorForm());
		return "modularCalculator";
	}
	
	@RequestMapping(value="/modularCalculator", method=RequestMethod.POST)
	public String processForm(
			@Valid @ModelAttribute("issue") ModularCalculatorForm theIssue,
			BindingResult theBindingResult, Model theModel) {
		
		if(theBindingResult.hasErrors()) {		
			return "modularCalculator";
		}else {
			String[] size = service.splitInput(theIssue.getFieldOne());
			int temp = service.calculate(size);
			Integer result = service.getResult();
			theModel.addAttribute("ergebnis", temp);
			
			return "modularCalculator";
		}
		
	}
}
