package week6;

import java.util.Collections;
import java.util.List;

@SuppressWarnings("serial")
public class WarDeck extends AbstractCardList {
  private List<String> cardNames;
  private List<String> cardSuits;
  private int startingCardValue;
  private boolean regCards = true;

  public WarDeck() {
    initLists();
    
    for(int cardValue = startingCardValue; cardValue < cardNames.size() + startingCardValue; cardValue++) {
      String cardName = cardNames.get(cardValue - startingCardValue);
      createCards(cardName, cardValue);
    }
  }
  
  private void createCards(String cardName, int cardValue) {
    for(String cardSuit : cardSuits) {
      add(new WarCard(cardName, cardSuit, cardValue));
    }
  }

  private void initLists() {
    if(regCards) {
      cardNames = List.of("Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
      "Nine", "Ten", "Jack", "Queen", "King", "Ace");
      cardSuits = List.of("Clubs", "Diamonds", "Hearts", "Spades");
      startingCardValue = 2;
    } else {
      System.out.println("No other cards available.");
    }
  }
  
  public void describe() {
    System.out.println(this);   //WILL call the toString() method, in both the WarDeck and WarCard classes
  }

  public void shuffle() {
    Collections.shuffle(this);
  }

  public WarCard draw() {
    return this.remove(0);
  }


}
