/**
 * 
 */
package cn.ssdut.omega.management;

import java.util.List;

import cn.ssdut.omega.entity.Remark_Omega;
import cn.ssdut.omega.sqlutil.SQLHelper_Omega;

/**
 * @author Kevin
 * @date 2017-07-14
 * 评论管理类
 */
public class RemarkManagement_Omega {

	SQLHelper_Omega helper;
	//数据库操作类
	
	/**
	 * 构造函数，初始化数据库帮助类
	 * */
	public RemarkManagement_Omega() {
	    helper= new SQLHelper_Omega();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param remark
	 * 添加评论
	 * */
	public boolean addRemark(Remark_Omega remark){
		return helper.save(remark);
	}
	
	/**
	 * @param id
	 * 删除评论
	 * */
	public boolean deleteRemark(long id){
		return helper.deleteRemark(id);
	}
	
	/**
	 * @param remark
	 * 修改评论
	 * */
	public boolean updateRemark(Remark_Omega remark){
		return helper.update(remark);
	}
	
	/**
	 * @param id
	 * 查找评论
	 * */
	public Remark_Omega findRemarkById(long id){
		return helper.findRemarkById(id);
	}
	
	/**
	 * @param productId
	 * 查找评论
	 * */
	public List<Remark_Omega> findRemarkByProductId(long productId){
		return helper.findAllRemarkByProductId(productId);
	}
	
	/**
	 * @param userId
	 * 查找评论
	 * */
	public List<Remark_Omega> findRemarkByUserId(long userId){
		return helper.findAllRemarkByUserId(userId);
	}
}
