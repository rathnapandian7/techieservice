package org.example.config;


import lombok.SneakyThrows;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StreamUtils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class DesPasswordEncoder implements PasswordEncoder {

    private static final String KEYS_PATH = "/keys/";

    private SecretKey secretKey;
    private SecretKey passwordKey;

    public DesPasswordEncoder() {
        secretKey = this.getSecretKey("key.out");
        passwordKey = this.getSecretKey("pwkey.out");
    }

    //    private static Key generateKey() throws Exception {
//        Key key = new SecretKeySpec(keyValue, ALGO);
//        return key;
//    }
//    public static void main(String args[]) {
//
//        String password = "test";
//        DesPasswordEncoder DesPasswordEncoder = new DesPasswordEncoder();
//        System.out.println("Encrypted Password --: " + DesPasswordEncoder.encryptPassword(password));
////
//////        gYeWCLs70+hZSopBthkWJgMvD1lyf57kHXOJ9JY30UZbDVikTTUX5nHDhbIipT1Y5nyo+vC1ZNLHkL9efDSVV37c2wTUa5XyWgGnmWvbQRzSayj5h4OM6qShVn1o2or2hTvSG6q9S/zqJWVHUuKVHLslb5vy3sOfVlbNwBlRytdxcYXhMVfTZ6o3jkvYGxfTBzHFVvWMYmANFao6CDHvrzF0XGAV0o7hGLuF2qS/wS6jOcG+vEIRSVCoAYTmqidu
//        String encryptedPassword = "gYeWCLs70+hZSopBthkWJgMvD1lyf57kHXOJ9JY30UZbDVikTTUX5nHDhbIipT1Y5nyo+vC1ZNLHkL9efDSVV37c2wTUa5XyWgGnmWvbQRzSayj5h4OM6qShVn1o2or2hTvSG6q9S/zqJWVHUuKVHLslb5vy3sOfVlbNwBlRytdxcYXhMVfTZ6o3jkvYGxfTBzHFVvWMYmANFao6CDHvrzF0XGAV0o7hGLuF2qS/wS6jOcG+vEIRSVCoAYTmqidu";
////		System.out.println("decryptPassword Password "+DesPasswordEncoder.decryptPassword(encryptedPassword));
//////
//    }

    @Override
    @SneakyThrows
    public String encode(CharSequence rawPassword) {
        return this.encryptPassword(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return this.decryptPassword(encodedPassword).equals(rawPassword.toString());
    }

    private Cipher createCipher(int cipherMode) {
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("DESede");
            cipher.init(cipherMode, this.secretKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cipher;
    }

    private SecretKey getSecretKey(String fileName) {
        SecretKey key = null;
        try (InputStream in = this.getClass().getResourceAsStream(KEYS_PATH + fileName)) {
            byte[] bytes = StreamUtils.copyToByteArray(in);
            DESedeKeySpec keyspec = new DESedeKeySpec(bytes);
            SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
            key = keyfactory.generateSecret(keyspec);
        } catch (Exception ie) {
            ie.printStackTrace();
        }
        return key;
    }

    @SneakyThrows
    public String encryptPassword(String password) {
        // String password="$2a$04$I9Q2sDc4QGGg5WNTLmsz0.fvGv3OjoZyj81PrSFyGOqMphqfS2qKu";
        password = password + Base64.getEncoder().encodeToString(passwordKey.getEncoded());
        byte[] encodedPassword = password.getBytes(StandardCharsets.UTF_16);
        Cipher cipher = this.createCipher(Cipher.ENCRYPT_MODE);
        byte[] encryptedPassword = cipher.doFinal(encodedPassword);
        System.out.println(Base64.getEncoder().encodeToString(encryptedPassword));
        return Base64.getEncoder().encodeToString(encryptedPassword);
    }

    @SneakyThrows
    public String decryptPassword(String password) {
//        String decordedValue = new BASE64Decoder().decodeBuffer(password).toString().trim();
//        System.out.println("This is Data to be Decrypted" + decordedValue);
//        return decordedValue;
        byte[] decodedPassword = Base64.getMimeDecoder().decode(password.getBytes());
        Cipher cipher = this.createCipher(Cipher.DECRYPT_MODE);
        byte[] utf16 = cipher.doFinal(decodedPassword);
        String decryptedPassword = new String(utf16, StandardCharsets.UTF_16);
        return decryptedPassword.split("/")[0];

    }
}


