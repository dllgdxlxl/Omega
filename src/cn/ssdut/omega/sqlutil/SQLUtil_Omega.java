package cn.ssdut.omega.sqlutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.ssdut.omega.constant.Constants_Omega;
import cn.ssdut.omega.constant.Logger_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * 数据库操作类
 * */
public class SQLUtil_Omega {

	/**
	 * 默认构造函数私有化
	 * 只调用静态方法，不能产生实例对象
	 * */
	private SQLUtil_Omega(){}
	
	/**
	 * 使用静态块加载驱动程序
	 * */
	static{
        try {  
            Class.forName("com.mysql.jdbc.Driver");  
        } catch (ClassNotFoundException e) {  
            Logger_Omega.error("The SQL Driver is missing");
        	e.printStackTrace();  
        }  
	}
	

	/**
	 * 获取数据库链接的静态方法
	 * @return connection
	 * */
	public static Connection getConnection(){
		Connection conn=null;
        try {  
            conn=DriverManager.getConnection(Constants_Omega.SQL_URL
            		,Constants_Omega.SQL_USERNAME,Constants_Omega.SQL_PASSWORD);  
        }catch (SQLException e) {  
               Logger_Omega.error("sql connection failed");  
               e.printStackTrace(); 
        }
		return conn;
	}
	
	/**
	 * 关闭数据库链接
	 * @param connection
	 * @param stat
	 * @param rs
	 * */
	public static void close(Connection conn,Statement stat,ResultSet rs){
			try{
				if(rs!=null){
					rs.close();
				}
				if(stat!=null){
					stat.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException e){
				Logger_Omega.error("close the SQL failed");
				e.printStackTrace();
			}
	}
}
