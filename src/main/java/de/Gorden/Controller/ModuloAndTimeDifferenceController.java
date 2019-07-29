package de.Gorden.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.Gorden.Services.ModuloAndTimeDifferenceService;

@SessionAttributes("username")
@Controller
public class ModuloAndTimeDifferenceController {

	@Autowired
	ModuloAndTimeDifferenceService service;
	
	@RequestMapping(value="/timeDifferenz", method=RequestMethod.GET)
	public String showForm() {
		return "timeDifferenz";
	}

	@RequestMapping(value="/timeDifferenz", method=RequestMethod.POST)
	public String handleUserInput(ModelMap model, String numbers) {
		
		int timeDiff = service.extractNumber(numbers);
		List<String> result = service.calcTimeDiff(timeDiff);
		
		model.put("Array", timeDiff);
		model.put("ergebnis", result);
		
		if(result == null) {
			model.addAttribute("nullList", true);
		}
		
		return "timeDifferenz";
		
	}
}
