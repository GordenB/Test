package de.Gorden.Services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class SumOfDigitService {
	
	private List<String> resultList = new ArrayList<>();
	public List<String> getResultList() {
		return resultList;
	}

	// Wofür ist das?
	private ModelMap model;
	
	// Für eine Berechnung innerhalb einer Methode ist hier eine Membervarliable notwendig?
	// Das haben wir im Codereview anders gelernt.
	private int remainder;
	
	// Das Ergebnis könnte auch lokaler definiert werden, dann bleibt dieser Service stateless. 
	private String result = "0";
	

	// Die bennenung der Methode ist suboptimal
	// Die Annotation @ModelAttribute macht hier nix. 
	// Rechnen wir damit, dass die Summe von 3 Zahlen mehrere Strings ergibt? Wenn nein, ist hier der RÜckgabewert nicht richtig gewählt.
	public List<String> extractNumbers (@ModelAttribute String num, String num2, String num3){
		 if(num == null || num.isEmpty()) return null;
		 if(num2 == null || num2.isEmpty()) return null;
		 if(num3 == null || num3.isEmpty()) return null;
		 
		 int a = Integer.parseInt(num);
		 int b = Integer.parseInt(num);
		 int c = Integer.parseInt(num);
		 
		 // Ist klar, was hier passiert?
		 int digitsNum = a * b + c;
		 
		 while(digitsNum > 0) {
			 remainder = digitsNum % 10;
			 digitsNum /= 10;
			 result += remainder;
		 }
		 
		 // Die Ausgabe ist nicht korrekt schätze ich.
		 resultList.add(result);
		 
		return resultList;
	}
}
