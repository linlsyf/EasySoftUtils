/**
 * 
 */
package com.easysoft.utils.lib.system;

import android.content.Context;
import android.content.Intent;

import java.io.Serializable;

/**
 * 创建者：qjt
 * 修改时间：2015-5-25 下午5:43:29
 * 作用：发送广播工具
 */

public class BroadcastUtils {

	public static void sendBroadCast(Context context,Object... objects){
	}
	
	public static void sendBroadCast(Context context,String action,String typeKey,String modenKey,String type,Object obj){
		Intent intent = new Intent(action);
		intent.putExtra(typeKey, type);
		intent.putExtra(modenKey,(Serializable)obj);
		context.sendBroadcast(intent);
	}
	
	
	
}
