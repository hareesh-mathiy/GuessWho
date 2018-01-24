package coe528.FP;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @authors
 */
public class Game {

    private File file;
    private ArrayList<Person> people, gameBoard;
    private Person chosenPerson;
    private int turn = 1;

    public Game() {
        people = new ArrayList<>();
        gameBoard = new ArrayList<>();
        readFile();
        RandomizeGameBoard();
        RandomizePerson();
    }

    public void readFile() {
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
    
    public Person getRandomPerson() {
        Person randomPerson = people.get(new Random().nextInt(people.size()));
        return randomPerson;
    }

    public void RandomizeGameBoard() {
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
        chosenPerson = gameBoard.get(new Random().nextInt(gameBoard.size()));
    }

    public void outputBoard() {
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
        turn += 1;
    }

    public void resetTurn() {
        turn = 1;
    }

    public int getTurn() {
        return turn;
    }

    /**
     * @return the ArrayList of people
     */
    public ArrayList<Person> getPeople() {
        return people;
    }

    /**
     * @return the randomized game board.
     */
    public ArrayList<Person> getGameBoard() {
        return gameBoard;
    }
    
    /**
     * @return the randomized game board.
     */
    public void setGameBoard(ArrayList<Person> temp) {
        gameBoard = temp;
    }

    /**
     * @return the chosen person
     */
    public Person getChosenPerson() {
        return chosenPerson;
    }
}
