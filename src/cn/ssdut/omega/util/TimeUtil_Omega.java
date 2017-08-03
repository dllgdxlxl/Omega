/**
 * 
 */
package cn.ssdut.omega.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Kevin
 * @date 2017-07-14
 * 时间工具类
 */
public class TimeUtil_Omega {

	public static String getNowTime(){
		  SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		  return dateformat1.format(new Date()); 
	}
	
	public static long getTime(){
		return (new Date()).getTime();
	}
}
