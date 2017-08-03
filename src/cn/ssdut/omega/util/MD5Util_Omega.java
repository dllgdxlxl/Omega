/**
 * 
 */
package cn.ssdut.omega.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Kevin
 *  2017-07-12
 * MD5加密工具类
 */
public class MD5Util_Omega {

	/**
     * 获取MD5加密
     * 
     * @param content
     *            需要加密的字符串
     * @return String字符串 加密后的字符串
     */
    public static String changeToMD5(String content) {
        try {
            // 创建加密对象
            MessageDigest digest = MessageDigest.getInstance("md5");
            // 调用加密对象的方法，加密的动作已经完成
            byte[] bs = digest.digest(content.getBytes());
            String hexString = "";
            for (byte b : bs) {
                int temp = b & 255;
                if (temp < 16 && temp >= 0) {
                    // 手动补上一个“0”
                    hexString = hexString + "0" + Integer.toHexString(temp);
                } else {
                    hexString = hexString + Integer.toHexString(temp);
                }
            }
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
}
