package cracking.oop.cardgroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck<T extends Card> {

    private List<T> cards;
    private int dealtIndex = 0;

    public void setDeckOfCards(List<T> deckOfCards) {
        cards = deckOfCards;
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int j = getRandomInt(i, random);
            T card1 = cards.get(i);
            T card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public T[] dealHand(int number){
        //TODO
        if (remainingCards() < number){
            return null;
        }

        T[] hand = (T[]) new Card[number];
        int count = 0;
        while (count < number){
            T card = dealCard();
            if (card != null){
                hand[count] = card;
                count++;
            }

        }

        return hand;
    }

    public T dealCard(){
        if (remainingCards() == 0){
            return null;
        }

        T card = cards.get(dealtIndex);
        card.markUnavailable();
        dealtIndex++;

        return card;
    }

    public void print(){
        for (T card : cards) {
            card.print();
        }
    }

    private int getRandomInt(int i, Random random) {
        return i + random.nextInt(cards.size() - i);
    }


}