/**
 * 
 */
package cn.ssdut.omega.action;

import cn.ssdut.omega.entity.Remark_Omega;
import cn.ssdut.omega.entity.User_Omega;
import cn.ssdut.omega.management.RemarkManagement_Omega;
import cn.ssdut.omega.util.SessionUtil_Omega;
import cn.ssdut.omega.util.TimeUtil_Omega;

/**
 * @author Kevin
 * @date 2017-07-14
 * 评论的动作类
 */
public class RemarkAction_Omega extends BaseAction_Omega {

	private String id;
	//评论ID
	private String productId;
	//商品ID
	private String content;
	//评论内容
	private String state;
	//评论等级
	
	
	public String add(){
	  	User_Omega user=SessionUtil_Omega.getLoginUser();
	  	if(user==null)
	  		return UNLOGIN;
	  	Remark_Omega remark = new Remark_Omega();
	  	if(content.length()==0||productId.length()==0)
	  		return EMPTY;
	  	remark.setContent(content);
	  	remark.setProductId(Long.parseLong("1"));
	  	state="5";
	  	remark.setState(Integer.parseInt(state));
	  	if(state.length()==0)
	  		remark.setState(5);
	  	remark.setTime(TimeUtil_Omega.getNowTime());
	  	remark.setUser(user);
	  	RemarkManagement_Omega management_Omega=new RemarkManagement_Omega();
	  	System.out.println(remark+"");
	  	if(management_Omega.addRemark(remark))
	  		return SUCCESS;
	  	return ERROR;
	}
	
	public String delete(){
		if(id.length()==0)
			return ERROR;
		RemarkManagement_Omega management_Omega=new RemarkManagement_Omega();
		if(management_Omega.deleteRemark(Long.parseLong(id)))
			return SUCCESS;
		return ERROR;
	}
	
	public String update(){
		
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
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	
}
