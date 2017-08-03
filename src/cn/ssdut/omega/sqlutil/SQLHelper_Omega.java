package cn.ssdut.omega.sqlutil;

import java.sql.SQLException;
import java.util.List;

import cn.ssdut.omega.constant.Logger_Omega;
import cn.ssdut.omega.dao.CartDaoImpl_Omega;
import cn.ssdut.omega.dao.CartDao_Omega;
import cn.ssdut.omega.dao.ManagerDaoImpl_Omega;
import cn.ssdut.omega.dao.ManagerDao_Omega;
import cn.ssdut.omega.dao.OrderDaoImpl_Omega;
import cn.ssdut.omega.dao.OrderDao_Omega;
import cn.ssdut.omega.dao.ProductDaoImpl_Omega;
import cn.ssdut.omega.dao.ProductDao_Omega;
import cn.ssdut.omega.dao.RemarkDaoImpl_Omega;
import cn.ssdut.omega.dao.RemarkDao_Omega;
import cn.ssdut.omega.dao.ShopDaoImpl_Omega;
import cn.ssdut.omega.dao.ShopDao_Omega;
import cn.ssdut.omega.dao.UserDaoImpl_Omega;
import cn.ssdut.omega.dao.UserDao_Omega;
import cn.ssdut.omega.entity.Cart_Omega;
import cn.ssdut.omega.entity.Manager_Omega;
import cn.ssdut.omega.entity.Order_Omega;
import cn.ssdut.omega.entity.Product_Omega;
import cn.ssdut.omega.entity.Remark_Omega;
import cn.ssdut.omega.entity.Shop_Omega;
import cn.ssdut.omega.entity.User_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * SQLHelper类，进行数据的增删改查操作
 * */
public class SQLHelper_Omega {

	//保存商品的类型
	
	private CartDao_Omega cartUtil;
	//购物车工具类
	private UserDao_Omega userUtil;
	//用户工具类
	private ManagerDao_Omega managerUtil;
	//管理员工具类
	private OrderDao_Omega orderUtil;
	//订单工具类
	private ProductDao_Omega productUtil;
	//商品工具类
	private RemarkDao_Omega remarkUtil;
	//评论工具类
	private ShopDao_Omega shopUtil;
	//商店工具类
	
	
	/**
	 * SQLHelper构造函数需要初始化
	 * */
	public SQLHelper_Omega(){
		init();
	}
	
	/**
	 * SQLHelper的初始化函数
	 * */
	private void init(){
		cartUtil = new CartDaoImpl_Omega();
		shopUtil = new ShopDaoImpl_Omega();
		userUtil = new UserDaoImpl_Omega();
		managerUtil = new ManagerDaoImpl_Omega();
		remarkUtil = new RemarkDaoImpl_Omega();
		productUtil = new ProductDaoImpl_Omega();
		orderUtil = new OrderDaoImpl_Omega();
	}
	
