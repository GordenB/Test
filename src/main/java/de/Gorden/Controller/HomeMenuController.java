package de.Gorden.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("username")
@Controller
public class HomeMenuController {

	@RequestMapping (value="/home", method=RequestMethod.GET)
	public String showHomeForm() {
		// return http page name
		return "home";
	}
}
