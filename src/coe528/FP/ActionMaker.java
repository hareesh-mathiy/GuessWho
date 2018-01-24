package coe528.FP;

import java.util.ArrayList;

/**
 *
 * @author
 */
public class ActionMaker {
    //OVERVIEW: Holds the methods that make actions based on the guesses the user
    //          makes, including updating the gameboard and incrementing the turn.
    
    Game game;
    
    public ActionMaker(Game game){
        //EFFECTS: constructor which initializes instance variables.
        this.game = game;
    }
    
    public void removeCharacter(String name){
        //EFFECTS: outputs that the guess is wrong.
        //
        //         Updates the game board, and removes the option with the same
        //         name as the guess given in String input 'name' if a person
        //         with the name exists.
        //
        //         Increments the turn number.
        ArrayList<Person> temp = new ArrayList<>();
        System.out.println("Your guess is wrong."); 
        for(Person p : game.getGameBoard()){
            if (!p.getName().equals(name)) {
                temp.add(p);
            }
        }
        if(temp.size() < game.getGameBoard().size()){
            game.setGameBoard(temp);
            game.outputBoard();
        }
        game.incrementTurn();
    }
    
    public void makeGuessGender() {
        //EFFECTS: outputs the gender of the chosen person since gender is a  
        //         binary option (male or female).
        //
        //         Updates the game board, and removes the options that are 
        //         of the other gender.
        //
        //         Increments the turn number.
        ArrayList<Person> temp = new ArrayList<>();
        System.out.println("The person is a " + game.getChosenPerson().getGender() + ".");
        for (Person p : game.getGameBoard()) {
            if (p.getGender().equals(game.getChosenPerson().getGender())) {
                temp.add(p);
            }
        }
        game.setGameBoard(temp);
        game.outputBoard();
        game.incrementTurn();
    }

    public void makeGuessHairColor(String guess) {
        //EFFECTS: outputs whether or not the chosen person has the hair color  
        //         given by the String input 'guess'.
        //
        //         Updates the game board, if the chosen person has the same
        //         color as the guess, removes all options without the guessed 
        //         color, and if the chosen person does not have the same color 
        //         as the guess, removes all options with the guessed color.
        //
        //         Increments the turn number.
        ArrayList<Person> temp = new ArrayList<>();
        switch (guess) {
            case "black":
                if(guess.equals(game.getChosenPerson().getHairColor())){
                    System.out.println("The person has black hair.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getHairColor().equals("black")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have black hair.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getHairColor().equals("black")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            case "brown":
                if(guess.equals(game.getChosenPerson().getHairColor())){
                    System.out.println("The person has brown hair.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getHairColor().equals("brown")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have brown hair.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getHairColor().equals("brown")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            case "white":
                if(guess.equals(game.getChosenPerson().getHairColor())){
                    System.out.println("The person has white hair.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getHairColor().equals("white")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have white hair.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getHairColor().equals("white")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            case "blonde":
                if(guess.equals(game.getChosenPerson().getHairColor())){
                    System.out.println("The person has blonde hair.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getHairColor().equals("blonde")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have blonde hair.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getHairColor().equals("blonde")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            case "red":
                if(guess.equals(game.getChosenPerson().getHairColor())){
                    System.out.println("The person has red hair.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getHairColor().equals("red")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have red hair.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getHairColor().equals("red")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            default:
                break;
        }
    }
    
    public void makeGuessSkinColor(String guess) {
        //EFFECTS: outputs whether or not the chosen person has the skin color  
        //         given by the String input 'guess'.
        //
        //         Updates the game board, if the chosen person has the same
        //         color as the guess, removes all options without the guessed 
        //         color, and if the chosen person does not have the same color 
        //         as the guess, removes all options with the guessed color.
        //
        //         Increments the turn number.
        ArrayList<Person> temp = new ArrayList<>();
        switch (guess) {
            case "black":
                if(guess.equals(game.getChosenPerson().getSkinColor())){
                    System.out.println("The person has black skin.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getSkinColor().equals("black")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have black skin.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getSkinColor().equals("black")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            case "brown":
                if(guess.equals(game.getChosenPerson().getSkinColor())){
                    System.out.println("The person has brown skin.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getSkinColor().equals("brown")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have brown skin.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getSkinColor().equals("brown")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            case "white":
                if(guess.equals(game.getChosenPerson().getSkinColor())){
                    System.out.println("The person has white skin.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getSkinColor().equals("white")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have white skin.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getSkinColor().equals("white")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            case "yellow":
                if(guess.equals(game.getChosenPerson().getSkinColor())){
                    System.out.println("The person has yellow skin.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getSkinColor().equals("yellow")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have yellow skin.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getSkinColor().equals("yellow")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            default:
                break;  
        }
    }
    
    public void makeGuessEyeColor(String guess) {
        //EFFECTS: outputs whether or not the chosen person has the eye color  
        //         given by the String input 'guess'.
        //
        //         Updates the game board, if the chosen person has the same
        //         color as the guess, removes all options without the guessed 
        //         color, and if the chosen person does not have the same color 
        //         as the guess, removes all options with the guessed color.
        //
        //         Increments the turn number.
        ArrayList<Person> temp = new ArrayList<>();
        switch (guess) {
            case "black":
                if(guess.equals(game.getChosenPerson().getEyeColor())){
                    System.out.println("The person has black eyes.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getEyeColor().equals("black")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have black eyes.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getEyeColor().equals("black")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            case "green":
                if(guess.equals(game.getChosenPerson().getEyeColor())){
                    System.out.println("The person has green eyes.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getEyeColor().equals("green")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have green eyes.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getEyeColor().equals("green")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            case "blue":
                if(guess.equals(game.getChosenPerson().getEyeColor())){
                    System.out.println("The person has blue eyes.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getEyeColor().equals("blue")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have blue eyes.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getEyeColor().equals("blue")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            case "brown":
                if(guess.equals(game.getChosenPerson().getEyeColor())){
                    System.out.println("The person has brown eyes.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getEyeColor().equals("brown")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person does not have brown eyes.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getEyeColor().equals("brown")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            default:
                break;  
        }
    }
    
    public void makeGuessAge(String guess) {
        //EFFECTS: outputs whether or not the chosen person has the age  
        //         given by the String input 'guess'.
        //
        //         Updates the game board, if the chosen person has the same
        //         age as the guess, removes all options without the guessed 
        //         age, and if the chosen person does not have the same age 
        //         as the guess, removes all options with the guessed age.
        //
        //         Increments the turn number.
        ArrayList<Person> temp = new ArrayList<>();
        switch (guess) {
            case "child":
                if(guess.equals(game.getChosenPerson().getAge())){
                    System.out.println("The person is a child.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getAge().equals("child")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person is not a child.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getAge().equals("child")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            case "adult":
                if(guess.equals(game.getChosenPerson().getAge())){
                    System.out.println("The person is an adult.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getAge().equals("adult")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person is not an adult.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getAge().equals("adult")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            case "senior":
                if(guess.equals(game.getChosenPerson().getAge())){
                    System.out.println("The person is a senior.");
                    for (Person p : game.getGameBoard()) {
                        if (p.getAge().equals("senior")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                } else{
                    System.out.println("The person is not a senior.");
                    for (Person p : game.getGameBoard()) {
                        if (!p.getAge().equals("senior")) {
                            temp.add(p);
                        }
                    }
                    game.setGameBoard(temp);
                    game.outputBoard();
                    game.incrementTurn();
                }   break;
            default:
                break;  
        }
    }
}
