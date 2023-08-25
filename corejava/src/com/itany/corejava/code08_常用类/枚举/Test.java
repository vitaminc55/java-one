package com.itany.corejava.code08_常用类.枚举;

/**
 * @author 石小俊
 * @date 2023年08月25日 13:58
 */
public class Test {

    public static void main(String[] args) {
//        Sport sport = new Sport("滑雪",SeasonConstant.WINTER);
//        Sport sport2 = new Sport("滑雪","aaa");
//        Season season = new Season("冬天",10,12);
//        Sport sport = new Sport("滑雪",season);
        Sport sport = new Sport("放风筝", Season.SPRING);
        Sport sport2 = new Sport("游泳", Season.SUMMER);
        Sport sport3 = new Sport("秋收", Season.AUTUMN);
        Sport sport4 = new Sport("滑雪", Season.WINTER);
        Sport sport5 = new Sport("打篮球", Season.ALL);
    }

}
