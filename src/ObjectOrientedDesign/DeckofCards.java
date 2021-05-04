package ObjectOrientedDesign;
import java.util.ArrayList;

public class DeckofCards {
    /**
     * Design the data structures for a generic deck of cards.
     * Explain how you would subclass the data structures to implement blackjack.
     */
}


/*
public enum Suit{
    Club(0), Diamond(1), Heart(2), Spade(3);
    private int value;
    private Suit(int v){value = v}
    public int getValue(){return this.value}
    public static Suit getSuitFormValue(int value){return value}
}

class Deck<T extends Card> {
    private ArrayList<T> cards;
    private int dealtIndex = 0;

    public void setDeckOfCards(ArrayList<T> deckofCards){}

    public void shuffle(){}
    public int remainingCards(){
        return cards.size() - dealtIndex;
    }
    public T[] dealHand(int number){}
    public T dealCard(){}
}

abstract class Card{
    private boolean available = true;

    protected int faceValue;
    protected Suit suit;

    public Card(int c, Suit s){
        faceValue = c;
        suit = s;
    }
    public abstract int value();
    public Suit suit(){return suit;}

    public boolean isAvailable(){return available;}
    public void markUnavailable(){available = false;}
    public void markAvailable(){available = true;}
}

class Hand<T extends Card>{
    protected ArrayList<T> cards = new ArrayList<>();

    public int score(){
        int score = 0;
        for(T card: cards){
            score += card.value();
        }
        return score;
    }
    public void addCard(T card){
        cards.add(card);
    }
}

class BlackJackHand extends Hand<BlackJackCard>{
    public int score(){
        ArrayList<Integer> scores = possibleScore();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for(int score: scores){
            if(score > 21 && score < minOver)
                minOver = score;
            else if(score <= 21 && score > maxUnder)
                maxUnder = score;
        }
        return maxUnder = Integer.MIN_VALUE ? minOver : maxUnder;
    }

    private ArrayList<Integer> possibleScore(){}
    public boolean busted(){return score() > 21;}
    public boolean is21(){return score() == 21;}
    public boolean isBlackJack(){}
}

class BlackJackCard extends Card {
    public BlackJackCard(int c, Suit s){super(c,s);}
    public int value(){
        if(isAce()) return 1;
        else if(faceValue >= 11 && faceValue <= 13) return 10;
        return faceValue;
    }
    public int minValue(){
        if(isAce()) return 1;
        return value();
    }

    public int maxValue(){
        if(isAce()) return 1;
        return value();
    }
    public boolean isAce(){
        return faceValue == 1;
    }
    public boolean isFaceCard(){
        return faceValue >= 11 && faceValue <= 13;
    }
}
*/