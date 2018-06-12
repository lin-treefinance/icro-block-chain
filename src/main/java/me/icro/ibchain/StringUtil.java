package me.icro.ibchain;

import java.security.MessageDigest;

/**
 *
 * Created by Lin on 2018/6/11.
 */
public class StringUtil {

    public static String sha256(String input) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append("0");
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getDifficultyString(int difficulty) {
        return new String(new char[difficulty]).replace("\0", "0");
    }
}
