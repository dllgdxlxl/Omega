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

import cn.ssdut.omega.entity.Cart_Omega;
import cn.ssdut.omega.entity.User_Omega;
import cn.ssdut.omega.sqlutil.SQLUtil_Omega;

/**
 * @author Kevin
 * @date 2017-07-11
 * CartDao的实现类
 */
public class CartDaoImpl_Omega implements CartDao_Omega {

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.CartDao_Omega#save(cn.ssdut.omega.entity.Cart_Omega)
	 */
	@Override
	public void save(Cart_Omega cart) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into carts (userId,cost) values (?,?)";
		Connection conn = SQLUtil_Omega.getConnection();
        PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs=null;
        try {        
            preStmt.setLong(1, cart.getUser().getId());
            preStmt.setDouble(2, cart.getCost());
            preStmt.executeUpdate();
            rs = preStmt.getGeneratedKeys();
            if(rs.next())
                cart.setId(rs.getLong(1));
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, rs);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.CartDao_Omega#delete(long)
	 */
	@Override
	public void delete(long id) throws SQLException {
		// TODO Auto-generated method stub
        String sql = "delete from carts where id='"+id+"'";
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
	 * @see cn.ssdut.omega.sqlutil.CartDao_Omega#update(cn.ssdut.omega.entity.Cart_Omega)
	 */
	@Override
	public void update(Cart_Omega cart) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update carts set cost=? where id=?";
		Connection conn = SQLUtil_Omega.getConnection();
		PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql);
        try {        
            preStmt.setDouble(1, cart.getCost());
            preStmt.setLong(2, cart.getId());
            preStmt.executeUpdate();
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, null);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.CartDao_Omega#findByUserId(long)
	 */
	@Override
	public Cart_Omega findByUserId(long userId) throws SQLException {
		// TODO Auto-generated method stub
	     String sql = "select * from carts where userId='"+userId+"'";
	     List<Cart_Omega> list=find(sql);
         return list==null||list.size()==0?null:list.get(0);
	}

	private List<Cart_Omega> find(String sql) throws SQLException{
	     Connection conn = SQLUtil_Omega.getConnection();
	     Statement stmt=null;
	     ResultSet rs=null;
	     List<Cart_Omega> carts=null;
	     try{  
	         stmt = conn.createStatement();  
	         rs = stmt.executeQuery(sql);  
	         carts = new ArrayList<Cart_Omega>();
	         while(rs.next()){
	        	Cart_Omega cart = new Cart_Omega();
	        	cart.setId(rs.getLong(1));
	        	User_Omega user =(new UserDaoImpl_Omega()).findById(rs.getLong(2));
	        	cart.setUser(user);
	        	cart.setCost(rs.getDouble(3));
	        	carts.add(cart);
	         }  
	     }catch (SQLException e){  
             throw e;
	     }finally{
	    	 SQLUtil_Omega.close(conn, stmt, rs);
	     }
		return carts;
	}
	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.CartDao_Omega#findById(long)
	 */
	@Override
	public Cart_Omega findById(long id) throws SQLException {
		// TODO Auto-generated method stub
	     String sql = "select * from carts where id='"+id+"'";
	     List<Cart_Omega> list=find(sql);
         return list==null||list.size()==0?null:list.get(0);
	}

}
