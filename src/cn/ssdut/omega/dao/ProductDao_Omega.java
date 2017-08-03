package cn.ssdut.omega.dao;
/**
 * 
 */


import java.sql.SQLException;
import java.util.List;

import cn.ssdut.omega.entity.Product_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * 产品数据库操作接口
 */
public interface ProductDao_Omega {


	
	/**
	 * @param product
	 * 保存商品到数据库
	 * */
	public void save(Product_Omega product) throws SQLException;
	
	/**
	 * @param id
	 * 删除商品在数据库
	 * */
	public void delete(long id) throws SQLException;
	
	/**
	 * @param product
	 * 更新商品到数据库
	 * */
	public void update(Product_Omega product) throws SQLException;
	
	/**
	 * @param id
	 * 根据ID查找商品
	 * */
	public Product_Omega findById(long id) throws SQLException;
	
	/**
	 * @param shopid
	 * 根据店铺ID查找所有商品
	 * */
	public List<Product_Omega> findAllByShopId(long shopId) throws SQLException;
	
	/**
	 * @param cartId
	 * 根据购物车ID查找所有商品
	 * */
	public List<Product_Omega> findAllByCartId(long cartId) throws SQLException;
	
	/**
	 * @param orderId
	 * 根据订单Id查找所有商品
	 * */
	public List<Product_Omega> findAllByOrderId(long orderId) throws SQLException;
	
	/**
	 * 
	 * 查找所有未卖商品
	 * */
	public List<Product_Omega> findALL() throws SQLException;
	
	/**
	 * @param keyword
	 * 查找所有商品通过名字
	 * */
	public List<Product_Omega> findAllByKeyword(String keyword) throws SQLException;
	
	/**
	 * @param type
	 * 根据种类查找商品
	 * */
	public List<Product_Omega> findAllByType(String type) throws SQLException;
	
	/**
	 * @param id
	 * 查找所有图片
	 * */
	public List<Long> findAllImagesByProductId(Long id) throws SQLException;
}
