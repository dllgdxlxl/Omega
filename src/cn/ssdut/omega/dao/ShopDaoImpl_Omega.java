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
import cn.ssdut.omega.entity.Shop_Omega;
import cn.ssdut.omega.sqlutil.SQLUtil_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * ShopDao类的实现类
 */
public class ShopDaoImpl_Omega implements ShopDao_Omega {

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ShopDao_Omega#save(cn.ssdut.omega.entity.Shop_Omega)
	 */
	@Override
	public void save(Shop_Omega shop) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into shops (name,description,managerId) values (?,?,?)";
		Connection conn = SQLUtil_Omega.getConnection();
        PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs=null;
        try {        
            preStmt.setString(1, shop.getName());
            preStmt.setString(2, shop.getDescription());
            preStmt.setLong(3, shop.getManager().getId());
            preStmt.executeUpdate();
            rs = preStmt.getGeneratedKeys();
            if(rs.next())
                shop.setId(rs.getLong(1));
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, rs);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ShopDao_Omega#delete(long)
	 */
	@Override
	public void delete(long id) throws SQLException {
		// TODO Auto-generated method stub
        String sql = "delete from shops where id='"+id+"'";
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
	 * @see cn.ssdut.omega.sqlutil.ShopDao_Omega#update(cn.ssdut.omega.entity.Shop_Omega)
	 */
	@Override
	public void update(Shop_Omega shop) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update shops set name=?,description=? where id=?";
		Connection conn = SQLUtil_Omega.getConnection();
		PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql);
        try {        
            preStmt.setString(1, shop.getName());
            preStmt.setString(2, shop.getDescription());
            preStmt.setLong(3, shop.getId());
            preStmt.executeUpdate();
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, null);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ShopDao_Omega#findByManagerId(long)
	 */
	@Override
	public List<Shop_Omega> findByManagerId(long managerId) throws SQLException {
		// TODO Auto-generated method stub
	     String sql = "select * from shops where managerId='"+managerId+"'";
         return find(sql);
	}

	private List<Shop_Omega> find(String sql) throws SQLException{
	     Connection conn = SQLUtil_Omega.getConnection();
	     Statement stmt=null;
	     ResultSet rs=null;
	     List<Shop_Omega> shops=null;
	     try{  
	         stmt = conn.createStatement();  
	         rs = stmt.executeQuery(sql);  
	         shops = new ArrayList<Shop_Omega>();
	         while(rs.next()){
	        	Shop_Omega shop = new Shop_Omega();
	        	shop.setId(rs.getLong(1));
	        	shop.setName(rs.getString(2));
	        	shop.setDescription(rs.getString(3));
	        	Manager_Omega manager = (new ManagerDaoImpl_Omega()).findById(rs.getLong(4));
	        	shop.setManager(manager);
	        	shops.add(shop);
	         }  
	     }catch (SQLException e){  
             throw e;
	     }finally{
	    	 SQLUtil_Omega.close(conn, stmt, rs);
	     }
		return shops;
	}
	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ShopDao_Omega#findById(long)
	 */
	@Override
	public Shop_Omega findById(long id) throws SQLException {
		// TODO Auto-generated method stub
	     String sql = "select * from shops where id='"+id+"'";
	     List<Shop_Omega> list=find(sql);
         return list==null||list.size()==0?null:list.get(0);
	}

}
