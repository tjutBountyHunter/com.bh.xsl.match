package com.xsl.result;

import java.io.Serializable;
import java.util.List;

/**
 * 说明：EasyUi标准返回
 *
 * @Auther: 11432_000
 * @Date: 2019/4/22 13:23
 * @Description:
 */
public class EasyUIDataGridResult implements Serializable {
    private long total;
    private List rows;
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public List getRows() {
        return rows;
    }
    public void setRows(List rows) {
        this.rows = rows;
    }
}
