/**
 * 
 */
package cn.ssdut.omega.action;

import cn.ssdut.omega.entity.Manager_Omega;
import cn.ssdut.omega.entity.Shop_Omega;
import cn.ssdut.omega.management.ShopManagement_Omega;
import cn.ssdut.omega.util.SessionUtil_Omega;

/**
 * @author Kevin
 * @date 2017-07-14
 * 店铺动作类
 */
public class ShopAction_Omega extends BaseAction_Omega {

	private String id;
	//店铺ID
	private String name;
	//店铺名字
	private String description;
	//店铺描述
	
	/**
	 * 开店
	 * */
	public String startShop(){
		if(name.length()==0)
			return EMPTY;
		Shop_Omega shop=new Shop_Omega();
		shop.setName(name);
		shop.setDescription(description);
		SessionUtil_Omega util = new SessionUtil_Omega();
		Manager_Omega manager = util.getLoginManager();
		if(manager==null) return UNLOGIN;
		shop.setManager(manager);
		ShopManagement_Omega management = new ShopManagement_Omega();
		if(management.startShop(shop))
	     	return SUCCESS;
	    return ERROR;
	}
	
	/**
	 * 关闭店铺
	 * */
	public String closeShop(){
		if(id.length()==0)
			return EMPTY;
		SessionUtil_Omega util = new SessionUtil_Omega();
		Manager_Omega manager = util.getLoginManager();
		if(manager==null) return UNLOGIN;
		ShopManagement_Omega management = new ShopManagement_Omega();
		if(management.closeShop(Long.parseLong(id)))
	     	return SUCCESS;
	    return ERROR;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
