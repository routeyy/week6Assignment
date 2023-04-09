package week6;

import java.util.ArrayList;
import java.util.List;

public class Player {

  private List<Card> hand = new ArrayList<Card>();
  private int score;
  private String name;
  
  public void describe() {   //Prints out the player's name and their hand.
    System.out.println(name + "'s Cards:" + "\n---");
    for(Card card : hand) {
      card.describe();
    }
  }
  
  public Card flip() {   //Flips the card on the top of each player's hand.
    Card card = hand.remove(0);
    return card;
  }
  
  public void draw(Deck deck) {   //Draws a card from the deck and places it into the player's hand.
    hand.add(deck.draw());
  }
  
  public void incrementScore() {   //Increments a player's score by one.
    setScore(getScore() + 1);
  }
  
  /*
   * Getters and Setters.
   */
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
}
