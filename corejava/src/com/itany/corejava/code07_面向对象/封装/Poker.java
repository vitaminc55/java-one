package com.itany.corejava.code07_面向对象.封装;

/**
 * @author 石小俊
 * @date 2023年08月17日 14:15
 */
public class Poker {

    private Card[] cards;

    public void setCards(Card[] cards){
        this.cards = cards;
    }

    public Card[] getCards(){
        return cards;
    }

    /**
     * 定义Poker的构造方法,为一个Poker对象填充54个Card
     */
    public Poker(){
        // 定义一副牌共有54张牌,即Card数组长度为54
        cards = new Card[54];
        // 定义每张牌的花色范围
        String[] colors = {"黑桃","红桃","梅花","方块"};
        // 定义每一张牌的点数范围
        String[] nums = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

        // 将每一种花色与每一种点数进行组合,组成成一副牌
        // 定义一个card的初始下标,下标从0开始
        int index = 0;
        // 外层循环控制花色
        for(int i = 0; i < colors.length; i++){
            // 内层循环控制点数
            for(int j = 0; j < nums.length; j++){
                cards[index++] = new Card(colors[i],nums[j]);
            }
        }

        // 除了上述的52张牌以外,还有两张特殊的牌:大王与小王
        cards[index++] = new Card("大","王");
        cards[index++] = new Card("小","王");
    }

}
