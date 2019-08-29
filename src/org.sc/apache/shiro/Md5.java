/*
package apache.shiro;

import org.apache.apache.shiro.codec.Base64;
import org.apache.apache.shiro.crypto.hash.Md5Hash;

*/
/**
 * Created by duizhuang on 7/2/2019.
 *//*

public class Md5 {
    */
/*
     * base64加密
     * *//*

    public static String encodeBase64(String str) {
        return Base64.encodeToString(str.getBytes());
    }

    */
/*
     * base64解密
     * *//*


    public static String decodeBase64(String str) {
        return Base64.decodeToString(str);
    }

    */
/*
     * Md5加密，shiro框架中自带Md5，Md5没有解密
     * *//*

    public static String md5(String str , String salt) {
        return new Md5Hash(str,salt).toString();
    }

    public static void main(String[] args) {
        String password = "123456";
        System.out.println("Base64加密:" + Md5.encodeBase64(password));
        String passwordBase64 = Md5.encodeBase64(password);
        System.out.println("Base64解密:" + Md5.decodeBase64(passwordBase64));
        //Md5加密应用到实际项目中开发比如：注册提交数据时对密码进行Md5加密得到的字符串存储到数据库
        //做用户验证时把数据库获取到的密码再和用户提交的密码（同样进行Md5加密）比较是否相同
        String salt = "md5_!_~+$shifferfef34ro_A7";
        String passwordMd5 =  Md5.md5(password, salt);
        System.out.println("Md5加密:" + passwordMd5 + "   " + passwordMd5.length());
    }
}
*/
