package cn.ssdut.omega.dao;
/**
 * 
 */


import java.sql.SQLException;
import java.util.List;

import cn.ssdut.omega.entity.Order_Omega;

/**
 * @author Kevin
 * @date 2017-07-11
 * Order类的数据库实现接口
 */
public interface OrderDao_Omega {


	/**
	 * @param order
	 * 保存订单到数据库
	 * */
	public void save(Order_Omega order) throws SQLException;
	
	/**
	 * @param id
	 * 删除订单在数据库
	 * */
	public void delete(long id) throws SQLException;
	
	/**
	 * @param order
	 * 更新订单数据到数据库
	 * */
	public void update(Order_Omega order) throws SQLException;
	
	/**
	 * @param managerId
	 * 根据管理员ID查找订单
	 * */
	public List<Order_Omega> findByManagerId(long managerId) throws SQLException;
	
	/**
	 * @param userId
	 * 根据用户ID查找订单
	 * */
	public List<Order_Omega> findByUserId(long userid) throws SQLException;
	
	/**
	 * @param Id
	 * 根据ID查找订单
	 * */
	public Order_Omega findById(long id) throws SQLException;
}
