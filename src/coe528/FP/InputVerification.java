package coe528.FP;

import java.util.Scanner;

/**
 *
 * @author Hareesh Mathiyalagan, David Nguyen, Laksan Sukumar
 */
public class InputVerification {
    /*OVERVIEW: Verifies whether input is of valid form or not and passes 
                guesses to the ActionMaker if they are valid. This class is 
                immutable.
    
      Abstract Function
      AF(c) = There are only functions in this class
          
      Representation Invariant
      c.am is an ActionMaker object.

    */
    
    ActionMaker am;
    
    public InputVerification(ActionMaker am){
        //EFFECTS: constructor which initializes instance variables.
        this.am = am;
    }
    
    public boolean verifyYN(String input) {
        //EFFECTS: Determine if the input is a valid char, return a boolean of 
        //         whether the input is valid or not.
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
    
    public static boolean verifyHPE(String input) {
        //EFFECTS: Determine if the input is a valid char, return a boolean of 
        //         whether the input is valid or not.
        if (input.length() == 1) {
            if (Character.isLetter(input.charAt(0))) {
                if(input.equals("h") || input.equals("H") || input.equals("p") || input.equals("P") 
                        || input.equals("e") || input.equals("E")){
                    return true;
                } else{
                    System.out.println("Error: invalid input, enter H, P or E.");   
                    return false;
                }
            } else {
                System.out.println("Error: invalid input, enter H, P or E.");  
                return false;
            }
        } else {
            System.out.println("Error: invalid input, enter H, P or E.");  
            return false;
        }
    }
    
    public boolean verifyChosenCharacter(String input, Person chosenPerson) {
        //EFFECTS: Determine if the input is the correct character, return a 
        //         boolean of whether the input character is correct or not.
        return input.equals(chosenPerson.getName());
    }
    
    public boolean verifyGuess(String input, Scanner keyboard, Game game) {
        //EFFECTS: Determine if the input is a valid guess, return a boolean of 
        //         whether the guess is valid or not. If it is a valid guess then
        //         pass the input to the ActionMaker am to make an action.
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
    
    public boolean repOK()
    {
        Object a = this.am;
       
        if(!(a instanceof ActionMaker)) return false;
        else return true;
    }
    
    @Override
    public String toString(){
        return am.toString();
    }
}