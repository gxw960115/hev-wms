package com.haier.wms.util;

import java.util.List;

/**
 * @ClassName: PageBean
 * @Description:
 * @Author: Administrator
 * @Date：2015-6-28 下午3:44:31
 */
public class PageBean {
    public Long total;
    public List<Object> rows;

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

}
