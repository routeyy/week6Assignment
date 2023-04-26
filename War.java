package week6;

import java.util.Scanner;

public class War {
  private WarPlayer player1;
  private WarPlayer player2;
  private WarDeck deck;
  private Scanner sc = new Scanner(System.in);
  private String dashes = "------------------------------";
  private String lf = System.lineSeparator();
  private boolean isReady; // Used to determine whether another round can start.
  private boolean canEnd; // Used to determine whether the game can end.

  public static void main(String[] args) {
    new War().run();
  }

  private void run() {
    displayTitle();
    askAndSetNames();
    shuffleDeck();
    dealCards();
    playWar();
    declareWinner();
  }

  private void displayTitle() {
    StringBuilder title = new StringBuilder();

    title.append(dashes).append(lf + lf).append("Welcome to War, a simple two-player card game.")
        .append(lf + lf).append(dashes).toString();

    System.out.println(title);
  }

  private void askAndSetNames() {
    player1 = new WarPlayer();
    player2 = new WarPlayer();
    System.out.print(lf + "Player1, please type your name: ");
    player1.setName(sc.nextLine());
    System.out.print("Player2, please type your name: ");
    player2.setName(sc.nextLine());
    System.out.println(lf + dashes + lf);
  }

  private void shuffleDeck() {
    deck = new WarDeck();
    deck.shuffle();
    deck.describe();
    System.out.println(dashes + lf);
  }

  private void dealCards() {
    int deckSize = deck.size();
    for (int dealNum = 0; dealNum < deckSize; dealNum++) {
      if (dealNum % 2 == 0) {
        player1.draw(deck);
      } else {
        player2.draw(deck);
      }
    }
    
    player1.describe();
    player2.describe();
  }

  private void playWar() {
    int numRounds = player1.getHand().size();
    isReady = false;
    canEnd = false;
    
    System.out.println(dashes + lf);
    for (int round = 1; round <= numRounds; round++) {
      System.out.println("          (Round " + round + ")\n");
      playersFlipCompareAndScore();
      displayScores(round);
      startRoundOrEndGame();
    }

  }

  private void displayScores(int round) {
    int numRounds = player1.getHand().size();
    if (round < numRounds-1) {
      // Prints out the score of each player each round.
      System.out.println("\nScores" + "\n------\n" + player1.getName() + ": " + player1.getScore()
          + lf + player2.getName() + ": " + player2.getScore() + lf + lf + dashes + lf);
    } else {
      // Prints out the final scores on the final round.
      System.out
          .println("\nFinal Scores" + "\n------\n" + player1.getName() + ": " + player1.getScore()
              + lf + player2.getName() + ": " + player2.getScore() + lf + lf + dashes + lf);
    }

  }

  private void startRoundOrEndGame() {
    String userConfirm = ""; // Used to store user input after every round.
    String[] goCheck = {"Go", "go", "gO", "GO"}; // Used to check if userConfirm equals any
                                                 // variation of "go" or "end".
    String[] endCheck = {"End", "ENd", "END", "eND", "enD", "end"};

    if (!canEnd) { // If the user hasn't typed "End", asks the user if they want the next round to
                   // start or want to skip to the results.
      System.out.print("Ready for the next round? Type 'Go'."
          + "\nWant to skip to the results? Type 'End'." + "\nInput: ");
    }

    isReady = false; // Allows the while loop to be ran after each for loop iteration (to pause) IF
                     // the user types "Go", not "End".
    while (!isReady && !canEnd) { // This while loop "pauses" the for loop by prompting the user for
                                  // an input
      userConfirm = sc.nextLine(); // on the previously mentioned questions.
      if (userConfirm.equals(goCheck[0]) || userConfirm.equals(goCheck[1]) || // If the user types
                                                                              // "Go", the isReady
          userConfirm.equals(goCheck[2]) || userConfirm.equals(goCheck[3])) { // boolean will become
                                                                              // true and break the
        System.out.println(lf + dashes + lf); // the while loop.
        isReady = true;
      } else if (userConfirm.equals(endCheck[0]) || userConfirm.equals(endCheck[1]) || // If the
                                                                                       // user types
                                                                                       // "End", the
          userConfirm.equals(endCheck[2]) || userConfirm.equals(endCheck[3]) || // canEnd boolean
                                                                                // will become true
          userConfirm.equals(endCheck[4]) || userConfirm.equals(endCheck[5])) { // and break the
                                                                                // while loop.
        System.out.println(lf + dashes + lf);
        canEnd = true;
      } else { // If the user types anything other than "Go" or "End", this statement will print.
        System.out.print("Type 'Go' or 'End' to proceed: ");
      }
    }
  }
  
  public void playersFlipCompareAndScore() {
    WarCard card1 = player1.flip();
    WarCard card2 = player2.flip();
    System.out.printf("%s's Card: %s" + lf + "%s's Card: %s" + lf, 
        player1.getName(), card1.toString(), player2.getName(), card2.toString());
    if(card1.getValue() > card2.getValue()) {
      player1.incrementScore();
      System.out.println(lf + "***Player 1 has the higher value.***");
    } else if (card2.getValue() > card1.getValue()) {
      player2.incrementScore();
      System.out.println(lf + "***Player 2 has the higher value.***");
    } else {
      System.out.println(lf + "***Draw***");
    }
  }

  private void declareWinner() {
    if (player1.getScore() > player2.getScore()) { // Compares the scores of each player.
      System.out.println(player1.getName() + " won the War!\n\n" + dashes); // Prints out the winner
                                                                            // of the game.
    } else if (player2.getScore() > player1.getScore()) {
      System.out.println(player2.getName() + " won the War!\n\n" + dashes);
    } else {
      System.out.println("The War has resulted in a Draw.\n\n" + dashes);
    }
  }

}
