package com.haier.hevwms.remoting.rf.domain.login;

import org.junit.Test;

public class MenuTest {

    @Test
    public void init() {
        Menu info = new Menu();
        info.setCode("");
        info.setCdte("");
        info.setName("");
        info.setUrl("");

        info.getCode();
        info.getCdte();
        info.getName();
        info.getUrl();

    }

}