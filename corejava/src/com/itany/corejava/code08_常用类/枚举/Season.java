package com.itany.corejava.code08_常用类.枚举;

/**
 * @author 石小俊
 * @date 2023年08月25日 14:01
 */
public enum Season {

    // 由于枚举类型主要是用于限制某个属性的值只能是该类中存在的某些内容
    // 因此,枚举类型不允许外部创建对象。需要在内部直接创建对象
    // 在创建对象的时候,就对外部允许使用的内容进行定义了
    // 此处用于在内部创建枚举类型所对应的对象
    // 要求创建的对象外部能够直接访问到,且外部无法直接修改其值
    // 外部直接访问表示修饰符为public,外部无法修改值表示定义为静态常量,属性名全部大写
    // public static final Season SPRING = new Season("春天",1,3)
    // 在枚举类中,要求所有固定部分的内容全部省略掉,枚举会自动添加
    // 如果需要定义多个值,多个值之间以逗号分隔
    // 此处括号的内容表示调用的构造方法的参数,如果没有参数,括号可以省略
    SPRING("春天", 1, 3),
    SUMMER("夏天", 4, 6),
    AUTUMN("秋天", 7, 9),
    WINTER("冬天", 10, 12),
    ALL;
    private String name;    // 季节
    private int beginMonth; // 开始月份
    private int endMonth;   // 结束月份

    // 对于构造方法,由于枚举类型不允许外部去创建对象,只能在内部创建对象
    // 因此,其构造方法必须是私有方法
    // 修饰符可以省略,默认为private
    Season(String name, int beginMonth, int endMonth) {
        this.name = name;
        this.beginMonth = beginMonth;
        this.endMonth = endMonth;
    }

    private Season() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBeginMonth() {
        return beginMonth;
    }

    public void setBeginMonth(int beginMonth) {
        this.beginMonth = beginMonth;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }
}
