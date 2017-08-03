package cn.ssdut.omega.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.ssdut.omega.sqlutil.SQLHelper_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * Manager类，用来定义管理员的各种属性
 * */
public class Manager_Omega {

	public static final int VALIDATE=1;
	public static final int UNVALIDATE=0;
	//管理员验证状态
	
	private long id;
	//管理员id
	private String account;
	//用户名
	private String password;
	//密码
	private String name;
	//真实姓名
	private String mail;
	//电子邮箱
	private String phone;
	//联系方式-手机号
	private Map<Long,Shop_Omega> shops;
	//管理员开的店铺列表
	private String validateCode;
	//邮箱注册验证码
	private int mailStatus;
	//邮箱验证状态码
	
	private boolean updateStatus;
	/**
	 * @Method: Manager_Omega
	 * @Description: 默认构造函数
	 * */
	public Manager_Omega(){
	    shops= new HashMap<Long,Shop_Omega>();
		updateStatus=true;
	}
	
	
	/** @Method Manager_Omega
	 *  @Description 初始化账户和密码的构造函数
	 *  @param  account
	 *  @param  password
	 * */
	public Manager_Omega(String account,String password){
		this.account=account;
		this.password=password;
		shops= new HashMap<Long,Shop_Omega>();
		updateStatus=true;
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
	 * @return the shops
	 */
	public Map<Long,Shop_Omega> getShops() {
		if(updateStatus){
			updateStatus=false;
			SQLHelper_Omega helper = new SQLHelper_Omega();
			List<Shop_Omega> list = helper.findShopByManagerId(id);
			for(Shop_Omega shop:list){
				shops.put(shop.getId(), shop);
			}
		}
		return shops;
	}


	/**
	 * @param shops the shops to set
	 */
	public void setShops(Map<Long,Shop_Omega> shops) {
		this.shops = shops;
	}
	
	/**
	 * @param shop
	 *
	 * add shop into shops
	 * */
	public void addShop(Shop_Omega shop){
	   shops.put(shop.getId(), shop);
	   shop.setManager(this);
	   SQLHelper_Omega helper = new SQLHelper_Omega();
	   helper.save(shop);
	}
	
	/**
	 * @param shop
	 * close the shop
	 * */
	
	public void deleteShop(Shop_Omega shop){
		   shops.remove(shop.getId());
		   SQLHelper_Omega helper = new SQLHelper_Omega();
		   helper.deleteShop(shop.getId());
	}
	
	/**
	 * @param shopid
	 * close the shop
	 * */
	
	public void deleteShop(long id){
       shops.remove(id);
	   SQLHelper_Omega helper = new SQLHelper_Omega();
	   helper.deleteShop(id);
	}

//    /**
//     * @param shopid,product
//     * 删除商店中的商品
//     * */
//	public boolean deleteProductFromShop(long shopId,Product_Omega product){
//		shops=getShops();
//		Shop_Omega shop = shops.get(shopId);
//		return shop.deleteProduct(product);
//	}
//	
//	/**
//	 * @param
//	 * 添加商品
//	 * */
//	public boolean addProductFromShop(long shopId,Product_Omega product){
//		shops=getShops();
//		Shop_Omega shop = shops.get(shopId);
//		return shop.addProduct(product);
//	}
//	
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
	 * 拷贝对象
	 * @return manager
	 * */
	public Manager_Omega copy(){
		Manager_Omega manager = new Manager_Omega();
		manager.setAccount(account);
		manager.setId(id);
		manager.setMail(mail);
		manager.setMailStatus(mailStatus);
		manager.setName(name);
		manager.setPassword(password);
		manager.setPhone(phone);
		manager.setShops(shops);
		manager.setValidateCode(validateCode);
		return manager;
	}
}
