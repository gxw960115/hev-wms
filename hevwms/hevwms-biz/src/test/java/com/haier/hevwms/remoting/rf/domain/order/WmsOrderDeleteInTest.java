package com.haier.hevwms.remoting.rf.domain.order;

import org.junit.Test;

import static org.junit.Assert.*;

public class WmsOrderDeleteInTest {
    @Test
    public void init(){
        WmsOrderDeleteIn deleteIn = new WmsOrderDeleteIn();
        deleteIn.setUser("");
        deleteIn.setSign("");
        deleteIn.setDoctype("");
        deleteIn.setOrdertype("");
        deleteIn.setOrno("");
        deleteIn.setBarcode("");

        deleteIn.getUser();
        deleteIn.getSign();
        deleteIn.getDoctype();
        deleteIn.getOrdertype();
        deleteIn.getOrno();
        deleteIn.getBarcode();

    }
}