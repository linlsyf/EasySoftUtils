package com.easysoft.utils.lib.system;


import com.easysoft.utils.lib.string.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * <br>创建者：qjt
 * <br>修改时间：2015年8月27日 下午4:45:54
 * <br>作用：
 */
public class PasswordUtils {
	
	/**
	 * 
	 * 创建者：qjt
	 * 时间：2015年8月27日 下午4:49:47
	 * 注释：验证是否符合登录密码要求
	 * @param loginPsw
	 * @return
	 */
	public static boolean conformLoginPsw(String loginPsw){
		if(StringUtils.isBlank(loginPsw)){
			return false;
		}
//		String expression = "^(?[0-5]+$)(?[a-zA-Z]+$)[0-9a-z!@%*]{6,16}$";//规定字母跟数字6到16位
		
		//必须至少包含一个数字 以及一个字母  长度为6-16位
		String expression = "(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[-`=\\[\\];',./~!@#$%^&*()_+|{}:\"<>?]+$).{6,18}";
		
		
		Pattern pattern =  Pattern.compile(expression);
		Matcher matcher = pattern.matcher(loginPsw);
		return matcher.matches();
	}
	/**
	 *创建者 王婷玉
	 *时间2015-11-26下午5:08:36
	 *注释：固定号码的验证
	 * @return 
	 */
	public static boolean conformChangelessPhone(String phone) {
		//增加限制，只限阿拉伯数字和“-”符
		String expression ="[[0-9]-]+";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}
	
}
