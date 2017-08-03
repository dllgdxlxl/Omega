package cn.ssdut.omega.entity;

import java.util.List;

/**
 * @author Kevin
 * @date 2017-07-12
 * Order类，用来定义订单的各种属性
 * */

public class Order_Omega {

	public static final int CANCEL_ORDER=0;
	//静态变量 订单状态为取消
	public static final int COMPLETE_ORDER=1;
	//静态变量 订单状态为完成
	public static final int UN_OPERATE=2;
	//静态变量 订单状态为未操作
	public static final int SEND_GOOD_ALREADY=3;
	//静态变量 订单状态为已发货
	
	private String order_num;
	//订单号
	private int status;
	//订单状态
	private long id;
	//订单的ID
	private List<Product_Omega> products;
	//订单的商品列表
	private double cost;
	//订单的总金额
	private User_Omega user;
	//订单所属用户
    private Manager_Omega manager;
    //订单管理者
    
	/**
	 * 订单的默认构造函数
	 * */
    public Order_Omega(){
    	products=null;
    }
    
    /**
     * 订单初始化订单号的构造函数
     * */
    public Order_Omega(String order_num){
    	
    }

	/**
	 * @return the order_num
	 */
	public String getOrder_num() {
		return order_num;
	}

	/**
	 * @param order_num the order_num to set
	 */
	public void setOrder_num(String order_num) {
		this.order_num = order_num;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
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
	 * @return the products
	 */
	public List<Product_Omega> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product_Omega> products) {
		this.products = products;
	}

	/**
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(double cost) {
		this.cost = cost;
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
