package entity;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 分页类
 * @author Administrator
 * @date 2018/7/21 0021
 */
public class PageResult  implements Serializable {

    //总记录数
    private long total;

   //当前页记录数
   private List rows;

   //构造方法
    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

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
