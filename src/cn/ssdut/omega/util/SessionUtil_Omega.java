/**
 * 
 */
package cn.ssdut.omega.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.ssdut.omega.entity.Cart_Omega;
import cn.ssdut.omega.entity.Manager_Omega;
import cn.ssdut.omega.entity.Shop_Omega;
import cn.ssdut.omega.entity.User_Omega;

/**
 * @author Kevin
 * @date 2017-07-14
 * 获取当前登录用户的类
 */
public class SessionUtil_Omega {

	/**
	 * 获取已经登录的user
	 * @return user
	 * */
	public static User_Omega  getLoginUser(){
		System.out.println(getObject("user"));
		return (User_Omega)getObject("user");
	}
	
	/**
	 * 获取已经登录的管理员
	 * @return manager
	 * */
    public static Manager_Omega getLoginManager(){
		return (Manager_Omega)getObject("manager");
    }
	
    private static Object getObject(String key){
    	return getSession().getAttribute(key);
    }
    /**
     * 获取当前会话
     * */
    public static HttpSession getSession(){
		ActionContext ctx = ActionContext.getContext();       
		HttpServletRequest request =(HttpServletRequest)ctx.get(ServletActionContext.HTTP_REQUEST);
		return request.getSession(false); 
    }
    
    /**
     * 获取已登录用户的购物车
     * */
    public static Cart_Omega getUserCart(){
    	return (Cart_Omega)getObject("cart");
    }
    
    /**
     * 获取已登录用户的商店列表
     * */
    public static List<Shop_Omega> getManagerShops(){
    	return (List<Shop_Omega>)getObject("shop");
    }
}
