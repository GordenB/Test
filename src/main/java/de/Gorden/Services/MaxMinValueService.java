package de.Gorden.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class MaxMinValueService {

	private List<Integer> zahlen = new ArrayList<>();
	Model model;


	public List<Integer> addNum(@ModelAttribute String zahl) {
		try
		{	
			int parseInt = Integer.parseInt(zahl);
			zahlen.add(parseInt);
		}
		catch (NumberFormatException ex){
			//model.addAttribute("falscheEingabe", true);
			zahlen.add(0);
			
		}
		finally {

		}

		return zahlen;
	}

	public Integer getMaxInteger() {
		int max = Integer.MIN_VALUE;
		for( Integer i : zahlen ) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}
	public Integer getMinInteger() {
		int min = Integer.MAX_VALUE;
		for(Integer i : zahlen) {
			if(i < min) {
				min = i;
			}
		}
		return min;
	}

	
}
