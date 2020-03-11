import java.util.Random;
import java.util.Scanner;

/**
* The RockPaperScissors program implements an application that allows you to
* play rock, paper, scissors against a computer.
*
* @author  Bradley Wills
* @version 1.0
* @since   2020-03-10
*/

public class RockPaperScissors {
  // Create variables 
  static int randInt;
  static int userInt;
  static int winCount;
  static int gameCount;
  
  /**
   * Plays Rock Paper Scissors.
   */
  public static void main(String[] args) {
    // Create some variables
    boolean finished = false;
    boolean finished2 = false;
    String randInput = "";
    Random randomizer = new Random();
    Scanner inputAccepter = new Scanner(System.in);
    
    // Begin rock paper scissors
    while (finished == false) {
      System.out.println("Input rock, paper, or scissors.");
      // Generate random value 1-3
      randInt = (randomizer.nextInt(3)) + 1;
      // Declare the string name of the computers choice
      if (randInt == 1) {
        randInput = "rock";
      } else if (randInt == 2) {
        randInput = "paper";
      } else if (randInt == 3) {
        randInput = "scissors";
      }
      // Accept input
      String userInput = inputAccepter.nextLine();
      // Convert input to lowercase so that capital letters don't matter
      userInput = userInput.toLowerCase();
      // Check if input is valid
      if ((userInput.equals("rock")) || (userInput.equals("paper")) 
          || (userInput.equals("scissors"))) {
        // Declare the int value of the user choice
        if (userInput.equals("rock")) {
          userInt = 1;
        } else if (userInput.equals("paper")) {
          userInt = 2;
        } else if (userInput.equals("scissors")) {
          userInt = 3;
        }
        if (userInt == randInt) {
          // You Tie
          gameCount += 1;
          System.out.println("You tied. The enemy also chose " + randInput + ".");
        } else if ((randInt == userInt + 1) || (randInt == userInt - 2)) {
          // You Lose
          gameCount += 1;
          System.out.println("You lost. You chose " + userInput + " and the enemy chose "
              + randInput + ".");
        } else {
          // You Win
          gameCount += 1;
          winCount += 1;
          System.out.println("You won. You chose " + userInput + " and the enemy chose "
              + randInput + ".");
        }
      } else {
        System.out.println("Invalid Input.");
      }
      // Prompt the user
      System.out.println("Do you want to keep playing?");
      finished2 = false;
      while (finished2 == false) {
        System.out.println("Input yes or no.");
        String yesOrNoInput = inputAccepter.nextLine();
        // Convert input to lowercase so that capital letters don't matter
        yesOrNoInput = yesOrNoInput.toLowerCase();
        if (yesOrNoInput.equals("no")) {
          finished = true;
          finished2 = true;
          if (!(gameCount == 0)) {
            double winPercentage = Double.valueOf(winCount) / Double.valueOf(gameCount) * 100;
            System.out.println("Your win percentage was " 
                + winPercentage + "%.");
          }
        } else if (!yesOrNoInput.equals("yes")) {
          System.out.println("Invalid Input.");
        } else {
          finished2 = true;
        }
      }
    }
  }
}