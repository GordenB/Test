package de.Gorden.Controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import de.Gorden.Form.Person;


@Controller
@RequestMapping("/person")
public class PersonConfirmationController {
	
//	@Value("#{countryOptions}") 
//    private Map<String, String> countryOptions;
//	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {
		theModel.addAttribute("person", new Person());
		//theModel.addAttribute("theCountryOptions", countryOptions);
		return "person-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("person") Person thePerson,
			BindingResult theBindingResult) {
		if(theBindingResult.hasErrors()) {
			return "person-form";
		}else {
			return "person-confirmation";
		}
		
	}
}
