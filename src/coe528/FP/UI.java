package coe528.FP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @authors
 */
public class UI {
    
    public static void main(String args[]){
        Game game = new Game();
        ActionMaker am = new ActionMaker(game);
        InputVerification iv = new InputVerification(am);
        Scanner keyboard = new Scanner(System.in);
        String input;
        
        System.out.println("---------------------------------------------------Welcome to Guess Who!---------------------------------------------------");
        
        game.outputBoard();
        
        for(;;){
            System.out.println("");
            System.out.println("Turn: " + game.getTurn());
            System.out.print("Would you like to guess the person? (Y/N): ");
            input = keyboard.next();
            if(iv.verifyYN(input) && (input.equals("Y") || input.equals("y"))) {
                System.out.print("Enter the name of your guess: ");
                input = keyboard.next();
                if(iv.verifyChosenCharacter(input, game.getChosenPerson())){
                    System.out.println("You guessed the correct person in " + game.getTurn() + " turns!");  
                    System.out.println("");
                    System.out.print("Would you like to play again? (Y/N): ");  
                    input = keyboard.next();
                    if(iv.verifyYN(input) && (input.equals("Y") || input.equals("y"))) {
                        game.resetTurn();
                        game.RandomizeGameBoard();
                        game.RandomizePerson();
                        game.outputBoard();     
                    } else if(iv.verifyYN(input) && (input.equals("N") || input.equals("n"))) {   
                        return;
                    }
                } else{       
                    am.removeCharacter(input);
                }
            }
            else if(iv.verifyYN(input) && (input.equals("N") || input.equals("n"))) {
                System.out.println("Make a guess to narrow down the options:");
                System.out.println("Enter gender, haircolor, skincolor, eyecolor, or age to make a guess: ");
                input = keyboard.next();
                iv.verifyGuess(input, keyboard, game);
            }        
        }
    }  
}
