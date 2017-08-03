package cn.ssdut.omega.dao;
/**
 * 
 */


import java.sql.SQLException;

import cn.ssdut.omega.entity.User_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * User类的数据库接口
 */
public interface UserDao_Omega {


	/**
	 * @param user
	 * 保存用户到数据库
	 * */
	public void save(User_Omega user) throws SQLException;
	
	/**
	 * @param id
	 * 删除用户在数据库
	 * */
	public void delete(long id) throws SQLException;
	
	/**
	 * @param user
	 * 更新用户数据到数据库
	 * */
	public void update(User_Omega user) throws SQLException;
	
	/**
	 * @param account
	 * 根据账户查找用户
	 * */
	public User_Omega findByAccount(String account) throws SQLException;
	
	/**
	 * @param id
	 * 根据ID查找用户
	 * */
	public User_Omega findById(long id) throws SQLException;
	
}
