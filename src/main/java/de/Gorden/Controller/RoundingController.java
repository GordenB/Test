package de.Gorden.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import de.Gorden.Services.RoundingService;

@Controller
public class RoundingController {

	@Autowired
	private RoundingService service;
	
	
	@RequestMapping (value="/rounding", method=RequestMethod.GET)
	public String getLoginForm() {
		// return http page name
		return "rounding";
	}
	@RequestMapping (value = "/rounding", method=RequestMethod.POST)
	public String handleUserInput(ModelMap model, @RequestParam String zahl1, String zahl2) {
		List<Double> list = service.roundNums(zahl1, zahl2);
		
		
		model.put("Array", list);
		model.put("ergebnis", service.getResults());
		return "rounding";
	}
}
