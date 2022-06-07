package com.haier.hevwms.portal.domain;
import java.util.Date;

import org.junit.Test;

/**
 * Copyright © 2019 LiuJiazhen
 *
 * @ClassName: com.haier.hevwms.portal.domain
 * @Description:
 * @Version: v1.0.0
 * @Author: LiuJiazhen
 * @Date 2019/3/20 9:50
 * <p>
 * Modification History
 * Date     Author      Version     Description
 * ---------------------------------------------------------*
 * 2019/3/20      LJZ     v1.0.0      create
 */
public class NoticeInfoTest {
    @Test
    public void test() {
        NoticeInfo target = new NoticeInfo();
        Date date = new Date();
        target.setNoticeId(0L);
        target.setAppCode("");
        target.setTitle("");
        target.setStatus("");
        target.setValidTime(date);
        target.setInvalidTime(date);
        target.setPublisherId("");
        target.setPublishedTime(date);
        target.setCreatedTime(date);
        target.setCreatorId("");
        target.setIsAppoved("");
        target.setApproverCode("");
        target.setApproveResult("");
        target.setNoticeType(0);
        target.setNoticeClass("");
        target.setTopFlag("");
        target.setAttachCnt(0);
        target.setReadFlag("");
        target.setContent("");

        target.getNoticeId();
        target.getAppCode();
        target.getTitle();
        target.getStatus();
        target.getValidTime();
        target.getInvalidTime();
        target.getPublisherId();
        target.getPublishedTime();
        target.getCreatedTime();
        target.getCreatorId();
        target.getIsAppoved();
        target.getApproverCode();
        target.getApproveResult();
        target.getNoticeType();
        target.getNoticeClass();
        target.getTopFlag();
        target.getAttachCnt();
        target.getReadFlag();
        target.getContent();

    }
}