package de.Gorden.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class MaxMinValueService {

	private List<Integer> intList = new ArrayList<>();
	
	
	public List<Integer> extractNumber(@ModelAttribute String number) {                

	    if(number == null || number.isEmpty()) return null;

	    StringBuilder sb = new StringBuilder();
	    boolean found = false;
	    for(char c : number.toCharArray()){
	        if(Character.isDigit(c)){
	            sb.append(c);
	            found = true;
	        } else if(found){
	            // If we already found a digit before and this char is not a digit, stop looping
	            break;                
	        }
	    }
	    String strNum = sb.toString();
	    int parseInt = Integer.parseInt(strNum);
	    intList.add(parseInt);
	    return intList;
	    
	}

	
	

	public Integer getMaxInteger() {
		int max = Integer.MIN_VALUE;
		for( Integer i : intList ) {
			if(i > max) {
				max = i;
			}
		}
		return max;
	}
	public Integer getMinInteger() {
		int min = Integer.MAX_VALUE;
		for(Integer i : intList) {
			if(i < min) {
				min = i;
			}
		}
		return min;
	}

	
}
