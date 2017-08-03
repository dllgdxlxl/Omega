package cn.ssdut.omega.dao;
/**
 * 
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.ssdut.omega.entity.User_Omega;
import cn.ssdut.omega.sqlutil.SQLUtil_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * UserDao的实现类
 */
public class UserDaoImpl_Omega implements UserDao_Omega {

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.UserDao_Omega#save(cn.ssdut.omega.entity.User_Omega)
	 */
	@Override
	public void save(User_Omega user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into users (account,password,mail,phone,address,postCode,validateCode,mailStatus) values (?,?,?,?,?,?,?,?)";
		Connection conn = SQLUtil_Omega.getConnection();
        PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs=null;
        try {        
            preStmt.setString(1, user.getAccount());
            preStmt.setString(2, user.getPassword());
            preStmt.setString(3, user.getMail());
            preStmt.setString(4, user.getPhone());
            preStmt.setString(5, user.getAddress());
            preStmt.setString(6, user.getPostCode());
            preStmt.setString(7, user.getValidateCode());
            preStmt.setInt(8, user.getMailStatus());
            preStmt.executeUpdate();
            rs = preStmt.getGeneratedKeys();
            if(rs.next()){
                user.setId(rs.getLong(1));
           
            }
                
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, rs);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.UserDao_Omega#delete(long)
	 */
	@Override
	public void delete(long id) throws SQLException {
		// TODO Auto-generated method stub
        String sql = "delete from users where id='"+id+"'";
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
	 * @see cn.ssdut.omega.sqlutil.UserDao_Omega#update(cn.ssdut.omega.entity.User_Omega)
	 */
	@Override
	public void update(User_Omega user) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update users set password=?,phone=?,address=?,postCode=?,mailStatus=? where id=?";
		Connection conn = SQLUtil_Omega.getConnection();
		PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql);
        try {        
            preStmt.setString(1, user.getPassword());
            preStmt.setString(2, user.getPhone());
            preStmt.setString(3, user.getAddress());
            preStmt.setString(4, user.getPostCode());
            preStmt.setInt(5, user.getMailStatus());
            preStmt.setLong(6, user.getId());
            preStmt.executeUpdate();
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, null);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.UserDao_Omega#findByAccount(java.lang.String)
	 */
	@Override
	public User_Omega findByAccount(String account) throws SQLException {
		// TODO Auto-generated method stub
	     String sql = "select * from users where account='"+account+"'";
         return find(sql);
	}
	
	
	private User_Omega find(String sql) throws SQLException{
	     Connection conn = SQLUtil_Omega.getConnection();
	     Statement stmt=null;
	     ResultSet rs=null;
	     User_Omega user=null;
	     try{  
	         stmt = conn.createStatement();  
	         rs = stmt.executeQuery(sql);  
	         if(rs.next()){
	        	user = new User_Omega();
	        	user.setId(rs.getLong(1));
	        	user.setAccount(rs.getString(2));
	        	user.setPassword(rs.getString(3));
	        	user.setMail(rs.getString(4));
	        	user.setPhone(rs.getString(5));
	        	user.setAddress(rs.getString(6));
	        	user.setPostCode(rs.getString(7));
	        	user.setValidateCode(rs.getString(8));
	        	user.setMailStatus(rs.getInt(9));
	         }  
	     }catch (SQLException e){  
              throw e;
	     }finally{
	    	 SQLUtil_Omega.close(conn, stmt, rs);
	     }
		return user;
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.UserDao_Omega#find(long)
	 */
	@Override
	public User_Omega findById(long id) throws SQLException {
		// TODO Auto-generated method stub
	    String sql = "select * from users where id='"+id+"'";
        return find(sql);
	}

}
