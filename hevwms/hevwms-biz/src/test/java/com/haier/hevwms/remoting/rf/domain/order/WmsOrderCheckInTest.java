package com.haier.hevwms.remoting.rf.domain.order;

import org.junit.Test;

public class WmsOrderCheckInTest {
    @Test
    public void init(){

        WmsOrderCheckIn checkIn = new WmsOrderCheckIn();
        checkIn.setUser("");
        checkIn.setSign("");
        checkIn.setDoctype("");
        checkIn.setOrdertype("");
        checkIn.setOrno("");
        checkIn.setItemNo("");
        checkIn.setDnType("");

        checkIn.getUser();
        checkIn.getSign();
        checkIn.getDoctype();
        checkIn.getOrdertype();
        checkIn.getOrno();
        checkIn.getItemNo();
        checkIn.getDnType();

    }
}