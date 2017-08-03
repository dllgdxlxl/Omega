package cn.ssdut.omega.util;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cn.ssdut.omega.constant.Constants_Omega;
import cn.ssdut.omega.constant.Logger_Omega;

/**
 * @author Kevin
 * @date 2017-07-13
 * 发送注册邮件
 * */
public class SendMail_Omega {


	/**
	 * @param id
	 * @param validateCode
	 * @param mail
	 * @param type
	 * @return boolean
	 * 实现发送注册邮件功能
	 * */
	public  boolean sendEmail(long id,String validateCode,String mail,String type){
		try{
            Session session = Session.getInstance(Constants_Omega.EMAIL_PROPERTIES,new Authenticator() {  
                // 认证信息，需要提供"用户账号","授权码"  
                public PasswordAuthentication getPasswordAuthentication() {  
                  return new PasswordAuthentication(Constants_Omega.EMAIL_SEND_USERNAME, Constants_Omega.EMAIL_VALI_CODE);  
                }  
              });
            session.setDebug(true);
            Transport ts = session.getTransport();
            ts.connect(Constants_Omega.EMAIL_HOST, Constants_Omega.EMAIL_SEND_USERNAME, 
            		Constants_Omega.EMAIL_SEND_PASSWORD);
            Message message = createEmail(session,id,validateCode,mail,type);
            ts.sendMessage(message, message.getAllRecipients());
            ts.close();
            return true;
		}catch(Exception e){
			Logger_Omega.error("send register mail failed");
			e.printStackTrace();
		}
		
		return false;
	}
	
	private  Message createEmail(Session session,long id,String validateCode,String mail,String type) throws Exception{
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(Constants_Omega.EMAIL_SEND_ADDRESS));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail));
        message.setSubject("用户注册邮件");
        StringBuffer sb=new StringBuffer("Omega商城注册成功，请点击下面链接激活账号，请尽快激活！</br>");  
        sb.append("<a href=\""+Constants_Omega.EMAIL_VALIDATE_URL+"?userId=");  
        sb.append(id);   
        sb.append("&validateCode=");   
        sb.append(validateCode);
        sb.append("&type=");
        sb.append(type);
        sb.append("\">"+Constants_Omega.EMAIL_VALIDATE_URL+"?userId=");   
        sb.append(id);  
        sb.append("&validateCode=");  
        sb.append(validateCode);  
        sb.append("&type=");
        sb.append(type);
        sb.append("</a>");  
        String info = sb.toString();
        Logger_Omega.error(info);
        message.setContent(info, "text/html;charset=UTF-8");
        message.saveChanges();
        return message;
	}
	
}
