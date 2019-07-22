package de.Gorden.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import de.Gorden.form.LoginForm;
@SessionAttributes("username")
@Controller	
public class LoginController {
	
	// to get login form page
	@RequestMapping (value="/login", method=RequestMethod.GET)
	public String getLoginForm() {
		// return http page name
		return "login";
	}
	// checking for login credentials
	@RequestMapping (value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute(name="loginForm") LoginForm loginForm , Model model) {
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		if(!"".equals(username) && "".equals(password)) {
			model.addAttribute("username", username);
			return "home";
		}
		// if username or password is wrong
		model.addAttribute("invalideCredentials", true);
		// returning again login page
		return "login";
	}
	
	
	
}