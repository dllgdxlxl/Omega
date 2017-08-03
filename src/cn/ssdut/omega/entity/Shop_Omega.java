package cn.ssdut.omega.entity;

import java.util.ArrayList;
import java.util.List;

import cn.ssdut.omega.sqlutil.SQLHelper_Omega;


/**
* @ClassName: Shop_Omega
* @Description: 用于定义商店的各种属性
* @author: kevin
* @date: 2017-7-11 下午2:43:48
*
*/ 

public class Shop_Omega {

	private long id;
	//商店的ID
	private String name;
	//商店的名字
	private String description;
	//商店的描述
	private List<Product_Omega> products;
	//商品列表
	private Manager_Omega manager;
	//商品的管理者

	private boolean updateState;
	
	/**
	 * @return the updateState
	 */
	public boolean isUpdateState() {
		return updateState;
	}

	/**
	 * @param updateState the updateState to set
	 */
	public void setUpdateState(boolean updateState) {
		this.updateState = updateState;
	}

	/**
	 * 默认构造函数
	 * */
	public Shop_Omega(){
		products=new ArrayList<Product_Omega>();
		updateState=true;
	}
	
	/**
	 * 初始化ID的构造函数
	 * */
	public Shop_Omega(long id){
		this.id=id;
		products=new ArrayList<Product_Omega>();
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

	/**
	 * @return the products
	 */
	public List<Product_Omega> getProducts() {
		if(updateState){
			updateState=false;
			SQLHelper_Omega helper = new SQLHelper_Omega();
			products=helper.findAllProductByShopId(id);
		}
		return products;
	}

	/**
	 * @param product
	 * 删除商品
	 * */
	public boolean deleteProduct(Product_Omega product){
		SQLHelper_Omega helper = new SQLHelper_Omega();
		boolean state=helper.deleteProduct(product.getId());
		if(state)
			products.remove(product);
		return state;
	}
	
	/**
	 * @param product
	 * 添加商品
	 * */
	public boolean addProduct(Product_Omega product){
		SQLHelper_Omega helper = new SQLHelper_Omega();
		boolean state=helper.save(product);
		if(state)
			products.add(product);
		return state;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product_Omega> products) {
		this.products = products;
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
