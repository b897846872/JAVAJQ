package com.blog.common;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 获取32位UUID
 */
public final class UUIDGenerator {

    private static final org.apache.commons.logging.Log LOG = 
        org.apache.commons.logging.LogFactory.getLog(UUIDGenerator.class);

    private static String baseUUID = null;
    private static long incrementingValue = 0;


    private static Random myRand = null;
    
    private UUIDGenerator() {
        // Complete
    }

    /**
     * MD5 a random string with localhost/date etc will return 128 bits
     * construct a string of 18 characters from those bits.
     *
     * @return string
     */
    public static synchronized String getUUID() {
        if (baseUUID == null) {
            getInitialUUID();
        }
        long i = ++incrementingValue;
        if (i >= Long.MAX_VALUE || i < 0) {
            incrementingValue = 0;
            i = 0;
        }
        return (baseUUID + System.currentTimeMillis() + i).substring(0, 31);
    }

    protected static synchronized void getInitialUUID() {
        if (baseUUID != null) {
            return;
        }
        if (myRand == null) {
            myRand = new Random();
        }
        long rand = myRand.nextLong();
        String sid;
        try {
            sid = InetAddress.getLocalHost().toString();
        } catch (UnknownHostException e) {
            sid = Thread.currentThread().getName();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sid);
        sb.append(":");
        sb.append(Long.toString(rand));
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug(e.getMessage(), e);
            }
            //todo have to be properly handled
        }
        md5.update(sb.toString().getBytes());
        byte[] array = md5.digest();
        StringBuilder sb2 = new StringBuilder();
        for (int j = 0; j < array.length; ++j) {
            int b = array[j] & 0xFF;
            sb2.append(Integer.toHexString(b));
        }
        int begin = myRand.nextInt();
        if (begin < 0) {
            begin = begin * -1;
        }
        begin = begin % 8;
        baseUUID = sb2.toString().substring(begin, begin + 18).toUpperCase();
    }

}

