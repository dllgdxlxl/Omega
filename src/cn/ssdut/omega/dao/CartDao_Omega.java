package cn.ssdut.omega.dao;
/**
 * 
 */


import java.sql.SQLException;

import cn.ssdut.omega.entity.Cart_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * Cart类的数据库存储接口
 */
public interface CartDao_Omega {

	/**
	 * @param cart
	 * 保存购物车到数据库
	 * */
	public void save(Cart_Omega cart) throws SQLException;
	
	/**
	 * @param id
	 * 删除购物车在数据库
	 * */
	public void delete(long id) throws SQLException;
	
	/**
	 * @param cart
	 * 更新购物车数据到数据库
	 * */
	public void update(Cart_Omega cart) throws SQLException;
	
	/**
	 * @param userId
	 * 根据用户ID查找购物车
	 * */
	public Cart_Omega findByUserId(long userId) throws SQLException;
	
	/**
	 * @param id
	 * 根据ID查找购物车
	 * */
	public Cart_Omega findById(long id) throws SQLException;
}
