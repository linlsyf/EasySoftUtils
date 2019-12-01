package com.easysoft.utils.lib.string;

import android.content.ClipboardManager;
import android.content.Context;

public class StringUtils {


	public static void copy(Context context, String text){
		ClipboardManager cm = (ClipboardManager)context. getSystemService(Context.CLIPBOARD_SERVICE);
		cm.setText(text);
	}
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
