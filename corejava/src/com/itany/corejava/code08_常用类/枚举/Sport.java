package com.itany.corejava.code08_常用类.枚举;

/**
 * @author 石小俊
 * @date 2023年08月25日 13:56
 */
public class Sport {

    private String name; // 运动的项目
    // private String season; // 适合的季节
    private Season season; // 适合的季节

    public Sport(String name, Season season) {
        this.name = name;
        this.season = season;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
