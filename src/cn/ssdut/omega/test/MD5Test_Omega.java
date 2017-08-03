/**
 * 
 */
package cn.ssdut.omega.test;

import cn.ssdut.omega.util.MD5Util_Omega;

/**
 * @author Kevin
 * @date 2017-07-13
 * MD5工具测试类
 */
public class MD5Test_Omega {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String test="abcdefg";
		System.out.println(MD5Util_Omega.changeToMD5(test));
	}

}
