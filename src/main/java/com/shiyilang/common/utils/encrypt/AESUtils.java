package com.shiyilang.common.utils.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * @Destription:AES加解密
 * @Auther:shiyilang
 * @Date:2018/11/29 22:38
 * @Version:1.0
 */
class AESUtils {
    /** 默认秘钥 */
    protected static final String KEY = "NOPO3nzMD3dndwS0MccuMeXCHgVlGOoYyFwLdS24Im2e7YyhB0wrUsyYf0";

    /**
     * @Description:AES解密
     * @Date 2018/11/29 22:52
     * @Param [encryptValue, key]
     * @return java.lang.String
     */
    protected static String decrypt(String encryptValue, String key) throws Exception {  
        return aesDecryptByBytes(base64Decode(encryptValue), key);  
    }
    
    /**
     * @Description:AES加密
     * @Date 2018/11/29 22:52
     * @Param [value, key]
     * @return java.lang.String
     */
    protected static String encrypt(String value, String key) throws Exception {  
        return base64Encode(aesEncryptToBytes(value, key));  
    }  

    private static String base64Encode(byte[] bytes){  
        return Base64Utils.encrypt(bytes);  
    }  
      
    @SuppressWarnings("static-access")
    private static byte[] base64Decode(String base64Code) throws Exception{  
        return base64Code == null ? null : new Base64Utils().decrypt(base64Code);  
    }  
      
    private static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {  
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128, new SecureRandom(encryptKey.getBytes()));  
  
        Cipher cipher = Cipher.getInstance("AES");  
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));  
          
        return cipher.doFinal(content.getBytes("utf-8"));  
    }  
      
    private static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {  
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128, new SecureRandom(decryptKey.getBytes()));  
          
        Cipher cipher = Cipher.getInstance("AES");  
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));  
        byte[] decryptBytes = cipher.doFinal(encryptBytes);  
          
        return new String(decryptBytes);  
    }  
    
}
