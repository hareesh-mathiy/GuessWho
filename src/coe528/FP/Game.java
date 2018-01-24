package coe528.FP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Hareesh Mathiyalagan, David Nguyen, Laksan Sukumar
 */
public class Game {
    /*OVERVIEW: Handles all logic related to the game board, involving reading the 
                people into an array list from a file, randomizing the game board
                and chosen person for each game, and managing the turn counter.
                This class is mutable.
     
      Abstract Function
      AF(c) = {c.turn.intValue | turn >= 1}
    
      Representation Invariant
      c.turn is an Integer      
    */
    
    private File file;
    private ArrayList<Person> people, gameBoard;
    private Person chosenPerson;
    private int turn = 1;
    private ArrayList<Integer> highscores;

    public Game() {
        //EFFECTS: constructor which initializes instance variables and calls
        //         readFile() to populate the ArrayList<Person>, randomizes the 
        //         game board and choses a random chosen person for the first game.
        people = new ArrayList<>();
        gameBoard = new ArrayList<>();
        highscores = new ArrayList<>();
        readFile();
        readFileHighScores();
        RandomizeGameBoard();
        RandomizePerson();
    }

    public void readFile() {
        //EFFECTS: reads the file and populates ArrayList<Person> people with 
        //         everyone in the file.
        BufferedReader reader = null;
        try {
            file = new File("data-DO_NOT_MODIFY.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String delims = "[|]";
                String[] tokens = line.split(delims);
                people.add(new Person(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

     public void readFileHighScores() {
        //EFFECTS: reads the file and populates ArrayList<Integer> highscores 
        //         with all the scores in the file.
        BufferedReader reader = null;
        try {
            file = new File("highscores-DO_NOT_MODIFY.txt");
            if (!file.exists()) {        
                file.createNewFile();
            }
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String delims = "[|]";
                String[] tokens = line.split(delims);
                highscores.add(Integer.parseInt(tokens[0]));
                highscores.add(Integer.parseInt(tokens[1]));
                highscores.add(Integer.parseInt(tokens[2]));
                highscores.add(Integer.parseInt(tokens[3]));
                highscores.add(Integer.parseInt(tokens[4]));
                highscores.add(Integer.parseInt(tokens[5]));
                highscores.add(Integer.parseInt(tokens[6]));
                highscores.add(Integer.parseInt(tokens[7]));
                highscores.add(Integer.parseInt(tokens[8]));
                highscores.add(Integer.parseInt(tokens[9]));
            }       
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
     
    public void writeFileHighScores(){
        //EFFECTS: overwrites the file with the integer scores from 
        //         ArrayList<Integer> highscores. 
        try {
            file = new File("highscores-DO_NOT_MODIFY.txt");
            if (file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write( highscores.get(0) + "|" + highscores.get(1) + "|"
                    + highscores.get(2) + "|" + highscores.get(3) + "|"
                    + highscores.get(4) + "|" + highscores.get(5) + "|"
                    + highscores.get(6) + "|" + highscores.get(7) + "|"
                    + highscores.get(8) + "|" + highscores.get(9));  
            bw.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }   
    }
    
    public Person getRandomPerson() {
        //EFFECTS: returns a random person from ArrayList<Person> people. 
        Person randomPerson = people.get(new Random().nextInt(people.size()));
        return randomPerson;
    }

    public void RandomizeGameBoard() {
        //EFFECTS: randomizes the game board using people from the ArrayList<Person>
        //         people such that the board has 10 unique people.
        //MODIFIES: ArrayList<Person> gameBoard
        boolean exists = false;
        Person randomPerson = getRandomPerson();
        gameBoard.add(randomPerson);
        while (gameBoard.size() < 10) {
            randomPerson = getRandomPerson();
            for (Person p : gameBoard) {
                if (p.getName().equals(randomPerson.getName())) {
                    exists = true;
                }
            }
            if (!exists) {
                gameBoard.add(randomPerson);
            }
            exists = false;
        }
    }

    public void RandomizePerson() {
        //EFFECTS: randomizes the chosen person for the current game board.
        //MODIFIES: Person chosenPerson
        chosenPerson = gameBoard.get(new Random().nextInt(gameBoard.size()));
    }

    public void outputBoard() {
        //EFFECTS: prints the current formatted game board to console.
        System.out.println("");
        System.out.println("Your Board:");
        System.out.println("");
        System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s", "Name", "Gender", "Hair Color",
                "Skin Color", "Eye Color", "Age");
        System.out.println("");
        for (Person p : gameBoard) {
            System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s", p.getName(), p.getGender(), p.getHairColor(),
                    p.getSkinColor(), p.getEyeColor(), p.getAge());
            System.out.println("");
        }
        System.out.println("");
    }

    public void incrementTurn() {
        //EFFECTS: increments the turn number
        //MODIFIES: int turn
        turn += 1;
    }

    public void resetTurn() {
        //EFFECTS: resets the turn number
        //MODIFIES: int turn
        turn = 1;
    }

    public int getTurn() {
        //EFFECTS: returns the turn number
        return turn;
    }

    public ArrayList<Person> getPeople() {
        //EFFECTS: returns the ArrayList of people from the file.
        return people;
    }

    public ArrayList<Person> getGameBoard() {
        //EFFECTS: returns the ArrayList of people from the current game board.
        return gameBoard;
    }

    public void setGameBoard(ArrayList<Person> temp) {
        //EFFECTS: sets the current game board to temp.
        //MODIFIES: ArrayList<Person> gameBoard
        gameBoard = temp;
    }

    public Person getChosenPerson() {
        //EFFECTS: returns the chosen person from the current game board.
        return chosenPerson;
    }
    
    public void addHighScore(int turns){
        //EFFECTS: checks if the score is eligible to be a highscore, if it is 
        //         then add it to ArrayList<Integer> highscores.
        //MODIFIES: ArrayList<Person> highscores
        for(Integer i : highscores){
            if(turns <= i){
                highscores.add(turns);
                break;
            }
        }
        Collections.sort(highscores);
        int i = highscores.size()-1;
        highscores.remove(i);
        writeFileHighScores();
    }
    
    public void outputHighScores(){
        //EFFECTS: prints all the current highscores.
        for(Integer i : highscores){
            System.out.println(i);
        }
    }

    public boolean repOK() {
        Object x = this.turn;

        if (!(x instanceof Integer)) return false;
        else return true;
    }

    @Override
    public String toString() {
        String s;

        if (this.turn >= 0) s = "true";
        else s = "false";

        return s;
    }
}