	/**
	 * @param shop
	 * 保存shop到数据库
	 * */
	public boolean save(Shop_Omega shop){
		try {
			shopUtil.save(shop);
		} catch (SQLException e) {
			Logger_Omega.error("save the shop into SQL failed");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param user
	 * 保存user到数据库
	 * */
	public boolean save(User_Omega user){
		try {
			userUtil.save(user);
		} catch (SQLException e) {
			Logger_Omega.error("save the user into SQL failed");
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	/**
	 * @param order
	 * 保存order到数据库
	 * */
	public boolean save(Order_Omega order){
		try {
			orderUtil.save(order);
		} catch (SQLException e) {
			Logger_Omega.error("save the order into SQL failed");
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	/**
	 * @param cart
	 * 保存cart到数据库
	 * */
	public boolean save(Cart_Omega cart){
		try {
			cartUtil.save(cart);
		} catch (SQLException e) {
			Logger_Omega.error("save the cart into SQL failed");
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	/**
	 * @param manager
	 * 保存manager到数据库
	 * */
	public boolean save(Manager_Omega manager){
		try {
			managerUtil.save(manager);
		} catch (SQLException e) {
			Logger_Omega.error("save the manager into SQL failed");
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	/**
	 * @param product
	 * 保存product到数据库
	 * */
	public boolean save(Product_Omega product){
		try {
			productUtil.save(product);
		} catch (SQLException e) {
			Logger_Omega.error("save the product into SQL failed");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param remark
	 * 保存remark到数据库
	 * */
	public boolean save(Remark_Omega remark){
		try {
			remarkUtil.save(remark);
		} catch (SQLException e) {
			Logger_Omega.error("save the remark into SQL failed");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param shop
	 * 更新shop到数据库
	 * */
	public boolean update(Shop_Omega shop){
		try {
			shopUtil.update(shop);
		} catch (SQLException e) {
            Logger_Omega.error("update the shop into SQL");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param user
	 * 更新user到数据库
	 * */
	public boolean update(User_Omega user){
		try {
			userUtil.update(user);
		} catch (SQLException e) {
            Logger_Omega.error("update the user into SQL");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param manager
	 * 更新manager到数据库
	 * */
	public boolean update(Manager_Omega manager){
		try {
			managerUtil.update(manager);
		} catch (SQLException e) {
            Logger_Omega.error("update the manager into SQL");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param order
	 * 更新order到数据库
	 * */
	public boolean update(Order_Omega order){
		try {
			orderUtil.update(order);
		} catch (SQLException e) {
            Logger_Omega.error("update the order into SQL");
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * @param product
	 * 更新product到数据库
	 * */
	public boolean update(Product_Omega product){
		try {
			productUtil.update(product);
		} catch (SQLException e) {
            Logger_Omega.error("update the product into SQL");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param remark
	 * 更新remark到数据库
	 * */
	public boolean update(Remark_Omega remark){
		try {
			remarkUtil.update(remark);
		} catch (SQLException e) {
            Logger_Omega.error("update the remark into SQL");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * @param cart
	 * 更新cart到数据库
	 * */
	public boolean update(Cart_Omega cart){
		try {
			cartUtil.update(cart);
		} catch (SQLException e) {
	        Logger_Omega.error("update the cart into SQL");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param cart
	 * 删除cart到数据库
	 * */
	public boolean deleteCart(long id){
		try {
			cartUtil.delete(id);
		} catch (SQLException e) {
            Logger_Omega.error("delete cart failed");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param manager
	 * 删除manager到数据库
	 * */
	public boolean deleteManager(long id){
		try {
			managerUtil.delete(id);
		} catch (SQLException e) {
            Logger_Omega.error("delete manager failed");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param order
	 * 删除order到数据库
	 * */
	public boolean deleteOrder(long id){
		try {
			orderUtil.delete(id);
		} catch (SQLException e) {
            Logger_Omega.error("delete order failed");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param product
	 * 删除product到数据库
	 * */
	public boolean deleteProduct(long id){
		try {
			productUtil.delete(id);
		} catch (SQLException e) {
            Logger_Omega.error("delete product failed");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param remark
	 * 删除shop到数据库
	 * */
	public boolean deleteRemark(long id){
		try {
			remarkUtil.delete(id);
		} catch (SQLException e) {
            Logger_Omega.error("delete remark failed");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param shop
	 * 删除shop到数据库
	 * */
	public boolean deleteShop(long id){
		try {
			shopUtil.delete(id);
		} catch (SQLException e) {
            Logger_Omega.error("delete shop failed");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param user
	 * 删除user到数据库
	 * */
	public boolean deleteUser(long id){
		try {
			userUtil.delete(id);
		} catch (SQLException e) {
            Logger_Omega.error("delete user failed");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * @param userId
	 * 根据用户ID查找购物车
	 * */
	public Cart_Omega findCartByUserId(long userId){
		try {
			return cartUtil.findByUserId(userId);
		} catch (SQLException e) {
            Logger_Omega.error("find cart by userID failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param id
	 * 根据ID查找购物车
	 * */
	public Cart_Omega findCartById(long id){
		try {
			return cartUtil.findById(id);
		} catch (SQLException e) {
            Logger_Omega.error("find cart by ID failed");
			e.printStackTrace();
		}
		return null;
	};
	
	/**
	 * @param account
	 * 根据账户查找用户
	 * */
	public Manager_Omega findManagerByAccount(String account){
		try {
			return managerUtil.findByAccount(account);
		} catch (SQLException e) {
            Logger_Omega.error("find Manager by account failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param id
	 * 根据ID查找用户
	 * */
	public Manager_Omega findManagerById(long id){
		try {
			return managerUtil.findById(id);
		} catch (SQLException e) {
            Logger_Omega.error("find Manager by id failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param managerId
	 * 根据管理员ID查找订单
	 * */
	public List<Order_Omega> findOrderByManagerId(long managerId){
		try {
			return orderUtil.findByManagerId(managerId);
		} catch (SQLException e) {
            Logger_Omega.error("find Order by managerId failed");
			e.printStackTrace();
		}
		return null;
	};
	
	/**
	 * @param userId
	 * 根据用户ID查找订单
	 * */
	public List<Order_Omega> findOrderByUserId(long userId){
		try {
			return orderUtil.findByUserId(userId);
		} catch (SQLException e) {
            Logger_Omega.error("find Order by userId failed");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @param id
	 * 根据ID查找订单
	 * */
	public Order_Omega findOrderById(long id){
		try {
			return orderUtil.findById(id);
		} catch (SQLException e) {
            Logger_Omega.error("find Order by id failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param id
	 * 根据ID查找商品
	 * */
	public Product_Omega findProductById(long id){
		try {
			return productUtil.findById(id);
		} catch (SQLException e) {
            Logger_Omega.error("find product by id failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param id
	 * 根据店铺ID查找所有商品
	 * */
	public List<Product_Omega> findAllProductByShopId(long shopId){
		try {
			return productUtil.findAllByShopId(shopId);
		} catch (SQLException e) {
            Logger_Omega.error("find all products by shopid failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param id
	 * 根据购物车ID查找所有商品
	 * */
	public List<Product_Omega> findAllProductByCartId(long cartId){
		try {
			return productUtil.findAllByCartId(cartId);
		} catch (SQLException e) {
            Logger_Omega.error("find all products by cartid failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param id
	 * 根据订单ID查找所有商品
	 * */
	public List<Product_Omega> findAllProductByOrderId(long orderId){
		try {
			return productUtil.findAllByOrderId(orderId);
		} catch (SQLException e) {
            Logger_Omega.error("find all products by orderid failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * 查找所有未卖商品
	 * */
	public List<Product_Omega> findALLProduct(){
		try {
			return productUtil.findALL();
		} catch (SQLException e) {
            Logger_Omega.error("find all products failed");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param keyword
	 * 根据关键词查找商品
	 * */
	public List<Product_Omega> findAllProductByKeyword(String keyword){
		try {
			return productUtil.findAllByKeyword(keyword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Logger_Omega.error("find products by keyword failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param type
	 * 根据种类查找关键词
	 * */
	public List<Product_Omega> findAllProductByType(String type){
		try {
			return productUtil.findAllByType(type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * @param id
	 * 根据ID查找评论
	 * */
	public Remark_Omega findRemarkById(long id){
		try {
			return remarkUtil.findById(id);
		} catch (SQLException e) {
            Logger_Omega.error("find remark by id failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param id
	 * 根据商品ID查找所有评论
	 * */
	public List<Remark_Omega> findAllRemarkByProductId(long productId){
		try {
			return remarkUtil.findAllByProductId(productId);
		} catch (SQLException e) {
            Logger_Omega.error("find all remarks by productId failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * 查找所有评论
	 * */
	public List<Remark_Omega> findAllRemarkByUserId(long userId){
		try {
			return remarkUtil.findAllByUserId(userId);
		} catch (SQLException e) {
            Logger_Omega.error("find all remarks failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param managerId
	 * 根据ManagerID查找购物车
	 * */
	public List<Shop_Omega> findShopByManagerId(long managerId){
		try {
			return shopUtil.findByManagerId(managerId);
		} catch (SQLException e) {
            Logger_Omega.error("find shop by managerId failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param id
	 * 根据ID查找商店
	 * */
	public Shop_Omega findShopById(long id){
		try {
			return shopUtil.findById(id);
		} catch (SQLException e) {
            Logger_Omega.error("find shop by id failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param account
	 * 根据账户查找用户
	 * */
	public User_Omega findUserByAccount(String account){
		try {
			return userUtil.findByAccount(account);
		} catch (SQLException e) {
            Logger_Omega.error("find user by account failed");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param id
	 * 根据ID查找用户
	 * */
	public User_Omega findUserById(long id){
		try {
			return userUtil.findById(id);
		} catch (SQLException e) {
            Logger_Omega.error("find user by id failed");
			e.printStackTrace();
		}
		return null;
	}
}

