package week6;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    try (Scanner sc = new Scanner(System.in)) {
      
      /*
       * Title that prompts the players to enter their names before starting the game.
       */
      
      System.out.println("------------------------------\n\n" + 
                          "Welcome to War, a simple two-player card game.");
      System.out.print("\nPlayer1, please type your name: ");
      String player1Name = sc.nextLine();
      System.out.print("Player2, please type your name: ");
      String player2Name = sc.nextLine();
      System.out.println("\n------------------------------");
      
      /*
       * A new deck and two players (each designated with the names entered earlier) are instantiated.
       */
      
      Deck playDeck = new Deck();
      Player player1 = new Player();
      player1.setName(player1Name);
      Player player2 = new Player();
      player2.setName(player2Name);
      
      /*
       * The deck is shuffled, and each player draws a card until the deck is exhausted.
       */
      
      playDeck.shuffle();
      for(int i = 0; i < 52; i++) {
        if(i % 2 == 0) {
          player1.draw(playDeck);
        } else {
          player2.draw(playDeck);
        }
      }
      
      /*
       * A few variables are declared before the game officially begins.
       */
      
      Card flippedCard1 = new Card();   //Used to store the cards that each player flips.
      Card flippedCard2 = new Card();
      String userConfirm = "";          //Used to store user input after every round.
      String[] goCheck = {"Go", "go", "gO", "GO"};   //Used to check if userConfirm equals any variation of "go" or "end".
      String[] endCheck = {"End", "ENd", "END", "eND", "enD", "end"};
      boolean isReady = false;   //Used to determine whether another round can start.
      boolean canEnd = false;    //Used to determine whether the game can end.
      
      /*
       * This for loop encompasses the entire game. The loop will flip the card on top of each
       * player's hand, print the flipped cards, and compare their values; the card with the higher
       * value will increment the winner's score by one; text will print out who won the round, and
       * the scores of each player will be shown.
       * 
       * After each round, the game will prompt the user for an input that states whether they are
       * ready for the next round or want to skip directly to the results:
       * For the former, the user should type "Go". In this scenario, the loop will iterate once more.
       * For the latter, the user should type "End". In this scenario, the loop will iterate the remaining iterations
       * without prompting the user for another input.
       * On the final round/iteration, the final scores will be printed.
       * 
       * Once the for loop has finished, the final scores will be compared and the winner (the one
       * with the most points) of the game will be stated.
       */
      
      for(int i = 0; i < 26; i++) {
        flippedCard1 = player1.flip();   //Stores the cards that each player flips. Allows the flipped
        flippedCard2 = player2.flip();   //cards to be used throughout the loop.
        
        System.out.println("          (Round " + (i+1) + ")\n");   //Prints out the round.
        System.out.print(player1.getName() + ", ");   //Prints out each player's card.
        flippedCard1.describe();
        System.out.print(player2.getName() + ", ");
        flippedCard2.describe();
        
        if(flippedCard1.getValue() > flippedCard2.getValue()) {   //Compares the values of each card.
          player1.incrementScore();                               //The player with the higher value will have their score incremented by one.
          System.out.println("\n***Player 1 has the higher value.***");   //Prints out the winner of the round.
        } else if (flippedCard2.getValue() > flippedCard1.getValue()){
          player2.incrementScore();
          System.out.println("\n***Player 2 has the higher value.***");
        } else {
          System.out.println("\n***Draw***");
        }
        
        if(i < 25) {   //Prints out the score of each player each round.
          System.out.println("\nScores" + "\n------\n" +
                              player1.getName() + ": " + player1.getScore() + "\n" +
                              player2.getName() + ": " + player2.getScore() +
                              "\n\n------------------------------");
        } else {   //Prints out the final scores on the final round.
          System.out.println("\nFinal Scores" + "\n------\n" +
                              player1.getName() + ": " + player1.getScore() + "\n" +
                              player2.getName() + ": " + player2.getScore() +
                              "\n\n------------------------------");
        }
        
        if(!canEnd) {   //If the user hasn't typed "End", asks the user if they want the next round to start or want to skip to the results.
          System.out.print("\nReady for the next round? Type 'Go'." +
                            "\nWant to skip to the results? Type 'End'." + 
                            "\nInput: ");
        }
        
        isReady = false;   //Allows the while loop to be ran after each for loop iteration (to pause) IF the user types "Go", not "End".
        while(!isReady && !canEnd) {   //This while loop "pauses" the for loop by prompting the user for an input
          userConfirm = sc.nextLine(); //on the previously mentioned questions.
          if(userConfirm.equals(goCheck[0]) || userConfirm.equals(goCheck[1]) ||   //If the user types "Go", the isReady
             userConfirm.equals(goCheck[2]) || userConfirm.equals(goCheck[3])) {   //boolean will become true and break the
            System.out.println("\n------------------------------");              //the while loop.
            isReady = true;
          } else if (userConfirm.equals(endCheck[0]) || userConfirm.equals(endCheck[1]) ||   //If the user types "End", the
                     userConfirm.equals(endCheck[2]) || userConfirm.equals(endCheck[3]) ||   //canEnd boolean will become true
                     userConfirm.equals(endCheck[4]) || userConfirm.equals(endCheck[5])) {   //and break the while loop.
            System.out.println("\n------------------------------");
            canEnd = true;
          } else {   //If the user types anything other than "Go" or "End", this statement will print.
            System.out.print("Type 'Go' or 'End' to proceed: ");
          }
        }
      }
      
      if(player1.getScore() > player2.getScore()) {   //Compares the scores of each player.
        System.err.println("\n" + player1.getName() + " won the War!\n");   //Prints out the winner of the game.
        System.out.println("------------------------------");
      } else if(player2.getScore() > player1.getScore()) {
        System.err.println("\n" + player2.getName() + " won the War!\n");
        System.out.println("------------------------------");
      } else {
        System.err.println("The War has resulted in a Draw.\n");
        System.out.println("------------------------------");
      }
    }
  }

}
