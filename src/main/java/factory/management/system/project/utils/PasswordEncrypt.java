package factory.management.system.project.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * PasswordEncrypt
 *
 * @author ngchunho
 * @version 1.0.0
 * @description 密码加密方法
 * @date 2019/6/19 15:54
 */
public class PasswordEncrypt {

    /**
     * md5加密
     *
     * @param string
     * @return
     */
    public static String encodeByMd5(String string) {
        // 确定计算方法
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            Base64.Encoder base64Encoder = Base64.getEncoder();
            // 加密字符串
            return base64Encoder.encodeToString(md5.digest(string.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 加密失败返回原字符串
        return string;
    }
}
