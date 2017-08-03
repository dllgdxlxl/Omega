package cn.ssdut.omega.management;

import java.util.List;

import cn.ssdut.omega.entity.Order_Omega;
import cn.ssdut.omega.sqlutil.SQLHelper_Omega;

/**
 * @author Kevin
 * @date 2017-07-13
 * 实现对订单管理与操作
 * */
public class OrderManagement_Omega {

	private SQLHelper_Omega helper;
	//数据库操作类
	
	/**
	 * 默认构造函数，初始化helper
	 * */
	public OrderManagement_Omega(){
		helper = new SQLHelper_Omega();
	}
	
	
	/**
	 * @param order
	 * @return result
	 * 对订单进行取消
	 * */
	public boolean cancelOrder(Order_Omega order){
		if(order.getStatus()==Order_Omega.UN_OPERATE){
			/*
			 * 进行订单取消的模拟操作
			 * */
			order.setStatus(Order_Omega.CANCEL_ORDER);
			helper.update(order);
			return true;
		}
		return false;
	}
	
	
	/**
	 * @param order
	 * @return boolean
	 * 对订单类进行完成操作
	 * */
	public boolean completeOrder(Order_Omega order){
		if(order.getStatus()==Order_Omega.SEND_GOOD_ALREADY){
			/*
			 * 进行订单完成的模拟操作
			 * */
			order.setStatus(Order_Omega.COMPLETE_ORDER);
			helper.update(order);
			return true;
		}
		return false;
	}
	
	/**
	 * @param Order
	 * 保存订单
	 * */
	public boolean saveOrder(Order_Omega order){
		return helper.save(order);
	}
	/**
	 * @param order
	 * @return result
	 * 对订单类进行发货操作
	 * */
	public boolean sendGood(Order_Omega order){
		if(order.getStatus()==Order_Omega.UN_OPERATE){
			/*
			 * 进行订单发货的模拟操作
			 * */
			order.setStatus(Order_Omega.SEND_GOOD_ALREADY);
			helper.update(order);
			return true;
		}
		return false;
	}
	
	/**
	 * @param managerId
	 * 查找订单
	 * */
	public List<Order_Omega> findOrderByManagerId(long managerId){
      return helper.findOrderByManagerId(managerId);
	}
	
	/**
	 * @param userId
	 * 查找订单
	 * */
	public List<Order_Omega> findOrderByUserId(long userId){
		return helper.findOrderByUserId(userId);
	}
}
