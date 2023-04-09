package week6;

public class Card {

  private int value;
  private String name;
  private String suit;
  
  public void describe() {   //Describes the card.
    System.out.println("Card: " + name + " of " + suit);
  }
  
  public Card() {}   //Default Constructor.
  
  public Card(int value, String name, String suit) {   //Places information on the card.
    this.value = value;
    this.name = name;
    this.suit = suit;
  }

  /*
   * Getters and Setters.
   */
  
  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getSuit() {
    return suit;
  }
  
  public void setSuit(String suit) {
    this.suit = suit;
  }
}
