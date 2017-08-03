package cn.ssdut.omega.constant;


/**
 * @author Kevin
 * @date 2017-07-12
 * Logger类，进行错误信息的输出
 * */
public class Logger_Omega {

	public static boolean isLog=true;
	//是否在控制台输出错误
	
	/**
	 * 在控制台输出错误
	 * @param content;
	 * */
	public static void error(String content){
		if(isLog){
			System.out.println(content);
		}
	}
	
    /**
     * @param islog
     * set isLog to islog
     * */
	public static void setIsLog(boolean islog){
		isLog=islog;
	}
}
