/**
 * 
 */
package cn.ssdut.omega.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import cn.ssdut.omega.constant.Logger_Omega;
import cn.ssdut.omega.entity.Cart_Omega;
import cn.ssdut.omega.entity.Manager_Omega;
import cn.ssdut.omega.entity.Product_Omega;
import cn.ssdut.omega.entity.Shop_Omega;
import cn.ssdut.omega.entity.User_Omega;
import cn.ssdut.omega.management.CartManagement_Omega;
import cn.ssdut.omega.management.ProductManagement_Omega;
import cn.ssdut.omega.management.ShopManagement_Omega;
import cn.ssdut.omega.util.SessionUtil_Omega;

/**
 * @author Kevin
 * @date 2017-07-15
 * 添加商品动作类
 */
public class ProductAction_Omega extends BaseAction_Omega {

	
	//文件
	private File file;
	
    //提交过来的file的名字
    private String fileFileName;
    
    //提交过来的file的MIME类型
    private String fileContentType;
    
    //商品名字
    private String name;
    //商品描述
    private String description;
    //商品数量
    private String num;
    //商品价格
    private String price;
    //商品种类
    private String type;
    //商店ID
    private String shopId;
    //商品ID
    private String id;
    
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 上传文件
	 * */
	public String upload(){
		try {
			InputStream is = new FileInputStream(file);
			String path = ServletActionContext.getServletContext().getRealPath("/");
	        OutputStream os = new FileOutputStream(new File(path+"upload/", fileFileName));
	        
	        System.out.println("fileFileName: " + fileFileName);

	       // 因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
	        System.out.println("file: " + file.getName());
	        System.out.println("file: " + file.getPath());
	        
	        byte[] buffer = new byte[1024];
	        while(-1!=is.read(buffer, 0, buffer.length))
	        {
	            os.write(buffer);
	        }
	        
	        os.close();
	        is.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger_Omega.error("File upload failed"+e);
			return ERROR;
		} 
		String[] tmp= fileFileName.split("\\.");
		System.out.println(tmp[tmp.length-1]);
        return SUCCESS;
	}
	
	
	/**
	 * 添加商品到购物车
	 * */
	
	public String addToCart(){
		
		if(num==null||num.length()==0||id==null||id.length()==0)
			return ERROR;
		User_Omega user =SessionUtil_Omega.getLoginUser();
		if(user==null)
			return UNLOGIN;
		CartManagement_Omega cartmanage = new CartManagement_Omega();
		Cart_Omega cart = cartmanage.findByUserId(user.getId());
		ProductManagement_Omega management = new ProductManagement_Omega();
		Product_Omega product =management.findProductById(Long.parseLong(id));
		product.setSql_type(Product_Omega.CART_PRODUCT);
		product.setNum(Integer.parseInt(num));
		product.setCart(cart);
		if(management.addProduct(product)){
			return SUCCESS;
		}
		return ERROR;
	}
	/**
	 * 添加商品
	 * */
	public String add(){
		if(name==null||price==null||num==null||type==null){
			return EMPTY;
		}
		Manager_Omega manager =SessionUtil_Omega.getLoginManager();
		if(manager==null)
			return UNLOGIN;
		Product_Omega product = new Product_Omega();
		product.setName(name);
		product.setDescription(description);
		product.setNum(Integer.parseInt(num));
		product.setType(type);
		product.setPrice(Double.parseDouble(price));
		
		//产生img_id
		Date date = new Date();
		String[] tmp= fileFileName.split("\\.");
		String houzhui=tmp[tmp.length-1];
		long img_id=date.getTime();
		setFileFileName(img_id+"."+houzhui);
		if(!upload().equals(SUCCESS)){
			return ERROR;
		}
		
		product.setImg_id(img_id);
		product.setGood_rate(100);
		product.setSale_num(0);
        ShopManagement_Omega management1 = new ShopManagement_Omega();
		Shop_Omega shop=management1.findShopById(Long.parseLong(shopId));
		if(shop==null)
			return UNSHOP;
		product.setShop(shop);
		product.setSql_type(Product_Omega.SHOP_PRODUCT);
		ProductManagement_Omega management = new ProductManagement_Omega();
		management.addProduct(product);
		return SUCCESS;
	}

	/**
	 * @param productId
	 * 删除商品
	 * */
	public String delete(){
		ProductManagement_Omega management_Omega=new ProductManagement_Omega();
		if(management_Omega.deleteProduct(Long.parseLong(id)))
			return SUCCESS;
		return ERROR;
	}
	
	/**
	 * @param id
	 * 修改商品
	 * */
	public String update(){
		ProductManagement_Omega management_Omega=new ProductManagement_Omega();
		Product_Omega product = management_Omega.findProductById(Long.parseLong(id));
		if(name.length()!=0)
			product.setName(name);
		if(description.length()!=0)
			product.setDescription(description);
		if(num.length()!=0)
			product.setNum(Integer.parseInt(num));
		if(price.length()!=0)
			product.setPrice(Double.parseDouble(price));
		if(type.length()!=0)
			product.setType(type);
        if(file!=null&&fileFileName!=null&&fileFileName.length()!=0){
    		//产生img_id
    		Date date = new Date();
    		String[] tmp= fileFileName.split("\\.");
    		String houzhui=tmp[tmp.length-1];
    		long img_id=date.getTime();
    		setFileFileName(img_id+"."+houzhui);
    		if(!upload().equals(SUCCESS)){
    			return ERROR;
    		}
    		product.setImg_id(img_id);
        }
        if(management_Omega.changeProduct(product))
        	return SUCCESS;
		return ERROR;
	}
	
	/**
	 * 查找商品
	 * @param keyword
	 * */
	private String content;
	public String search(){
		if(content.length()!=0){
			return SUCCESS;
		}
		return ERROR;
	}
	/**
	 * @return the file
	 */
	public File getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * @return the fileFileName
	 */
	public String getFileFileName() {
		return fileFileName;
	}

	/**
	 * @param fileFileName the fileFileName to set
	 */
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	/**
	 * @return the fileContentType
	 */
	public String getFileContentType() {
		return fileContentType;
	}

	/**
	 * @param fileContentType the fileContentType to set
	 */
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the num
	 */
	public String getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(String num) {
		this.num = num;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the shopId
	 */
	public String getShopId() {
		return shopId;
	}

	/**
	 * @param shopId the shopId to set
	 */
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	

	
}
