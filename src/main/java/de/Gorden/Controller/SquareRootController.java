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

import de.Gorden.Form.SquareRootForm;
import de.Gorden.Services.SquareRootService;

@SessionAttributes("username")
@Controller
public class SquareRootController {
	
	@Autowired
	private SquareRootService service;

	@RequestMapping(value="/squareRoot", method=RequestMethod.GET)
	public String showForm(Model theModel) {
		theModel.addAttribute("issue", new SquareRootForm());
		return "squareRoot";
	}
	
	@RequestMapping(value="/squareRoot", method=RequestMethod.POST)
	public String processForm(@Valid @ModelAttribute("issue") SquareRootForm theIssue,
								BindingResult theBindingResult, Model theModel) {
		
		if(theBindingResult.hasErrors()) {
			return "squareRoot";
		}
		String[] values = service.splitInput(theIssue.getFieldOne());
		int calcs = Integer.parseInt(values[1]);
		double result = service.calculate(values);
		theModel.addAttribute("calcs", calcs);
		theModel.addAttribute("result", result);
		return "squareRoot";
	}
}
