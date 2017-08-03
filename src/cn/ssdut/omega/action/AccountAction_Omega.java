/**
 * 
 */
package cn.ssdut.omega.action;


import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.ssdut.omega.constant.Constants_Omega;
import cn.ssdut.omega.constant.Logger_Omega;
import cn.ssdut.omega.entity.Cart_Omega;
import cn.ssdut.omega.entity.Manager_Omega;
import cn.ssdut.omega.entity.Shop_Omega;
import cn.ssdut.omega.entity.User_Omega;
import cn.ssdut.omega.management.AccountManagement_Omega;
import cn.ssdut.omega.management.CartManagement_Omega;
import cn.ssdut.omega.management.ShopManagement_Omega;
import cn.ssdut.omega.sqlutil.SQLHelper_Omega;
import cn.ssdut.omega.util.SessionUtil_Omega;

/**
 * @author Kevin
 * @date 2017-07-14
 * 注册动作类
 */
public class AccountAction_Omega extends BaseAction_Omega{

	
	public static final String TYPE_USER="user";
	public static final String TYPE_MANAGER="manager";
	
	/**
	 * 管理员和用户信息部分
	 * */
	private String account;
	//账户名
	private String password;
	//密码
	private String mail;
	//邮箱
	private String phone;
	//电话
	private String address;
	//地址
	private String postCode;
	//邮编

	private String name;
	//真实姓名
	
	private User_Omega user;
	private Manager_Omega manager;
	
	/**
	 * 邮箱验证部分
	 * */
	
	private String validateCode;
	private String type;
	private long userId;
	
