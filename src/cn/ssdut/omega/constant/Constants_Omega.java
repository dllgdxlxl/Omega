package cn.ssdut.omega.constant;


import java.security.GeneralSecurityException;
import java.util.Properties;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * @author Kevin
 * @date 2017-07-12
 * Constants类，进行静态常量的定义
 * */
public class Constants_Omega {

	//数据库相关变量
	public static final String SQL_USERNAME="root";
	public static final String SQL_PASSWORD="lixiangli";
	public static final String SQL_URL="jdbc:mysql://localhost:3306/omega";
	
    // 文件上传配置
    public static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    public static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    public static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
	
    //文件存储地址
	public static final String UPLOAD_DIRECTORY="images/upload";
    
	/*数据库相关语句*/
    //添加数据
	public static final String INSERT_USER="insert into users (account,password,mail,phone,address,postCode,validateCode,mailStatus) values (?,?,?,?,?,?,?,?)";
    public static final String INSERT_MANAGER="";
    public static final String INSERT_SHOP_PRODUCT="";
    public static final String INSERT_ORDER="";
    public static final String INSERT_CART="";
    public static final String INSERT_SHOP="";
    public static final String INSERT_CART_PRODUCT="";
    public static final String INSERT_ORDER_PRODUCT="";
    public static final String INSERT_REMARK="";
    //删除数据
    public static final String DELETE_SHOP="";
    public static final String DELETE_USER="";
    //更新数据
	public static final String UPDATE_USER="";
    public static final String UPDATE_MANAGER="";
    public static final String UPDATE_SHOP_PRODUCT="";
    public static final String UPDATE_ORDER="";
    public static final String UPDATE_CART="";
    public static final String UPDATE_SHOP="";
    public static final String UPDATE_CART_PRODUCT="";
    public static final String UPDATE_ORDER_PRODUCT="";
    public static final String UPDATE_REMARK="";
	//查找数据
    public static final String SELECT_USER_ACCOUNT="";
    public static final String SELECT_MANAGER_ACCOUNT="";
    public static final String SELECT_PRODUCT_CART_ID="";
	
	//项目名字
	public static final String PROJECT_NAME="Omega";
	
	
	/**
	 * 邮箱验证
	 * */

	//用于注册验证的用户类型
	public static final String TYPE_USER="user";
	public static final String TYPE_MANAGER="manager";
	
	//用于验证的网址
	public static final String EMAIL_VALIDATE_URL="http://localhost:8080/Omega/validateMail";
    //用于给用户发送邮件的邮箱
    public static final String EMAIL_SEND_ADDRESS = "omega_test@163.com";
    //邮箱的用户名
    public static final String EMAIL_SEND_USERNAME = "omega_test";
    //邮箱的密码
    public static final String EMAIL_SEND_PASSWORD = "lixiangli";
    //发送邮件的服务器地址
    public static final String EMAIL_HOST = "smtp.163.com";
	//用于邮箱验证的Property
    public static final String EMAIL_VALI_CODE="omega2017";
    //邮箱验证码
    public static final Properties EMAIL_PROPERTIES=new Properties();
    //定义Properties的参数
    static{
        Properties prop =EMAIL_PROPERTIES;
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.host", "smtp.163.com");   
        prop.setProperty("mail.smtp.auth", "true");  
        MailSSLSocketFactory sf=null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        // 设置信任所有的主机  
        sf.setTrustAllHosts(true);  
        prop.put("mail.smtp.ssl.enable", "true");  
        prop.put("mail.smtp.ssl.socketFactory", sf); 
    }
    
    
}
