// 
// 
// 

package com.ldu.util;

import java.security.MessageDigest;

public final class MD5
{
    public static final String md5(final String s) {
        final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        try {
            final byte[] btInput = s.getBytes();
            final MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            final byte[] md = mdInst.digest();
            final int j = md.length;
            final char[] str = new char[j * 2];
            int k = 0;
            for (final byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xF];
                str[k++] = hexDigits[byte0 & 0xF];
            }
            return new String(str);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(final String[] args) {
        System.out.println(md5("967042"));
    }
}
