package com.itany.corejava.code13_jdbc;

import java.io.Serializable;

/**
 * @author 石小俊
 * @date 2023年09月13日 13:31
 */
public class Dept implements Serializable {
    private Integer id;
    private String name;
    private String remark;

    public Dept() {
    }

    public Dept(String name, String remark) {
        this.name = name;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
