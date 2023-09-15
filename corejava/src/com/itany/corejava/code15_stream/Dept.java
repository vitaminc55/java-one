package com.itany.corejava.code15_stream;

/**
 * @author 石小俊
 * @date 2023年09月15日 16:19
 */
public class Dept {

    private Integer id;
    private String name;

    public Dept(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
