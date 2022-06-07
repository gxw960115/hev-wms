package com.haier.wms.util;

import java.util.ArrayList;
import java.util.List;

import com.haier.openplatform.util.Pager;

/**
 * @ClassName: PageUtil
 * @Description:
 * @Author: suiyi
 * @Date：2015-6-28 下午3:46:21
 */
public class PageUtil {

    public static PageBean setPager(Pager pager) {
        PageBean bean = new PageBean();
        bean.setTotal(pager.getTotalRecords());
        bean.setRows(pager.getRecords() == null ? new ArrayList() : pager
                .getRecords());
        return bean;

    }

    public static PageBean setPager(List list) {
    	if (list == null){
    		list = new ArrayList() ;
    	}
        PageBean bean = new PageBean();
        bean.setTotal(Long.valueOf(list.size()));
        bean.setRows(list);
        return bean;

    }

}
