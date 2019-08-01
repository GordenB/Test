package de.Gorden.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.Gorden.Form.MaxMinInListForm;
import de.Gorden.Services.MaxMinValueService;
@SessionAttributes("username")
@Controller
public class MaxMinIntInListController {
	
	@Autowired
	private MaxMinValueService service;
	
	@RequestMapping (value="/maxMinIntInList-form", method=RequestMethod.GET)
	public String showForm(Model theModel) {
		theModel.addAttribute("issue", new MaxMinInListForm());
		// return http page name
		return "maxMinIntInList-form";
	}

	
	@RequestMapping (value = "/maxMinIntInList-form", method=RequestMethod.POST)
	public String processForm(@Valid @ModelAttribute("issue") MaxMinInListForm theIssue,
			BindingResult theBindingResult, Model model) {
		

		if(theBindingResult.hasErrors()) {
			
			return "maxMinIntInList-form";
		}else {
			
			List<Integer> answerList = service.extractNumber(theIssue.getFieldOne());
			model.addAttribute("Array", answerList);
			model.addAttribute("resultMin", service.getMinInteger());
			model.addAttribute("resultMax", service.getMaxInteger());
			
			return "maxMinIntInList-form";
		}
		
	
}
}
