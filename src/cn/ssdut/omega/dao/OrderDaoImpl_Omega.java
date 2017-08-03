package cn.ssdut.omega.dao;
/**
 * 
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.ssdut.omega.entity.Manager_Omega;
import cn.ssdut.omega.entity.Order_Omega;
import cn.ssdut.omega.entity.User_Omega;
import cn.ssdut.omega.sqlutil.SQLUtil_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * OrderDao的实现类
 */
public class OrderDaoImpl_Omega implements OrderDao_Omega {

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.OrderDao_Omega#save(cn.ssdut.omega.entity.Order_Omega)
	 */
	@Override
	public void save(Order_Omega order) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into orders (order_num,status,cost,userId,managerId) values (?,?,?,?,?)";
		Connection conn = SQLUtil_Omega.getConnection();
        PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs=null;
        try {        
            preStmt.setString(1, order.getOrder_num());
            preStmt.setInt(2, order.getStatus());
            preStmt.setDouble(3, order.getCost());
            preStmt.setLong(4, order.getUser().getId());
            preStmt.setLong(5, order.getManager().getId());
            preStmt.executeUpdate();
            rs = preStmt.getGeneratedKeys();
            if(rs.next())
                order.setId(rs.getLong(1));
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, rs);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.OrderDao_Omega#delete(long)
	 */
	@Override
	public void delete(long id) throws SQLException {
		// TODO Auto-generated method stub
        String sql = "delete from orders where id='"+id+"'";
        Connection conn = SQLUtil_Omega.getConnection(); 
	    Statement stmt=null;
	     try{  
	         stmt = conn.createStatement();  
	         stmt.executeUpdate(sql);  
	     }catch (SQLException e){  
             throw e;
	     }finally{
	    	 SQLUtil_Omega.close(conn, stmt, null);
	     }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.OrderDao_Omega#update(cn.ssdut.omega.entity.Order_Omega)
	 */
	@Override
	public void update(Order_Omega order) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update orders set status=? where id=?";
		Connection conn = SQLUtil_Omega.getConnection();
		PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql);
        try {        
            preStmt.setInt(1, order.getStatus());
            preStmt.setLong(2, order.getId());
            preStmt.executeUpdate();
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, null);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.OrderDao_Omega#findByAccount(java.lang.String)
	 */
	@Override
	public List<Order_Omega> findByManagerId(long managerId) throws SQLException {
		// TODO Auto-generated method stub
	     String sql = "select * from orders where managerId='"+managerId+"'";
         return find(sql);
	}

	private List<Order_Omega> find(String sql) throws SQLException{
	     Connection conn = SQLUtil_Omega.getConnection();
	     Statement stmt=null;
	     ResultSet rs=null;
	     List<Order_Omega> orders=null;
	     try{  
	         stmt = conn.createStatement();  
	         rs = stmt.executeQuery(sql);  
	         orders = new ArrayList<Order_Omega>();
	         while(rs.next()){
	        	Order_Omega order = new Order_Omega();
	        	order.setId(rs.getLong(1));
	        	order.setOrder_num(rs.getString(2));
	        	order.setStatus(rs.getInt(3));
	        	order.setCost(rs.getDouble(4));
	        	User_Omega user =(new UserDaoImpl_Omega()).findById(rs.getLong(5));
	        	order.setUser(user);
	        	Manager_Omega manager = (new ManagerDaoImpl_Omega()).findById(rs.getLong(6));
	        	order.setManager(manager);
	        	orders.add(order);
	         }  
	     }catch (SQLException e){  
            throw e;
	     }finally{
	    	 SQLUtil_Omega.close(conn, stmt, rs);
	     }
		return orders;
	}
	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.OrderDao_Omega#findById(long)
	 */
	@Override
	public List<Order_Omega> findByUserId(long userId) throws SQLException {
		// TODO Auto-generated method stub
	     String sql = "select * from orders where userId='"+userId+"'";
         return find(sql);
	}



	@Override
	public Order_Omega findById(long id) throws SQLException {
		// TODO Auto-generated method stub
	     String sql = "select * from orders where id='"+id+"'";
	     List<Order_Omega> list=find(sql);
         return list==null||list.size()==0?null:list.get(0);
	}

}
