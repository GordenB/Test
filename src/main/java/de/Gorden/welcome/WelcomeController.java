package de.Gorden.welcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@SessionAttributes("name")
@Controller
public class WelcomeController {
	
	

		@GetMapping("/welcome")
		public String showAbbeyPage(Model model) {
			return "welcome";
		}
		
		
		}
	

