package com.itany.shop.util;

import java.util.List;

/**
 * @author 黄鹏程
 * @date 2023年09月20日11:21
 */
public class PageInfo<T> {
    private int total;
    private int pages;
    private int pageNo;
    private int pageSize;
    private List<T> list;

    public PageInfo(int total, int pageNo, int pageSize, List<T> list) {
        this.total = total;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.list = list;
        pages = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;
    }

    public int getPrePage() {
        return pageNo > 1 ? pageNo - 1 : 1;
    }

    public int getNextPage() {
        return pageNo < pages ? pageNo + 1 : pages;
    }

    public int getHeadPage() {
        return 1;
    }

    public int getFootPage() {
        return pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
