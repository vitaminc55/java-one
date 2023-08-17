package com.itany.corejava.code07_面向对象.封装;

/**
 * @author 石小俊
 * @date 2023年08月17日 14:15
 */
public class Card {

    private String color; // 花色
    private String num; // 点数

    public Card(){

    }

    public Card(String color,String num){
        this.color = color;
        this.num = num;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setNum(String num){
        this.num = num;
    }

    public String getColor(){
        return color;
    }

    public String getNum(){
        return num;
    }

}
