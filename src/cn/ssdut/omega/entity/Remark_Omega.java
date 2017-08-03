package cn.ssdut.omega.entity;


/**
 * @author Kevin
 * @date 2017-07-12
 * Remark类，用来定义评论的各种属性
 * */

public class Remark_Omega {

	public static final int GOOD=0;
	public static final int BAD=1;
	public static final int NOT_BAD=2;
	//静态变量 评论等级
	
	private long id;
	//评论的ID
	private long productId;
	//评论所属的商品ID
	private String time;
	//评论发表的时间
	private String content;
	//评论的内容
	private User_Omega user;
	//评论人
	private int state;
	//评论等级：好评，中评，差评
	
	/**
	 * 默认构造函数
	 * */
	public Remark_Omega(){
		
	}
	
	/**
	 * 初始化构造函数
	 * */
	public Remark_Omega(String content,String time,long productId,int state){
		this.content=content;
		this.time=time;
		this.productId=productId;
		this.state=state;
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
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
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
	 * @return the userName
	 */
	public User_Omega getUser() {
		return user;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUser(User_Omega user) {
		this.user = user;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}
	
	
}
