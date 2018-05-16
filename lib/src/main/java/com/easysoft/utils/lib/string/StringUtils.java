package com.easysoft.utils.lib.string;

public class StringUtils {

	public static  boolean isBlank(String txt){
		boolean  flag=false;
		 if(txt==null||txt.trim().equals("")){
			 flag=true;
			 return flag;
		 }
	
		return flag;
	}
	public static  boolean isNotEmpty(String txt){
		boolean  flag=true;
		if(txt==null||txt.trim().equals("")){
			flag=false;
			return flag;
		}
		
		return flag;
	}
}
