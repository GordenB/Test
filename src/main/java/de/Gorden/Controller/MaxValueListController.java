package de.Gorden.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.Gorden.Services.MaxMinValueService;
@SessionAttributes("username")
@Controller
public class MaxValueListController {
	
	@Autowired
	private MaxMinValueService service;
	
	@RequestMapping (value="/maxMinIntInList", method=RequestMethod.GET)
	public String getLoginForm() {
		// return http page name
		return "maxMinIntInList";
	}

	
	@RequestMapping (value = "/maxMinIntInList", method=RequestMethod.POST)
	public String handleUserInput(ModelMap model, @RequestParam String zahlen) {
		List<Integer> addNum = service.addNum(zahlen);
		
		model.put("Array", addNum);
		model.put("ergebnisMin", service.getMinInteger());
		model.put("ergebnisMax", service.getMaxInteger());
		return "maxMinIntInList";
	}
	
}
