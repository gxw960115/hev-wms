package com.haier.hevwms.remoting.rf.domain.order;

import org.junit.Test;

import static org.junit.Assert.*;

public class WmsOrderDeleteOutTest {
    @Test
    public void init(){
        WmsOrderDeleteOut deleteOut = new WmsOrderDeleteOut();
        deleteOut.setStatus("");
        deleteOut.setMsg("");
        deleteOut.setLocation("");
        deleteOut.setMatno("");
        deleteOut.setMatdesc("");
        deleteOut.setScanqty(0);
        deleteOut.setPoqty(0);

        deleteOut.getStatus();
        deleteOut.getMsg();
        deleteOut.getLocation();
        deleteOut.getMatno();
        deleteOut.getMatdesc();
        deleteOut.getScanqty();
        deleteOut.getPoqty();

    }
}