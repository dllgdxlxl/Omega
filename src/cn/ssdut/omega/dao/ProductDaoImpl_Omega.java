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

import cn.ssdut.omega.constant.Logger_Omega;
import cn.ssdut.omega.entity.Cart_Omega;
import cn.ssdut.omega.entity.Order_Omega;
import cn.ssdut.omega.entity.Product_Omega;
import cn.ssdut.omega.entity.Shop_Omega;
import cn.ssdut.omega.sqlutil.SQLUtil_Omega;

/**
 * @author Kevin
 * @date 2017-07-12
 * ProductDao的具体实现类
 */
public class ProductDaoImpl_Omega implements ProductDao_Omega {


	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ProductDao_Omega#save(cn.ssdut.omega.entity.Product_Omega)
	 */
	@Override
	public void save(Product_Omega product) throws SQLException {
		String sql="insert into products (name,description,num,img_id,price,good_rate,sale_num,type_,shopId,cartId,orderId,sql_type) values (?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = SQLUtil_Omega.getConnection();
        PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        ResultSet rs=null;
        try {        
        	preStmt.setString(1, product.getName());
        	preStmt.setString(2, product.getDescription());
        	preStmt.setInt(3, product.getNum());
        	preStmt.setLong(4, product.getImg_id());
        	preStmt.setDouble(5, product.getPrice());
        	preStmt.setDouble(6, product.getGood_rate());
        	preStmt.setInt(7, product.getSale_num());
        	preStmt.setString(8, product.getType());
        	long shopId =product.getSql_type()==Product_Omega.SHOP_PRODUCT?product.getShop().getId():0;
        	long cardId =product.getSql_type()==Product_Omega.CART_PRODUCT?product.getCart().getId():0;
        	long orderId=product.getSql_type()==Product_Omega.ORDER_PRODUCT?product.getOrder().getId():0;
        	preStmt.setLong(9, shopId);
        	preStmt.setLong(10, cardId);
        	preStmt.setLong(11, orderId);
        	preStmt.setInt(12, product.getSql_type());
        	preStmt.executeUpdate();
            rs = preStmt.getGeneratedKeys();
            if(rs.next())
                product.setId(rs.getLong(1));
            Logger_Omega.error("save product daoimpl"+product.getId());
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, rs);
        }
		
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ProductDao_Omega#delete(long)
	 */
	@Override
	public void delete(long id) throws SQLException {
        String sql = "delete from products where id='"+id+"'";
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
	 * @see cn.ssdut.omega.sqlutil.ProductDao_Omega#update(cn.ssdut.omega.entity.Product_Omega)
	 */
	@Override
	public void update(Product_Omega product) throws SQLException {

		String sql="update products set name=?,description=?,num=?,img_id=?,price=?,good_rate=?,sale_num=?,type_=?,shopId=?,cartId=?,orderId=?,sql_type=? where id=?";
		Connection conn = SQLUtil_Omega.getConnection();
		PreparedStatement preStmt = (PreparedStatement) conn.prepareStatement(sql);
        try {        
        	preStmt.setString(1, product.getName());
        	preStmt.setString(2, product.getDescription());
        	preStmt.setInt(3, product.getNum());
        	preStmt.setLong(4, product.getImg_id());
        	preStmt.setDouble(5, product.getPrice());
        	preStmt.setDouble(6, product.getGood_rate());
        	preStmt.setInt(7, product.getSale_num());
        	preStmt.setString(8, product.getType());
        	long shopId =product.getSql_type()==Product_Omega.SHOP_PRODUCT?product.getShop().getId():0;
        	long cardId =product.getSql_type()==Product_Omega.CART_PRODUCT?product.getCart().getId():0;
        	long orderId=product.getSql_type()==Product_Omega.ORDER_PRODUCT?product.getOrder().getId():0;
        	preStmt.setLong(9, shopId);
        	preStmt.setLong(10, cardId);
        	preStmt.setLong(11, orderId);
        	preStmt.setInt(12, product.getSql_type());
        	preStmt.setLong(13, product.getId());
            preStmt.executeUpdate();
        } catch (Exception e) {
        	throw new SQLException(e);
        }finally{
        	SQLUtil_Omega.close(conn, preStmt, null);
        }
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ProductDao_Omega#findById(long)
	 */
	@Override
	public Product_Omega findById(long id) throws SQLException {
        String sql="select * from products where id='"+id+"'";
		Connection conn = SQLUtil_Omega.getConnection();
	    Statement stmt=null;
	    ResultSet rs=null;
	    Product_Omega product=null;
	     try{  
	         stmt = conn.createStatement();  
	         rs = stmt.executeQuery(sql);  
	         if(rs.next()){
	        	product = new Product_Omega();
	        	product.setId(rs.getLong(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
              	product.setNum(rs.getInt(4));
                product.setImg_id(rs.getLong(5));
                product.setPrice(rs.getDouble(6));
              	product.setGood_rate(rs.getDouble(7));
                product.setSale_num(rs.getInt(8));
                product.setType(rs.getString(9));
                Shop_Omega shop = (new ShopDaoImpl_Omega()).findById(rs.getLong(10));
                Cart_Omega cart = (new CartDaoImpl_Omega()).findById(rs.getLong(11));
                Order_Omega order = (new OrderDaoImpl_Omega()).findById(rs.getLong(12));
              	product.setShop(shop);
                product.setCart(cart);
                product.setOrder(order);
                product.setSql_type(rs.getInt(13));
	         }  
	     }catch (SQLException e){  
             throw e;
	     }finally{
	    	 SQLUtil_Omega.close(conn, stmt, rs);
	     }
		return product;
	}

	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ProductDao_Omega#findAll(long)
	 */
	@Override
	public List<Product_Omega> findAllByShopId(long shopId) throws SQLException {
        String sql="select * from products where shopId='"+shopId+"'";
        return find(sql);
	}

	private List<Product_Omega> find(String sql) throws SQLException{
		List<Product_Omega> shops=null;
		Connection conn = SQLUtil_Omega.getConnection();
	    Statement stmt=null;
	    ResultSet rs=null;
	     try{  
	         stmt = conn.createStatement();  
	         rs = stmt.executeQuery(sql); 
	         shops = new ArrayList<Product_Omega>();
	         while(rs.next()){
	        	Product_Omega product = new Product_Omega();
	        	product.setId(rs.getLong(1));
                product.setName(rs.getString(2));
                product.setDescription(rs.getString(3));
              	product.setNum(rs.getInt(4));
                product.setImg_id(rs.getLong(5));
                product.setPrice(rs.getDouble(6));
              	product.setGood_rate(rs.getDouble(7));
                product.setSale_num(rs.getInt(8));
                product.setType(rs.getString(9));
                Shop_Omega shop = (new ShopDaoImpl_Omega()).findById(rs.getLong(10));
                Cart_Omega cart = (new CartDaoImpl_Omega()).findById(rs.getLong(11));
                Order_Omega order = (new OrderDaoImpl_Omega()).findById(rs.getLong(12));
              	product.setShop(shop);
                product.setCart(cart);
                product.setOrder(order);
                product.setSql_type(rs.getInt(13));
                shops.add(product);
	         }  
	     }catch (SQLException e){  
             throw e;
	     }finally{
	    	 SQLUtil_Omega.close(conn, stmt, rs);
	     }
		return shops;
	}
	
	/* (non-Javadoc)
	 * @see cn.ssdut.omega.sqlutil.ProductDao_Omega#findALL()
	 */
	@Override
	public List<Product_Omega> findALL() throws SQLException {
        String sql="select * from products where sql_type='"+Product_Omega.SHOP_PRODUCT+"'";
        return find(sql);
	}

	@Override
	public List<Product_Omega> findAllByCartId(long cartId) throws SQLException {
        String sql="select * from products where cartId='"+cartId+"'";
        return find(sql);
	}

	@Override
	public List<Product_Omega> findAllByOrderId(long orderId) throws SQLException {
        String sql="select * from products where orderId='"+orderId+"'";
        return find(sql);
	}

	@Override
	public List<Product_Omega> findAllByKeyword(String keyword) throws SQLException {
		String sql="select * from products where name like '%"+keyword+"%' or "
				+ "type_ like '%"+keyword+"%' or description like '%"+keyword+"%'";
		return find(sql);
	}

	@Override
	public List<Product_Omega> findAllByType(String type) throws SQLException {
        String sql="select * from products where type_='"+type+"'";
        return find(sql);
	}

	@Override
	public List<Long> findAllImagesByProductId(Long id) throws SQLException {
		// TODO Auto-generated method stub
		List<Long> list = new ArrayList<Long>();
		String sql="select * from imgs where productId="+id;
		Connection conn = SQLUtil_Omega.getConnection();
	    Statement stmt=null;
	    ResultSet rs=null;
	     try{  
	         stmt = conn.createStatement();  
	         rs = stmt.executeQuery(sql); 
	         while(rs.next()){
                 list.add(rs.getLong(1));
	         }  
	     }catch (SQLException e){  
             throw e;
	     }finally{
	    	 SQLUtil_Omega.close(conn, stmt, rs);
	     }
		return list;
	}

}
