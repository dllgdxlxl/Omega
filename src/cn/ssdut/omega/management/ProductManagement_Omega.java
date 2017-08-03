package cn.ssdut.omega.management;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cn.ssdut.omega.entity.Product_Omega;
import cn.ssdut.omega.sqlutil.SQLHelper_Omega;

/**
 * @author Kevin
 * @date 2017-07-13
 * 商品管理类
 * */
public class ProductManagement_Omega {

	private SQLHelper_Omega helper;
	//数据库操作类

	/**
	 * 默认构造函数初始化Helper
	 * */
	public ProductManagement_Omega(){
		helper = new SQLHelper_Omega();
	}
	
	/**
	 * @param product
	 * 添加商品
	 * */
	public boolean addProduct(Product_Omega product){
		return helper.save(product);
	}
	
	/**
	 * @param product
	 * 修改商品
	 * */
	public boolean changeProduct(Product_Omega product){
		return helper.update(product);
	}
	
	/**
	 * @param productId
	 * 删除商品
	 * */
	public boolean deleteProduct(Long id){
		return helper.deleteProduct(id);
	}

	/**
	 * @param productId
	 * 查找商品
	 * */
	public Product_Omega findProductById(long id){
		return helper.findProductById(id);
	}
	
	/**
	 * @param shopId
	 * 查找商品
	 * */
	public List<Product_Omega> findProductByShopId(long shopId){
		return helper.findAllProductByShopId(shopId);
	}
	
	/**
	 * @param cartId
	 * 查找商品
	 * */
	public List<Product_Omega> findProductByCartId(long cartId){
		return helper.findAllProductByCartId(cartId);
	}
	/**
	 * @param orderId
	 * 查找商品
	 * */
	public List<Product_Omega> findProductByOrderId(long orderId){
		return helper.findAllProductByOrderId(orderId);
	}
	/**
	 * @param keyword
	 * 查找商品
	 * */
	public List<Product_Omega> findProductByKeyWord(String keyword){
		return helper.findAllProductByKeyword(keyword);
	}
	
	/**
	 * @param type
	 * 查找商品
	 * */
	public List<Product_Omega> findProductByType(String type){
		return helper.findAllProductByType(type);
	}
	
	/**
	 * @param number
	 * 查找热销产品
	 * */
	public List<Product_Omega> findPopularProducts(int number){
         return findProducts(number, 0);
	}
	
	//根据type查找热销或者高分产品
	private List<Product_Omega> findProducts(int number ,int type){
		List<Product_Omega> list=helper.findALLProduct();
		if(list.size()<=number)
			return list;
		Comparator<Product_Omega> comparator = new Comparator<Product_Omega>(){
		     public int compare(Product_Omega s1, Product_Omega s2) {
		    	 if(type==0)
                    return s1.getSale_num()-s2.getSale_num();
		    	 else
		    		return (int)(10000*(s1.getGood_rate()-s2.getGood_rate()));
		     }
		    };
		Collections.sort(list,comparator);
		return list.subList(0, number);
	}
	/**
	 * @param number
	 * 查找高评分产品
	 * */
	public List<Product_Omega> findHighScoreProducts(int number){
        return findProducts(number, 1);
	}
	
	
	public List<Long> findAllImagesByProductId(){
		return null;
	}
}
