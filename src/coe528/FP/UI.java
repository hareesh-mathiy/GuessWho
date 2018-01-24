package coe528.FP;

import java.util.Scanner;

/**
 *
 * @author Hareesh Mathiyalagan, David Nguyen, Laksan Sukumar
 */
public class UI {

    /*OVERVIEW: holds the main method of the project and serves as the user 
                interface of the game. Presents the data to the user and gives
                them options, and calls the other classes based on these options.
    
      Abstract Function
      AF(c) = {c.args.length == 0}
          
      Representation Invariant
      c.args is an array of Strings.
     */
    private static String args[];

    public static void main(String args[]) {
        //EFFECTS: Presents the data to the user and gives
        //         them options, and calls the other classes based on these options.
        Game game = new Game();
        ActionMaker am = new ActionMaker(game);
        InputVerification iv = new InputVerification(am);
        Scanner keyboard = new Scanner(System.in);
        UI.args = args;
        String input;

        System.out.println("---------------------------------------------------Welcome to Guess Who!---------------------------------------------------");
        System.out.println("");
        
        for (;;) {
            System.out.print("Enter P to play, enter H to check highscores, E to exit: ");
            input = keyboard.next();
            if (iv.verifyHPE(input) && (input.equals("h") || input.equals("H"))) {
                System.out.println("");
                System.out.println("The current top 10 highscores are:");
                game.outputHighScores();
                System.out.println("");
            } else if (iv.verifyHPE(input) && (input.equals("p") || input.equals("P"))) {
                game.outputBoard();
                for (;;) {     
                    System.out.println("");
                    System.out.println("Turn: " + game.getTurn());
                    System.out.print("Would you like to guess the person? (Y/N): ");
                    input = keyboard.next();
                    if (iv.verifyYN(input) && (input.equals("Y") || input.equals("y"))) {
                        System.out.print("Enter the name of your guess: ");
                        input = keyboard.next();
                        if (iv.verifyChosenCharacter(input, game.getChosenPerson())) {
                            game.addHighScore(game.getTurn());
                            System.out.println("You guessed the correct person in " + game.getTurn() + " turns!");
                            System.out.println("");
                            System.out.print("Would you like to play again? (Y/N): ");
                            input = keyboard.next();
                            if (iv.verifyYN(input) && (input.equals("Y") || input.equals("y"))) {
                                game.resetTurn();
                                game.RandomizeGameBoard();
                                game.RandomizePerson();
                                game.outputBoard();
                            } else if (iv.verifyYN(input) && (input.equals("N") || input.equals("n"))) {
                                break;
                            }
                        } else {
                            am.removeCharacter(input);
                        }
                    } else if (iv.verifyYN(input) && (input.equals("N") || input.equals("n"))) {
                        System.out.println("Make a guess to narrow down the options:");
                        System.out.println("Enter gender, haircolor, skincolor, eyecolor, or age to make a guess: ");
                        input = keyboard.next();
                        iv.verifyGuess(input, keyboard, game);
                    }
                }
            }  else if (iv.verifyHPE(input) && (input.equals("e") || input.equals("E"))) {
                return;
            }
        }
    }

    public boolean repOK() {
        Object a = args;

        if (args.length == 0) {
            if (!(a instanceof String)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < args.length; i++) {
            s = s + args;
        }
        return s;
    }
}
