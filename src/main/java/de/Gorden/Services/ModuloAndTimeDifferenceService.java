package de.Gorden.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
public class ModuloAndTimeDifferenceService {

	private List<String> resultList = new ArrayList<>();
	private Integer[] results = null;
	
	public List<String> getResultList() {
		return resultList;
	}
	

	public int extractNumber (@ModelAttribute String number){
		 if(number == null || number.isEmpty()) return (Integer) null;
		 
		 String[] splitNum = number.split(" ");
		 int[] num = new int[8];
		 
		for(int i = 0 ; i < splitNum.length ; i++) {
			 num[i] = Integer.parseInt(splitNum[i]);
		 }
		
		num[0] = num[0]*60*60*24;
		num[4] = num[4]*60*60*24;
		
		num[1] = num[1]*60*60;
		num[5] = num[5]*60*60;
		
		num[2] = num[2]*60;
		num[6] = num[6]*60;
		
		// stamps	
		int time1 = num[0]+num[1]+num[2]+num[3];
		int time2 = num[4]+num[5]+num[6]+num[7];
		
		// find difference
		
	
		int stampDiff = time2-time1;
		return stampDiff;
		
		
		 
		
	}
	public List<String> calcTimeDiff(@ModelAttribute int stampDiff){
		 
		results[0] = stampDiff/60/60/24;
		results[1] = stampDiff/60/60%24;
		results[2] = stampDiff/60%60;
		results[3] = stampDiff%60;
		
		String result = "(%d %d %d %d)", results;
		
		 resultList.clear();
		resultList.add(result);
		
		 return resultList;
	}
}
