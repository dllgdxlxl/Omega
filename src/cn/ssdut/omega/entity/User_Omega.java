package cn.ssdut.omega.entity;


/**
 * @author Kevin
 * @date 2017-07-12
 * User类，用来定义用户的各种属性
 * */
public class User_Omega {
	
	public static final int VALIDATE=1;
	public static final int UNVALIDATE=0;
	//用户验证状态
	private long id;
	//用户的ID
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
	private String validateCode;
	//邮箱注册验证码
	private int mailStatus;
	//邮箱验证状态码
	/**
	 * 默认构造函数
	 * */
	
	public User_Omega(){
		
	}
	
	/**
	 * 初始化账户和密码的构造函数
	 * */
	public User_Omega(String account,String password){
		this.account=account;
		this.password=password;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return the mailSatus
	 */
	public int getMailStatus() {
		return mailStatus;
	}


	/**
	 * @param mailSatus the mailSatus to set
	 */
	public void setMailStatus(int mailSatus) {
		this.mailStatus = mailSatus;
	}
	

	/**
	 * 拷贝当前对象
	 * @return user
	 * */
	public User_Omega copy(){
		User_Omega user = new User_Omega();
		user.setAccount(account);
		user.setAddress(address);
		user.setId(id);
		user.setMail(mail);
		user.setMailStatus(mailStatus);
		user.setPassword(password);
		user.setPhone(phone);
		user.setPostCode(postCode);
		user.setValidateCode(validateCode);
		return user;
	}
}
