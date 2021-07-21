package com.test.coding.task.src.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils {
    private static MessageDigest md = null;

    static {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static final char[] HEX_ABC_HI = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static String makeHex(byte[] bytes, char[] abc) {
        char[] chars = new char[2 * bytes.length];

        int strIndex = 0;
        for (byte code : bytes) {
            chars[strIndex++] = abc[(code >> 4) & 0xF];
            chars[strIndex++] = abc[code & 0xF];
        }

        return new String(chars);
    }

    private static String toHex(byte[] bytes) {
        if (bytes == null) return null;
        return makeHex(bytes, HEX_ABC_HI);
    }

    public static String md5(String value) {
        md.update(value.getBytes());
        return toHex(md.digest());
    }
}
