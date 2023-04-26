package week6;

public class WarPlayer {
  private String name;
  private int score;
  private Hand hand = new Hand();
  
  public void draw(WarDeck deck) {
    hand.add(deck.draw());
  }
  
  public WarCard flip() {
    return hand.remove(0);
  }
  
  public void describe() {
    StringBuilder sb = new StringBuilder();
    sb.append("Player ").append(name).append("'s ").append(hand);
    System.out.println(sb.toString());
  }
  
  public void incrementScore() {
    setScore(getScore() + 1);
  }

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
  
  public Hand getHand() {
    return hand;
  }
}
