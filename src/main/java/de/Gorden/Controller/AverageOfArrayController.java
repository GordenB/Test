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

import de.Gorden.Form.AverageOfArrayForm;
import de.Gorden.Services.AverageOfArrayService;

@SessionAttributes("username")
@Controller
public class AverageOfArrayController {
	
	@Autowired
	private AverageOfArrayService service;
	
	@RequestMapping(value="/averageOfArray", method=RequestMethod.GET)
	public String showForm(Model theModel) {
		theModel.addAttribute("issue", new AverageOfArrayForm());
		return "averageOfArray";
	}
	
	@RequestMapping(value="/averageOfArray", method=RequestMethod.POST)
	public String processForm(@Valid @ModelAttribute("issue") AverageOfArrayForm theIssue,
								BindingResult theBindingResult, Model theModel) {
		
		if(theBindingResult.hasErrors()) {
			return "averageOfArray";
		}
		String[] size = service.splitInput(theIssue.getFieldOne());
		int numCount = size.length;
		double result = service.getAverage(size);
		theModel.addAttribute("numCount", numCount);
		theModel.addAttribute("result", result);
		return "averageOfArray";
	}
}
