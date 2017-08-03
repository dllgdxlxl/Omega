package cn.ssdut.omega.dao;
/**
 * 
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.ssdut.omega.entity.Manager_Omega;
import cn.ssdut.omega.sqlutil.SQLUtil_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * ManagerDao接口的实现类
 */
public class ManagerDaoImpl_Omega implements ManagerDao_Omega {

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ManagerDao_Omega#save(cn.ssdut.omega.entity.Manager_Omega)
	 */
	@Override
	public void save(Manager_Omega manager) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into managers (account,password,mail,name,phone,validateCode,mailStatus) values (?,?,?,?,?,?,?)";
		Connection conn = SQLUtil_Omega.getConnection();
        PreparedStatement preStmt = (PreparedStatement)conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs=null;
        try {        
            preStmt.setString(1, manager.getAccount());
            preStmt.setString(2, manager.getPassword());
            preStmt.setString(3, manager.getMail());
            preStmt.setString(4, manager.getName());
            preStmt.setString(5, manager.getPhone());
            preStmt.setString(6, manager.getValidateCode());
            preStmt.setInt(7, manager.getMailStatus());
            preStmt.executeUpdate();
            rs = preStmt.getGeneratedKeys();
            if(rs.next())
                manager.setId(rs.getLong(1));
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, rs);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ManagerDao_Omega#delete(long)
	 */
	@Override
	public void delete(long id) throws SQLException {
		// TODO Auto-generated method stub
        String sql = "delete from managers where id='"+id+"'";
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
	 * @see cn.ssdut.omega.sqlutil.ManagerDao_Omega#update(cn.ssdut.omega.entity.Manager_Omega)
	 */
	@Override
	public void update(Manager_Omega manager) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update managers set password=?,phone=?,name=?,mailStatus=? where id=?";
		Connection conn = SQLUtil_Omega.getConnection();
		PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql);
        try {        
            preStmt.setString(1, manager.getPassword());
            preStmt.setString(2, manager.getPhone());
            preStmt.setString(3, manager.getName());
            preStmt.setInt(4, manager.getMailStatus());
            preStmt.setLong(5, manager.getId());
            preStmt.executeUpdate();
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, null);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ManagerDao_Omega#findByAccount(java.lang.String)
	 */
	@Override
	public Manager_Omega findByAccount(String account) throws SQLException {
		// TODO Auto-generated method stub
	     String sql = "select * from managers where account='"+account+"'";
         return find(sql);
	}
	private Manager_Omega find(String sql) throws SQLException{
	     Connection conn = SQLUtil_Omega.getConnection();
	     Statement stmt=null;
	     ResultSet rs=null;
	     Manager_Omega manager=null;
	     try{  
	         stmt = conn.createStatement();  
	         rs = stmt.executeQuery(sql);  
	         if(rs.next()){
	        	manager = new Manager_Omega();
	        	manager.setId(rs.getLong(1));
	        	manager.setAccount(rs.getString(2));
	        	manager.setPassword(rs.getString(3));
	        	manager.setMail(rs.getString(4));
	        	manager.setName(rs.getString(5));
	        	manager.setPhone(rs.getString(6));
	        	manager.setValidateCode(rs.getString(7));
	        	manager.setMailStatus(rs.getInt(8));
	         }  
	     }catch (SQLException e){  
             throw e;
	     }finally{
	    	 SQLUtil_Omega.close(conn, stmt, rs);
	     }
		return manager;
	}
	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ManagerDao_Omega#find(long)
	 */
	@Override
	public Manager_Omega findById(long id) throws SQLException {
	    String sql = "select * from managers where id='"+id+"'";
        return find(sql);
	}

}
