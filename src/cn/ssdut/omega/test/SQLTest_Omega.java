/**
 * 
 */
package cn.ssdut.omega.test;

import java.sql.SQLException;

import cn.ssdut.omega.dao.ManagerDaoImpl_Omega;
import cn.ssdut.omega.dao.ShopDaoImpl_Omega;
import cn.ssdut.omega.dao.UserDaoImpl_Omega;
import cn.ssdut.omega.entity.Manager_Omega;
import cn.ssdut.omega.entity.Shop_Omega;
import cn.ssdut.omega.entity.User_Omega;

/**
 * @author Kevin
 * @date 2017-07-14
 * 数据库测试类
 */
public class SQLTest_Omega {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		testShop();
	}

	public static void testUser(){
        User_Omega user = new User_Omega();
        user.setAccount("lixiangli");
        user.setAddress("ssdut");
        user.setMail("1905692338");
        user.setPassword("123");
        user.setPhone("18742013895");
        user.setValidateCode("asas");
        user.setMailStatus(1);
        user.setPostCode("123");
        UserDaoImpl_Omega userdao = new UserDaoImpl_Omega();
        try {
			userdao.save(user);
			user.setPassword("890");
			userdao.update(user);
			User_Omega user1=userdao.findByAccount("lixiangli");
			System.out.println(user1.getAccount()+" "+user1.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void testManager(){
	      Manager_Omega user = new Manager_Omega();
	        user.setAccount("lixiangli");
	        user.setName("ssdut");
	        user.setMail("1905692338");
	        user.setPassword("123");
	        user.setPhone("18742013895");
	        user.setValidateCode("asas");
	        user.setMailStatus(1);
	        ManagerDaoImpl_Omega dao = new ManagerDaoImpl_Omega();
	        try {
				dao.save(user);
				user.setPassword("890");
				dao.update(user);
				Manager_Omega user1=dao.findByAccount("lixiangli");
				System.out.println(user1.getAccount()+" "+user1.getPassword());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
    public static void testShop(){
    	Shop_Omega shop = new Shop_Omega();
    	shop.setName("taobao");
    	shop.setDescription("shopping website");
    	shop.setManager(new Manager_Omega());
    	shop.getManager().setId(1);
    	ShopDaoImpl_Omega shopdao = new ShopDaoImpl_Omega();
    	try {
			//shopdao.save(shop);
			//shop.setName("hahahahha");
			//shopdao.update(shop);
			shopdao.delete(1);
			shopdao.delete(2);
			shopdao.delete(3);
    		System.out.println(shopdao.findById(4).getManager().getAccount());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void testCart(){
    	
    }
    
    public static void testProduct(){
    	
    	
    }
    
    public static void testRemark(){
    	
    }
    public static void testOrder(){
    	
    }
}
