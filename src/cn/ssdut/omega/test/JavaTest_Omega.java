package cn.ssdut.omega.test;

import java.util.ArrayList;
import java.util.List;

import cn.ssdut.omega.entity.Product_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * Java参数的测试类
 * 用来测试各种包和属性
 * */
public class JavaTest_Omega {

	public static void main(String [] args){
//
//        Product_Omega product= new Product_Omega();
//        product.setName("first");
//		List<Product_Omega> list = new ArrayList<Product_Omega>();
//	    list.add(product);
//	    System.out.println(list.get(0).getName());
//	    product.setName("second");
//	    System.out.println(list.get(0).getName());
		String filename="hydrangeas.jpg";
		String [] tmp=filename.split(".");
		System.out.println(tmp.length);
	    
	}
}
