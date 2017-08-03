/**
 * 
 */
package cn.ssdut.omega.management;

import cn.ssdut.omega.entity.Cart_Omega;
import cn.ssdut.omega.sqlutil.SQLHelper_Omega;

/**
 * @author Kevin
 * @date 2017-07-15
 * 购物车管理类
 */
public class CartManagement_Omega {
	
	SQLHelper_Omega helper;
    //数据库操作类
	
	public CartManagement_Omega(){
		helper=new SQLHelper_Omega();
	}
	
	
	/**
	 * @param userId
	 * 查找购物车
	 * */
	public Cart_Omega findByUserId(long userId){
		return helper.findCartByUserId(userId);
	}
	
	/**
	 * 新建购物车
	 * */
	public boolean buildCart(Cart_Omega cart){
		return helper.save(cart);
	}

}
