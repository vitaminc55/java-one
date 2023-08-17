package com.itany.corejava.code07_面向对象.封装;

/**
 * @author 石小俊
 * @date 2023年08月17日 14:25
 */
public class Test03 {

    public static void main(String[] args) {
        Poker poker = new Poker();
        Card[] cards = poker.getCards();
        for(Card card : cards){
            System.out.print(card.getColor()+card.getNum()+"\t");
        }
    }

}
