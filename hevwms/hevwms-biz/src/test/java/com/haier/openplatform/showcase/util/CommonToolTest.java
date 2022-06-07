package com.haier.openplatform.showcase.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 17:33
 * @Description:
 */
public class CommonToolTest {

    @Test
    public void isNull() {
        CommonTool.isNull("11");
    }

    @Test
    public void getCurrentDate() {
        CommonTool.getCurrentDate("yyyy-mm-dd");
    }

    @Test
    public void getCurrentMonthLastDate() {
        CommonTool.getCurrentMonthLastDate();
    }

    @Test
    public void getMonthLastDate() {
        CommonTool.getMonthLastDate("05");
    }

    @Test
    public void getCurrentLastDate() {
        CommonTool.getCurrentLastDate("yyyy-mm-dd");
    }

    @Test
    public void replaceToSqlStr() {

        CommonTool.replaceToSqlStr("111");
    }

    @Test
    public void numberFormat() {
        CommonTool.numberFormat("11");
    }

    @Test
    public void decimalFormat() {
        CommonTool.decimalFormat("111.0");
    }

    @Test
    public void decimalFourFormat() {
        CommonTool.decimalFourFormat("1111.0");
    }

    @Test
    public void decimalFour() {
        CommonTool.decimalFour("11.1");
    }

    @Test
    public void getNewDate() {
        CommonTool.getNewDate("yyyy-mm-dd","2019-05-10",1);
    }

    @Test
    public void replaceToSqlStr1() {
        CommonTool.replaceToSqlStr(new String[]{"111"});
    }

    @Test
    public void getCode() {
        CommonTool.getCode(1,10,"111","aa");
    }

    @Test
    public void getRandomNum() {
        CommonTool.getRandomNum(10,10);
    }

    @Test
    public void clearTab() {
    }

    @Test
    public void getDateByStorageDaysAgo() {
    }

    @Test
    public void getFormatDateToStr() {
    }
}