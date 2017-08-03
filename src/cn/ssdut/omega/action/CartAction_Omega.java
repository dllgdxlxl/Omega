/**
 * 
 */
package cn.ssdut.omega.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import cn.ssdut.omega.entity.Cart_Omega;
import cn.ssdut.omega.entity.Manager_Omega;
import cn.ssdut.omega.entity.Order_Omega;
import cn.ssdut.omega.entity.Product_Omega;
import cn.ssdut.omega.entity.User_Omega;
import cn.ssdut.omega.management.CartManagement_Omega;
import cn.ssdut.omega.management.OrderManagement_Omega;
import cn.ssdut.omega.management.ProductManagement_Omega;
import cn.ssdut.omega.util.SessionUtil_Omega;

/**
 * @author Kevin
 * @date 2017-07-14
 * 购物车动作类
 */
public class CartAction_Omega extends BaseAction_Omega {

	private String id;
	//购物车id
	private String cost;
	//购物车总价
	
	/**
	 * 购物车结账
	 * */
	public String delete(){
		User_Omega user = SessionUtil_Omega.getLoginUser();
		if(user==null){
			return UNLOGIN;
		}
		 CartManagement_Omega cartmanage = new CartManagement_Omega();
		  Cart_Omega cart =cartmanage.findByUserId(user.getId());
		List<Product_Omega> products = cart.getProducts();
		ProductManagement_Omega productmanagement = new ProductManagement_Omega();
		if(products==null)
			return SUCCESS;
		for(Product_Omega product:products){
			productmanagement.deleteProduct(product.getId());
		}
		return SUCCESS;
	}
	
	public String pay(){
		User_Omega user = SessionUtil_Omega.getLoginUser();
		if(user==null){
			return UNLOGIN;
		}
		 CartManagement_Omega cartmanage = new CartManagement_Omega();
		  Cart_Omega cart =cartmanage.findByUserId(user.getId());
		List<Product_Omega> products = cart.getProducts();
		ProductManagement_Omega productmanagement = new ProductManagement_Omega();
		if(products==null)
			return SUCCESS;
		Order_Omega order = new Order_Omega();
		order.setUser(user);
		Manager_Omega manager = new Manager_Omega();
		manager.setId(1);
		order.setManager(manager);
		order.setOrder_num((new Date()).getTime()+"");
		order.setStatus(0);
		OrderManagement_Omega ordermanagement = new OrderManagement_Omega();
		ordermanagement.saveOrder(order);
		for(Product_Omega product:products){
			productmanagement.deleteProduct(product.getId());
			product.setSql_type(Product_Omega.ORDER_PRODUCT);
			product.setOrder(order);
			productmanagement.addProduct(product);
		}
		return SUCCESS;
	}
	
	/**
	 * 显示商品信息
	 * */
	
	public String showProducts(){
		SessionUtil_Omega util = new SessionUtil_Omega();
		HttpSession session =util.getSession();
		User_Omega user=util.getLoginUser();
		if(user==null)
			return UNLOGIN;
		
		return SUCCESS;
	}
}
