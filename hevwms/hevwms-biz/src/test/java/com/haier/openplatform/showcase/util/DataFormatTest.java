package com.haier.openplatform.showcase.util;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 17:43
 * @Description:
 */
public class DataFormatTest {

    @Test
    public void formatNumberToString() {
        DataFormat.formatNumberToString(11D,1);
    }

    @Test
    public void formatNumber() {
        DataFormat.formatNumber(1L);
    }

    @Test
    public void formatNumber1() {
        DataFormat.formatNumber(1D,1);
    }

    @Test
    public void parseDouble() {
        DataFormat.parseDouble("111");
    }

    @Test
    public void parseLong() {
        DataFormat.parseLong("111");
    }

    @Test
    public void formatDate() {
        try {
            DataFormat.parseDate("2019-05-10",1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void formatDate1() {
        DataFormat.formatDate(new Date());
    }

    @Test
    public void formatDate2() {
        DataFormat.formatDate(new Date(),1);
    }

    @Test
    public void parseDate() {
    }

    @Test
    public void parseDate1() {
    }

    @Test
    public void splitString() {
    }

    @Test
    public void formatString() {
    }

    @Test
    public void formatStringForHtml() {
    }

    @Test
    public void isNotBlank() {
    }

    @Test
    public void isBlank() {
    }

    @Test
    public void formatBigDecimaltoString() {
    }
}