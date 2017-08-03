package cn.ssdut.omega.dao;
/**
 * 
 */


import java.sql.SQLException;
import java.util.List;

import cn.ssdut.omega.entity.Shop_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * Shop类的数据库接口
 */
public interface ShopDao_Omega {

	/**
	 * @param shop
	 * 保存商店到数据库
	 * */
	public void save(Shop_Omega shop) throws SQLException;
	
	/**
	 * @param id
	 * 删除商店在数据库
	 * */
	public void delete(long id) throws SQLException;
	
	/**
	 * @param shop
	 * 更新商店数据到数据库
	 * */
	public void update(Shop_Omega shop) throws SQLException;
	
	/**
	 * @param managerId
	 * 根据ManagerID查找商店
	 * */
	public List<Shop_Omega> findByManagerId(long managerId) throws SQLException;
	
	/**
	 * @param id
	 * 根据ID查找商店
	 * */
	public Shop_Omega findById(long id) throws SQLException;
}
