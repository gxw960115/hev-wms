package com.haier.hevwms.util;

import net.sf.json.JsonConfig;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auther: mahuansen
 * @Date: 2019/5/15 17:12
 * @Description:
 */
public class DateJsonValueProcessorTest {

    private DateJsonValueProcessor dateJsonValueProcessor = new DateJsonValueProcessor("yyyy-mm-dd");

    @Test
    public void processArrayValue() {
        dateJsonValueProcessor.processArrayValue("",new JsonConfig());
    }

    @Test
    public void processObjectValue() {
        dateJsonValueProcessor.processObjectValue("111","11",new JsonConfig());
    }
}