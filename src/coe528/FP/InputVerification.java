package coe528.FP;

import java.util.Scanner;

/**
 *
 * @author
 */
public class InputVerification {
    ActionMaker am;
    
    public InputVerification(ActionMaker am){
        this.am = am;
    }
    
    /**
     * Determine if the input is a valid char.
     *
     * @param input
     * @return a boolean of whether the input is valid or not.
     */
    public boolean verifyYN(String input) {
        if (input.length() == 1) {
            if (Character.isLetter(input.charAt(0))) {
                if(input.equals("y") || input.equals("Y") || input.equals("n") || input.equals("N")){
                    return true;
                } else{
                    System.out.println("Error: invalid input, enter Y or N.");   
                    return false;
                }
            } else {
                System.out.println("Error: invalid input, enter Y or N.");
                return false;
            }
        } else {
            System.out.println("Error: invalid input, enter Y or N.");
            return false;
        }
    }
    
    /**
     * Determine if the input is the correct character.
     *
     * @param input
     * @return a boolean of whether the input character is correct or not.
     */
    public boolean verifyChosenCharacter(String input, Person chosenPerson) {
        return input.equals(chosenPerson.getName());
    }
    
    /**
     * Determine if the input is a valid guess.
     *
     * @param input
     * @return a boolean of whether the guess is valid or not.
     */
    public boolean verifyGuess(String input, Scanner keyboard, Game game) {
        if(input.equals("gender")){
            am.makeGuessGender();
            return true;
        } else if(input.equals("haircolor")){
            System.out.print("Guess black, white, brown, blonde, red: ");
            input = keyboard.next();
            if(input.equals("black") || input.equals("white") || input.equals("brown") || input.equals("blonde") || input.equals("red")){  
                am.makeGuessHairColor(input);
                return true;
            } else{
                System.out.println("Error: invalid input, enter one of the options above.");
                return false;
            }
        } else if(input.equals("skincolor")){
            System.out.print("Guess white, black, brown, or yellow: ");
            input = keyboard.next();
            if(input.equals("white") || input.equals("black") || input.equals("brown") || input.equals("yellow")){   
                am.makeGuessSkinColor(input);
                return true;
            } else{
                System.out.println("Error: invalid input, enter one of the options above.");
                return false;
            }
        } else if(input.equals("eyecolor")){
            System.out.print("Guess black, green, blue, or brown: ");
            input = keyboard.next();
            if(input.equals("black") || input.equals("green") || input.equals("blue") || input.equals("brown")){   
                am.makeGuessEyeColor(input);
                return true;
            } else{
                System.out.println("Error: invalid input, enter one of the options above.");
                return false;
            }
        } else if(input.equals("age")){
            System.out.print("Guess child, adult, or senior: ");
            input = keyboard.next();
            if(input.equals("child") || input.equals("adult") || input.equals("senior")){
                am.makeGuessAge(input);
                return true;
            } else{
                System.out.println("Error: invalid input, enter one of the options above.");
                return false;
            }
        } else {
            System.out.println("Error: invalid input, enter one of the options above.");
            return false;
        }
    }
}
