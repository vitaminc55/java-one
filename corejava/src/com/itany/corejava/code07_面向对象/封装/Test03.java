package com.itany.corejava.code07_面向对象.封装;

/**
 * @author 石小俊
 * @date 2023年08月17日 14:25
 */
public class Test03 {

    public static void main(String[] args) {
        System.out.println("****************洗牌前的所有扑克牌****************");
        Poker poker = new Poker();
        Card[] cards = poker.getCards();
        for(Card card : cards){
            System.out.print(card.getColor()+card.getNum()+"\t");
        }

        System.out.println("\n****************洗牌后的所有扑克牌****************");
        poker.shuffle();
        cards = poker.getCards();
        for(Card card : cards){
            System.out.print(card.getColor()+card.getNum()+"\t");
        }

    }

}
