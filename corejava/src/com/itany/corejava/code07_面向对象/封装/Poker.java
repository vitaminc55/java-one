package com.itany.corejava.code07_面向对象.封装;

/**
 * @author 石小俊
 * @date 2023年08月17日 14:15
 */
public class Poker {

    private Card[] cards;

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public Card[] getCards() {
        return cards;
    }

    /**
     * 定义Poker的构造方法,为一个Poker对象填充54个Card
     */
    public Poker() {
        // 定义一副牌共有54张牌,即Card数组长度为54
        cards = new Card[54];
        // 定义每张牌的花色范围
        String[] colors = {"黑桃", "红桃", "梅花", "方块"};
        // 定义每一张牌的点数范围
        String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        // 将每一种花色与每一种点数进行组合,组成成一副牌
        // 定义一个card的初始下标,下标从0开始
        int index = 0;
        // 外层循环控制花色
        for (int i = 0; i < colors.length; i++) {
            // 内层循环控制点数
            for (int j = 0; j < nums.length; j++) {
                cards[index++] = new Card(colors[i], nums[j]);
            }
        }

        // 除了上述的52张牌以外,还有两张特殊的牌:大王与小王
        cards[index++] = new Card("大", "王");
        cards[index++] = new Card("小", "王");
    }


    /**
     * 洗牌,将一副牌的顺序打乱
     */
    public void shuffle() {
        // 定义一个相同长度、相同类型的数组, 用于存放洗牌后的数据
        Card[] cards = new Card[54];

        // 为洗牌后的数组进行赋值,其值取自于未洗牌前的数组
        for (int i = 0; i < cards.length; i++) {
            // 随机获取到未洗牌前的数组中的某一张牌
            // 先获取一个随机数,用于表示未洗牌前的数组的下标。其范围:0-53
            int index = (int) (Math.random() * 54);
            // 从未洗牌前的数组中取出对应的牌
            Card card = this.cards[index];

            // 随机取出的牌可能是重复,如果重复,数据无效
            // 在从原数组中取出牌之后,原数组对应下标的元素值为null
            // 此时可以判断从原数组中取出的牌是否为null
            while (card == null) {
                // 如果其值为null,说明对应的牌已经取过了
                // 需要重写获取一张新的
                index = (int) (Math.random() * 54);
                card = this.cards[index];
            }

            // 如果取出的牌不为null,说明尚未取出过
            // 将取出的牌赋值给新的数组
            cards[i] = card;
            // 当从原数组中获取对应的牌了之后
            // 将原数组对应下标的值设置为null
            // 那么下次从原数组中获取牌的时候,如果值为null,说明已经取过了
            this.cards[index] = null;
        }

        // 将新的数组的值赋值给全局变量
        this.cards = cards;
    }

}
