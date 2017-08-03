package cn.ssdut.omega.entity;

import java.util.List;

/**
 * @author Kevin
 * @date 2017-07-12
 * Product类，用来定义商品的各种属性
 * */
public class Product_Omega {

	
	public static final int SHOP_PRODUCT=0;
	public static final int CART_PRODUCT=1;
	public static final int ORDER_PRODUCT=2;
	//商品数据库种类
	
	private int sql_type;
	
	private long id;
	//商品的ID
	private String name;
	//商品的名字
	private String description;
	//商品的描述
	private int num;
	//商品的数量
	private long img_id;
	//商品图片ID
	private List<Remark_Omega> remarks;
	//商品的评论列表
	private double price;
	//商品的价格
	private double good_rate;
	//商品的好评率
	private int sale_num;
	//商品的销售数量
	private String type;
	//商品的种类
	private Shop_Omega shop;
	//商品所在的商店
	private Cart_Omega cart;
	//商品所在的购物车
	private Order_Omega order;
	/**
	 * Product类的默认构造函数
	 * */
	public Product_Omega(){
		remarks=null;
	}
	
	/**
	 * 商品的构造函数,初始化商品ID
	 * */
	public Product_Omega(long id){
		this.id=id;
		remarks=null;
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
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	/**
	 * @return the img_id
	 */
	public long getImg_id() {
		return img_id;
	}

	/**
	 * @param img_id the img_id to set
	 */
	public void setImg_id(long img_id) {
		this.img_id = img_id;
	}

	/**
	 * @return the remarks
	 */
	public List<Remark_Omega> getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(List<Remark_Omega> remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the good_rate
	 */
	public double getGood_rate() {
		return good_rate;
	}

	/**
	 * @param good_rate the good_rate to set
	 */
	public void setGood_rate(double good_rate) {
		this.good_rate = good_rate;
	}

	/**
	 * @return the sale_num
	 */
	public int getSale_num() {
		return sale_num;
	}

	/**
	 * @param sale_num the sale_num to set
	 */
	public void setSale_num(int sale_num) {
		this.sale_num = sale_num;
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
	 * @return the shop
	 */
	public Shop_Omega getShop() {
		return shop;
	}

	/**
	 * @param shop the shop to set
	 */
	public void setShop(Shop_Omega shop) {
		this.shop = shop;
	}

	/**
	 * @return the sql_type
	 */
	public int getSql_type() {
		return sql_type;
	}

	/**
	 * @param sql_type the sql_type to set
	 */
	public void setSql_type(int sql_type) {
		this.sql_type = sql_type;
	}

	/**
	 * @return the cart
	 */
	public Cart_Omega getCart() {
		return cart;
	}

	/**
	 * @param cart the cart to set
	 */
	public void setCart(Cart_Omega cart) {
		this.cart = cart;
	}

	/**
	 * @return the order
	 */
	public Order_Omega getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order_Omega order) {
		this.order = order;
	}
	
}
