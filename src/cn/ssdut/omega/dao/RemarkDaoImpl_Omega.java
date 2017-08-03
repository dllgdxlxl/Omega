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

import cn.ssdut.omega.entity.Remark_Omega;
import cn.ssdut.omega.entity.User_Omega;
import cn.ssdut.omega.sqlutil.SQLUtil_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * RemarkDao类的实现
 */
public class RemarkDaoImpl_Omega implements RemarkDao_Omega {

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.RemarkDao_Omega#save(cn.ssdut.omega.entity.Remark_Omega)
	 */
	@Override
	public void save(Remark_Omega remark) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into remarks (productId,time_,content,userId,state) values (?,?,?,?,?)";
		Connection conn = SQLUtil_Omega.getConnection();
        PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs=null;
        try {        
            preStmt.setLong(1, remark.getProductId());
            preStmt.setString(2, remark.getTime());
            preStmt.setString(3, remark.getContent());
            preStmt.setLong(4, remark.getUser().getId());
            preStmt.setInt(5, remark.getState());
            preStmt.executeUpdate();
            rs = preStmt.getGeneratedKeys();
            if(rs.next())
                remark.setId(rs.getLong(1));
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, rs);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.RemarkDao_Omega#delete(long)
	 */
	@Override
	public void delete(long id) throws SQLException {
		// TODO Auto-generated method stub
        String sql = "delete from remarks where id='"+id+"'";
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
	 * @see cn.ssdut.omega.sqlutil.RemarkDao_Omega#update(cn.ssdut.omega.entity.Remark_Omega)
	 */
	@Override
	public void update(Remark_Omega remark) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update remarks set content=?,time_=?,state=? where id=?";
		Connection conn = SQLUtil_Omega.getConnection();
		PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql);
        try {        
            preStmt.setString(1, remark.getContent());
            preStmt.setString(2, remark.getTime());
            preStmt.setInt(3, remark.getState());
            preStmt.setLong(4, remark.getId());
            preStmt.executeUpdate();
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, null);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.RemarkDao_Omega#findById(long)
	 */
	@Override
	public Remark_Omega findById(long id) throws SQLException {
		// TODO Auto-generated method stub
	     String sql = "select * from remarks where id='"+id+"'";
	     List<Remark_Omega> list=find(sql);
         return list==null?null:list.get(0);
	}

	private List<Remark_Omega> find(String sql) throws SQLException{
	     Connection conn = SQLUtil_Omega.getConnection();
	     Statement stmt=null;
	     ResultSet rs=null;
	     List<Remark_Omega> remarks=null;
	     try{  
	         stmt = conn.createStatement();  
	         rs = stmt.executeQuery(sql);  
	         remarks = new ArrayList<Remark_Omega>();
	         while(rs.next()){
	        	Remark_Omega remark = new Remark_Omega();
	            remark.setId(rs.getLong(1));
	            remark.setProductId(rs.getLong(2));
	            remark.setTime(rs.getString(3));
	            remark.setContent(rs.getString(4));
	            User_Omega user=(new UserDaoImpl_Omega()).findById(rs.getLong(5));
	            remark.setUser(user);
	            remark.setState(rs.getInt(6));
	        	remarks.add(remark);
	         }  
	     }catch (SQLException e){  
            throw e;
	     }finally{
	    	 SQLUtil_Omega.close(conn, stmt, rs);
	     }
		return remarks;
	}
	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.RemarkDao_Omega#findAll(long)
	 */
	@Override
	public List<Remark_Omega> findAllByProductId(long productId) throws SQLException {
		// TODO Auto-generated method stub
	     String sql = "select * from remarks where productId='"+productId+"'";
         return find(sql);
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.RemarkDao_Omega#findALL()
	 */
	@Override
	public List<Remark_Omega> findAllByUserId(long userId) throws SQLException {
		// TODO Auto-generated method stub
	     String sql = "select * from remarks where userId='"+userId+"'";
         return find(sql);
	}

}
