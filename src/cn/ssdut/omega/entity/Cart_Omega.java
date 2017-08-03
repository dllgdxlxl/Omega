package cn.ssdut.omega.entity;

import java.util.List;

import cn.ssdut.omega.sqlutil.SQLHelper_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * Manager类，用来定义购物车的各种属性
 * */
public class Cart_Omega {

	private long id;
	//购物车ID
	private List<Product_Omega> products;
	//购物车中的商品列表
	private User_Omega user;
	//购物车所属用户
	private double cost;
	//购物车商品总价
	private int updateState;
	//列表是否变化
	/**
	 * 购物车的默认构造函数
	 * */
	public Cart_Omega(){
	   products=null;	
	   updateState=1;
	}
	
	/**
	 * 初始化商品列表和用户的构造函数
	 * @param user
	 * @param products
	 * */
	public Cart_Omega(User_Omega user,List<Product_Omega> products){
		this.user=user;
		this.products=products;
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
		if(updateState==1){
			SQLHelper_Omega helper=new SQLHelper_Omega();
			products=helper.findAllProductByCartId(id);
			updateState=0;
		}
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product_Omega> products) {
		this.products = products;
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
	 * @return the updateState
	 */
	public int getUpdateState() {
		return updateState;
	}

	/**
	 * @param updateState the updateState to set
	 */
	public void setUpdateState(int updateState) {
		this.updateState = updateState;
	}
	
	
}
