package com.haier.openplatform.showcase.util;

import java.util.ArrayList;
import java.util.List;

public final class PlantInfo {
	
	public static final List<String> getPlantInfo(String plantCode){
		List<String> info=new ArrayList<String>();
		String plant=Env.getProperty("P"+plantCode+".plant");
		if(plant!=null){
			info.add(plant);
		}else{
			info.add("Haier Appliances India Pvt. Ltd");
		}
		String loc=Env.getProperty("L"+plantCode+".address");
		if(loc!=null){
			info.add(loc);
		}else{
			info.add("Plot No. - C/0 Plot No. - 78/119, 78/120, 78/121, Extended Lal Dora, Bakoli, TIN No - 07280268135,Delhi – 110036");
		}
//		String tel=Env.getProperty("T"+plantCode+".phone");
//		info.add(tel);
		return info;
	}
}
