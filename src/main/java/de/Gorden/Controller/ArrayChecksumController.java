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

import de.Gorden.Form.ArrayChecksumForm;
import de.Gorden.Services.ArrayChecksumService;

@SessionAttributes("username")
@Controller
public class ArrayChecksumController {
	
	@Autowired
	private ArrayChecksumService service;

	@RequestMapping(value="/arrayChecksum", method=RequestMethod.GET)
	public String showForm(Model theModel) {
		theModel.addAttribute("issue", new ArrayChecksumForm());
		return "arrayChecksum";
	}
	
	@RequestMapping(value="/arrayChecksum", method=RequestMethod.POST)
	public String processForm(@Valid @ModelAttribute("issue") ArrayChecksumForm theIssue,
								BindingResult theBindingResult, Model theModel ) {
		
	if(theBindingResult.hasErrors()) {
		return "arrayChecksum";
	}
	String[] number = service.splitInput(theIssue.getFieldOne());
	int numCount = number.length;
	int result = service.checkSum(number);
	theModel.addAttribute("numCount", numCount);
	theModel.addAttribute("result", result);
		return "arrayChecksum";
	}
}
