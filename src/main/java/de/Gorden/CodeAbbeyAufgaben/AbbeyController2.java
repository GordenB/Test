package de.Gorden.CodeAbbeyAufgaben;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
@SessionAttributes("zahlen")
@Controller
public class AbbeyController2 {
	
	@Autowired
	private AbbeyService service;

	@RequestMapping("/abbey2")
	public String showAbbeyPage2(Model model) {
		return "abbey2";
	}
	
	
	}
	
	

