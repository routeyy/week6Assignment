package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

  private List<Card> cards = new ArrayList<Card>();
  
  public void shuffle() {   //Shuffles the deck.
    Collections.shuffle(cards);
  }
  
  public Card draw() {   //Draws a card from the deck.
    Card card = cards.remove(0);
    return card;
  }
  
  public Deck() {   //Creates a deck of cards.
    
    String[] cardNames = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                      "Jack", "Queen", "King", "Ace"};
    String[] cardSuits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    
    int nameCounter = 0;
    int suitCounter = 0;
    int value = 2;
    
    for(int i = 0; i < 52; i++) {
      Card card = new Card(value, cardNames[nameCounter], cardSuits[suitCounter]);
      nameCounter++;
      suitCounter++;
      value++;
      if(nameCounter > 12) {
        nameCounter = 0;
      }
      if(suitCounter > 3) {
        suitCounter = 0;
      }
      if(value > 14) {
        value = 2;
      }
      cards.add(card);
    }
  }
  
}
