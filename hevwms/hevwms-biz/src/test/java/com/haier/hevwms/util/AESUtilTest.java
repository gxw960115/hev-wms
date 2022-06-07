package com.haier.hevwms.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 17:02
 * @Description:
 */
public class AESUtilTest {

    @Test
    public void encrypt() {
        try {
            AESUtil.encrypt("11","1111111111111111");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void decrypt() {
        try {
            AESUtil.decrypt("11","1111111111111111");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}