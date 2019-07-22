package de.Gorden.CodeAbbeyAufgaben;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
@SessionAttributes("name")
@Controller
public class MaxValueListController {
	
	@Autowired
	private AbbeyService service;

	@GetMapping("/abbey")
	public String showAbbeyPage(Model model) {
		return "abbey";
	}
	
	@PostMapping(value = "/abbey")
	public String handleUserInput(ModelMap model, @RequestParam String zahlen) {
		List<Integer> addNum = service.addNum(zahlen);
		
		model.put("Array", addNum);
		model.put("ergebnis", service.getMaxInteger());
		return "abbey";
	}
	
}
