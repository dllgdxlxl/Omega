package cn.ssdut.omega.dao;
/**
 * 
 */


import java.sql.SQLException;
import java.util.List;

import cn.ssdut.omega.entity.Remark_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * Remark的数据库接口
 */
public interface RemarkDao_Omega {


	/**
	 * @param product
	 * 保存评论到数据库
	 * */
	public void save(Remark_Omega remark) throws SQLException;
	
	/**
	 * @param id
	 * 删除评论在数据库
	 * */
	public void delete(long id) throws SQLException;
	
	/**
	 * @param remark
	 * 更新评论到数据库
	 * */
	public void update(Remark_Omega remark) throws SQLException;
	
	/**
	 * @param id
	 * 根据ID查找评论
	 * */
	public Remark_Omega findById(long id) throws SQLException;
	
	/**
	 * @param Productid
	 * 根据商品ID查找所有评论
	 * */
	public List<Remark_Omega> findAllByProductId(long productId) throws SQLException;
	
	/**
	 * @param userID
	 * 根据用户查找所有评论
	 * */
	public List<Remark_Omega> findAllByUserId(long userId) throws SQLException;
}
