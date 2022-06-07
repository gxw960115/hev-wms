package com.haier.hevwms.remoting.rf.domain.login;

import org.junit.Test;

public class LoginResultTest {
    @Test
    public void init() {
        LoginResult loginResult = new LoginResult();
        loginResult.setStatus("");
        loginResult.setMsg("");
        loginResult.setName("");
        loginResult.setNickName("");
        loginResult.setSign("");
        loginResult.setLocation(null);
        loginResult.setMenu(null);

        loginResult.getStatus();
        loginResult.getMsg();
        loginResult.getName();
        loginResult.getNickName();
        loginResult.getSign();
        loginResult.getLocation();
        loginResult.getMenu();

    }
}