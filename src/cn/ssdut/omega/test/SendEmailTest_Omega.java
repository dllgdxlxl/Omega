/**
 * 
 */
package cn.ssdut.omega.test;

import cn.ssdut.omega.constant.Constants_Omega;
import cn.ssdut.omega.entity.User_Omega;
import cn.ssdut.omega.util.SendMail_Omega;

/**
 * @author Kevin
 * @date 2017-07-13
 * 用于发送注册邮件测试
 */
public class SendEmailTest_Omega {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {

				User_Omega user = new User_Omega();
				user.setId(12345);
				user.setMail("1905692338@qq.com");
				user.setValidateCode("ashsadfhsdfsdfsd4dfd2f1df1");
				SendMail_Omega send = new SendMail_Omega();
				boolean isSucc=send.sendEmail(user.getId(),user.getValidateCode(),user.getMail(),Constants_Omega.TYPE_USER);
				System.out.println(isSucc);
			}
		});
		thread.start();
	}

}
