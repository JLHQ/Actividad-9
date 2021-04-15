package actividad8cenjava;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Luis_
 */
public class Deck {
    
    private ArrayList<Card> mainDeck;
    private ArrayList<Card> helpDeck;
    Random rand;
    
    public Deck(){
        this.mainDeck = new ArrayList<Card>();
        for(int i = 0; i < Card.Suit.values().length; i++){
            for(int j = 0; j < Card.Color.values().length; j++){
                for(int k = 0; k < Card.Value.values().length; k++){
                    Card.Suit suit = Card.Suit.values()[i];
                    Card.Color color = Card.Color.values()[j];
                    Card.Value value = Card.Value.values()[k];
                    Card newCard = new Card(suit, color, value);
                    mainDeck.add(newCard);
                }
            }
        }
    }
    public void shuffleDeck(){
        rand = new Random();
        helpDeck = new ArrayList<Card>();
        for(int i = 0; i < mainDeck.size(); i++){
            helpDeck.add(mainDeck.remove(rand.nextInt(mainDeck.size())));
        }
        this.mainDeck = helpDeck;
    }
    public void drawHead(){
        Card head = (Card) this.mainDeck.remove(0);
        System.out.println(head + "Quedan: " + this.mainDeck.size() + " cartas en el mazo");
    }
    public void drawRandomCard(){
        rand = new Random();
        Card pick = (Card) this.mainDeck.remove(this.mainDeck.size() - 1);
        System.out.println(pick + "Quedan: " + this.mainDeck.size() + " cartas en el mazo");
    }
    public void drawHand(){
        rand = new Random();
        Card hand;
        for(int i = 0; i < 5; i++){
            hand = (Card) this.mainDeck.remove(rand.nextInt(mainDeck.size()));
            System.out.println(hand);
        }
        System.out.println("Quedan: " + this.mainDeck.size() + " cartas en el mazo");
    }
}
