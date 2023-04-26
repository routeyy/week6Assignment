package week6;

public class WarCard {
  private String name;
  private String suit;
  private int value;
  
  public WarCard() {}
  
  public WarCard(String name, String suit, int value) {
    this.name = name;
    this.suit = suit;
    this.value = value;
  }

  @Override
  public String toString() {
    return name + " of " + suit;
  }

  public int getValue() {
    return value;
  }

}
