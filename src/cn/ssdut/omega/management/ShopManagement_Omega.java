package cn.ssdut.omega.management;

import java.util.List;

import cn.ssdut.omega.entity.Product_Omega;
import cn.ssdut.omega.entity.Shop_Omega;
import cn.ssdut.omega.sqlutil.SQLHelper_Omega;

/**
 * @author Kevin
 * @date 2017-07-13
 * 商店管理类
 * */
public class ShopManagement_Omega {

	private SQLHelper_Omega helper;
	//商店管理类
	
	/**
	 * 默认构造函数，初始化helper
	 * */
	public ShopManagement_Omega(){
		helper= new SQLHelper_Omega();
	}
	
	/**
	 * @param shop
	 * 开店
	 * */
	public boolean startShop(Shop_Omega shop){
		return helper.save(shop);
	}
	
	/**
	 * @param shopId
	 * 关闭店铺
	 * */
	public boolean closeShop(long id){
		List<Product_Omega> list = helper.findAllProductByShopId(id);
		if(list!=null){
			for(Product_Omega product:list){
				helper.deleteProduct(product.getId());
			}
		}
		return helper.deleteShop(id);
	}
	
	/**
	 * @param shopId
	 * 查找店铺
	 * */
	public Shop_Omega findShopById(long shopId){
		return helper.findShopById(shopId);
	}
	
	/**
	 * @param managerId
	 * 查找店铺
	 * */
	public List<Shop_Omega> findShopByManagerId(long managerId){
		return helper.findShopByManagerId(managerId);
	}
}
