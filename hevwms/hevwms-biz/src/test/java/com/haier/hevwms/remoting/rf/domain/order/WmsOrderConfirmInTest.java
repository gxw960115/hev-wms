package com.haier.hevwms.remoting.rf.domain.order;

import org.junit.Test;

import static org.junit.Assert.*;

public class WmsOrderConfirmInTest {
    @Test
    public void init(){
        WmsOrderConfirmIn confirmIn = new WmsOrderConfirmIn();
        confirmIn.setUser("");
        confirmIn.setSign("");
        confirmIn.setDoctype("");
        confirmIn.setOrdertype("");
        confirmIn.setOrno("");
        confirmIn.setLocation("");

        confirmIn.getUser();
        confirmIn.getSign();
        confirmIn.getDoctype();
        confirmIn.getOrdertype();
        confirmIn.getOrno();
        confirmIn.getLocation();

    }
}