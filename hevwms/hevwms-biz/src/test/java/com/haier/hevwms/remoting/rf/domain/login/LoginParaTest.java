package com.haier.hevwms.remoting.rf.domain.login;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 * <p>
 * description:
 *
 * @author LiuJiazhen
 * @version v1.0.0
 * @date 2019/11/26 16:52
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/11/26      LJZ     v1.0.0      create
 */
public class LoginParaTest {

    @Test
    public void test() {
        LoginPara tar = new LoginPara();
        tar.setPass(tar.getPass());
        tar.setUser(tar.getUser());
        tar.setIp(tar.getIp());
    }

}
