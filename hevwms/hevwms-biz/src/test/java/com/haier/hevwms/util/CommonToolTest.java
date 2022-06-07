package com.haier.hevwms.util;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 17:06
 * @Description:
 */
public class CommonToolTest {

    private CommonTool commonTool = new CommonTool();

    @Test
    public void isNull() {
        CommonTool.isNull("11");
    }

    @Test
    public void getString() {
        CommonTool.getString("111");
    }

    @Test
    public void getString1() {
        CommonTool.getString(1);
        CommonTool.getString(0);
    }

    @Test
    public void delete() {
        commonTool.delete("111111","1");
    }

    @Test
    public void replace() {
        CommonTool.replace("1111","111","aa");
    }

    @Test
    public void getCurrentDate() {
        CommonTool.getCurrentDate("YYYY-MM-DD");
    }

    @Test
    public void getCode() {
        CommonTool.getCode(1,10,"111","222");
    }

    @Test
    public void getFormatDateToStr() {
        CommonTool.getFormatDateToStr(new Date());
    }
}