	/**
	 * @return string
	 * 注册普通用户
	 * */
	public String registerUser(){
		if(account.length()==0||password.length()==0||mail.length()==0){
			return EMPTY;
		}
		AccountManagement_Omega management = new AccountManagement_Omega();
		User_Omega user = new User_Omega();
		user.setAccount(account);
		user.setPassword(password);
		user.setAddress(address);
		user.setPhone(phone);
		user.setMail(mail);
		user.setPostCode(postCode);
		if(management.register(user)){
			this.user=user;
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * @return string
	 * 注册管理者
	 * */
	public String registerManager(){
		if(account.length()==0||password.length()==0||mail.length()==0){
			return EMPTY;
		}
		AccountManagement_Omega management = new AccountManagement_Omega();
		Manager_Omega manager = new Manager_Omega();
		manager.setAccount(account);
		manager.setPassword(password);
		manager.setMail(mail);
		manager.setPhone(phone);
		manager.setName(name);
		if(management.register(manager)){
			this.manager=manager;
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * 保持登陆状态
	 * */
	private void keepAlive(String type){
		ActionContext ctx = ActionContext.getContext();       
		HttpServletRequest request =(HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);    
		HttpServletResponse response = (HttpServletResponse)  
		ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE); 
        HttpSession session = request.getSession();  
        // 手动设置session的有效期为30分钟  
        String sessionId = session.getId();  
        Cookie cookie = new Cookie("JSESSIONID", sessionId);  
        cookie.setMaxAge(60 * 30);  
        cookie.setPath(request.getContextPath());  
        response.addCookie(cookie);  
        // 登录成功后要存入用户的登录状态 
        session.setAttribute("type", type);
        if(type.equals(TYPE_USER)){
        	session.setAttribute("user", user);
        	CartManagement_Omega cartManagement_Omega=new CartManagement_Omega();
        	Cart_Omega cart =cartManagement_Omega.findByUserId(user.getId());
        	if(cart==null){
        		cart = new Cart_Omega();
        		cart.setCost(0);
        		cart.setUser(user);
        		cartManagement_Omega.buildCart(cart);
        	}
          	session.setAttribute("cart",cart);
        }else if (type.equals(TYPE_MANAGER)){
        	 session.setAttribute("manager", manager);
        	 ShopManagement_Omega shopManagement_Omega = new ShopManagement_Omega();
        	 List<Shop_Omega> shops=shopManagement_Omega.findShopByManagerId(manager.getId());
        	 session.setAttribute("shop", shops);
        }
	}
	
	
	
	/**
	 * 用户注销
	 * */
	public String logout(){
		ActionContext ctx = ActionContext.getContext();       
		HttpServletRequest request =(HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession(false);
		session.removeAttribute("user");
		session.removeAttribute("manager");
		session.removeAttribute("type");
		session.removeAttribute("cart");
		session.removeAttribute("shop");
		return SUCCESS;
	}
	
	/**
	 * @return string
	 * 登录普通用户
	 * */
	public String loginUser(){
		if(account.length()==0||password.length()==0){
			return EMPTY;
		}
		AccountManagement_Omega management = new AccountManagement_Omega();
		User_Omega user=management.loginUser(account, password);
		if(user!=null){
			this.setUser(user);
		    keepAlive("user");
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * @return string
	 * 登录管理员
	 * */
	public String loginManager(){
		if(account.length()==0||password.length()==0){
			return EMPTY;
		}
		AccountManagement_Omega management = new AccountManagement_Omega();
		Manager_Omega manager=management.loginManager(account, password);
		if(manager!=null){
			this.setManager(manager);
		    keepAlive("manager");
			return SUCCESS;
		}
		return ERROR;
	}
	
	
	/**
	 * 验证邮箱
	 * */
	public String validateMail(){
			SQLHelper_Omega helper = new SQLHelper_Omega();
			if(type.equals(Constants_Omega.TYPE_MANAGER)){
				Manager_Omega manager = helper.findManagerById(userId);
				if(manager!=null&&manager.getValidateCode().equals(validateCode)){
					manager.setMailStatus(Manager_Omega.VALIDATE);
					helper.update(manager);
					Logger_Omega.error("------------------------manager validate succ");
					return SUCCESS;
				}else{
					Logger_Omega.error("------------------------manager is null validate failed");
					return ERROR;
				}
			}else if(type.equals(Constants_Omega.TYPE_USER)){
				User_Omega user = helper.findUserById(userId);
				Logger_Omega.error(""+user);
				if(user!=null&&user.getValidateCode().equals(validateCode)){
					user.setMailStatus(User_Omega.VALIDATE);
					helper.update(user);
					Logger_Omega.error("------------------------user validate succ");
					return SUCCESS;
				}else{
					Logger_Omega.error("------------------------user is null validate failed");
					return ERROR;
				}
			}
			Logger_Omega.error("------------------------type error validate email");
			return ERROR;
	}


	
	/**
	 * 用户信息修改
	 * @return string
	 * */
	
	public String updateUser(){
		User_Omega user=SessionUtil_Omega.getLoginUser();
		if(user==null){
			return UNLOGIN;
		}
		if(password.length()!=0)
			user.setPassword(password);
		if(phone.length()!=0)
			user.setPhone(phone);
		if(address.length()!=0)
			user.setAddress(address);
		if(postCode.length()!=0)
			user.setPostCode(postCode);
		AccountManagement_Omega management = new AccountManagement_Omega();
		if(management.update(user))
		   return SUCCESS;
		return ERROR;
	}
	
	/**
	 * 管理员信息修改
	 * @return string
	 * */
	public String updateManager(){
		Manager_Omega manager=SessionUtil_Omega.getLoginManager();
		if(manager==null){
			return UNLOGIN;
		}
		if(password!=null)
			manager.setPassword(password);
		if(phone!=null)
			manager.setPhone(phone);
		if(name!=null)
			manager.setName(name);
		AccountManagement_Omega management = new AccountManagement_Omega();
		if(management.update(manager))
		   return SUCCESS;
		return ERROR;
	}
	
	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the validateCode
	 */
	public String getValidateCode() {
		return validateCode;
	}

	/**
	 * @param validateCode the validateCode to set
	 */
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the user
	 */
	public User_Omega getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User_Omega user) {
		this.user = user;
	}

	/**
	 * @return the manager
	 */
	public Manager_Omega getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Manager_Omega manager) {
		this.manager = manager;
	}
	
	

}
