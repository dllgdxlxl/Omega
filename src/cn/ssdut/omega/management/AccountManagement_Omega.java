package cn.ssdut.omega.management;

import java.util.Date;

import cn.ssdut.omega.constant.Constants_Omega;
import cn.ssdut.omega.entity.Manager_Omega;
import cn.ssdut.omega.entity.User_Omega;
import cn.ssdut.omega.sqlutil.SQLHelper_Omega;
import cn.ssdut.omega.util.MD5Util_Omega;
import cn.ssdut.omega.util.SendMail_Omega;

/**
 * @author kevin
 * @date 2017-07-13
 * 账户的管理类
 * */
public class AccountManagement_Omega {

	private SQLHelper_Omega helper;
	//数据库操作类
	
	/**
	 * 默认构造函数，初始化helper
	 * */
	public AccountManagement_Omega(){
		helper = new SQLHelper_Omega();
	}
	
	/**
	 * @param user
	 * @return boolean
	 * 注册普通用户，并返回注册状态
	 * */
	public boolean register(User_Omega user){
		//设置用于的验证状态为未验证
		user.setMailStatus(User_Omega.UNVALIDATE);
		user.setValidateCode(getValidateCode());
		if(!helper.save(user))
			return false;
		System.out.println(user.getId());
		SendMail_Omega sendMail = new SendMail_Omega();
		boolean status=sendMail.sendEmail(user.getId(), 
				user.getValidateCode(), user.getMail(), Constants_Omega.TYPE_USER);
		return status;
	}
	
	
	/**
	 * @param Manager
	 * @return boolean
	 * 注册管理员用户，并返回注册状态
	 * */
	public boolean register(Manager_Omega manager){
		//设置用于的验证状态为未验证
		manager.setMailStatus(User_Omega.UNVALIDATE);
		manager.setValidateCode(getValidateCode());
		if(!helper.save(manager))
			return false;
		SendMail_Omega sendMail = new SendMail_Omega();
		boolean status=sendMail.sendEmail(manager.getId(), 
				manager.getValidateCode(), manager.getMail(), Constants_Omega.TYPE_MANAGER);
		
		return status;
	}
	
	/**
	 * @param user
	 * 更新普通用户
	 * */
	public boolean update(User_Omega user){
		return helper.update(user);
	}
	
	/**
	 * @param manager
	 * 更新管理员
	 * */
	public boolean update(Manager_Omega manager){
		return helper.update(manager);
	}
	/**
	 * @param account
	 * @param password
	 * @return user or null
	 * 从数据库中查找用户信息进行密码比对
	 * */
	public User_Omega loginUser(String account,String password){
		User_Omega user = helper.findUserByAccount(account);
		if(user!=null && user.getPassword().equals(password)
				&&user.getMailStatus()==User_Omega.VALIDATE){
			return user;
		}
		return null;
	}
	
	/**
	 * @param account
	 * @param password
	 * @return manager or null
	 * 从数据库中查找管理员信息进行密码比对
	 * */
	public Manager_Omega loginManager(String account,String password){
		Manager_Omega manager = helper.findManagerByAccount(account);
		if(manager!=null && manager.getPassword().equals(password)
				&&manager.getMailStatus()==Manager_Omega.VALIDATE){
			return manager;
		}
		return null;
	}
	
	
	/**
	 * @return ValidateCode
	 * 将时间转换为MD5字符串
	 * */
	private String getValidateCode(){
		Date date = new Date();
		Long time = date.getTime();
		String validateCode=MD5Util_Omega.changeToMD5(time.toString());
		return validateCode;
	}
}
