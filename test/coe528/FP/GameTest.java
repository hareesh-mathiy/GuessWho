/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.FP;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hareesh
 */
public class GameTest {
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of readFile method, of class Game.
     */
    @Test
    public void testReadFile() {
        System.out.println("readFile");
        Game instance = new Game();
        boolean expResult = true;
        boolean result = false;
        if(instance.getPeople().size() > 0) result = true;
        else result = false;
        assertEquals(result, expResult);
    }

    /**
     * Test of getRandomPerson method, of class Game.
     */
    @Test
    public void testGetRandomPerson() {
        System.out.println("getRandomPerson");
        Game instance = new Game();
        Person expResult = instance.getRandomPerson();
        Person temp = new Person("","","","","","");
        for(Person p : instance.getPeople()){
            if(p == expResult){
                temp = p;
            }
        }
        assertEquals(temp, expResult);
    }

    /**
     * Test of RandomizeGameBoard method, of class Game.
     */
    @Test
    public void testRandomizeGameBoard() {
        System.out.println("RandomizeGameBoard");
        Game instance = new Game();
        ArrayList<Person> GB = instance.getPeople();
        instance.RandomizeGameBoard();
        ArrayList<Person> randomGB = instance.getGameBoard();
        assertNotEquals(GB, randomGB);
    }

    /**
     * Test of RandomizePerson method, of class Game.
     */
    @Test
    public void testRandomizePerson() {
        System.out.println("RandomizePerson");
        Game instance = new Game();
        Person p = instance.getChosenPerson();
        instance.RandomizePerson();
        Person randomP = instance.getChosenPerson();
        assertNotEquals(p, randomP);
    }

    /**
     * Test of getTurn method, of class Game.
     */
    @Test
    public void testGetTurn() {
        System.out.println("getTurn");
        Game instance = new Game();
        int expResult = 1;
        int result = instance.getTurn();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of incrementTurn method, of class Game.
     */
    @Test
    public void testIncrementTurn() {
        System.out.println("incrementTurn");
        Game instance = new Game();
        int expResult = 2;
        instance.incrementTurn();
        assertEquals(expResult, instance.getTurn());
    }
    
    /**
     * Test of resetTurn method, of class Game.
     */
    @Test
    public void testResetTurn() {
        System.out.println("resetTurn");
        Game instance = new Game();
        instance.incrementTurn();
        instance.incrementTurn();
        int expResult = 1;
        instance.resetTurn();
        assertEquals(expResult, instance.getTurn());
    }

    /**
     * Test of getGameBoard method, of class Game.
     */
    @Test
    public void testGetGameBoard() {
        System.out.println("getGameBoard");
        Game instance = new Game();
        ArrayList<Person> newGameBoard = new ArrayList<>();
        newGameBoard.add(new Person("a", "b", "c", "d", "e", "f"));
        newGameBoard.add(new Person("g", "h", "i", "j", "k", "l"));
        instance.setGameBoard(newGameBoard);
        ArrayList<Person> expResult = newGameBoard;
        ArrayList<Person> result = instance.getGameBoard();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGameBoard method, of class Game.
     */
    @Test
    public void testSetGameBoard() {
        System.out.println("setGameBoard");
        ArrayList<Person> newGameBoard = new ArrayList<>();
        newGameBoard.add(new Person("a", "b", "c", "d", "e", "f"));
        newGameBoard.add(new Person("g", "h", "i", "j", "k", "l"));
        Game instance = new Game();
        instance.setGameBoard(newGameBoard);
        assertEquals(newGameBoard, instance.getGameBoard());
    }

    /**
     * Test of getChosenPerson method, of class Game.
     */
    @Test
    public void testGetChosenPerson() {
        System.out.println("getChosenPerson");
        Game instance = new Game();
        Person temp = new Person("", "", "", "", "", "");
        for(Person p : instance.getGameBoard()){
            if(p == instance.getChosenPerson()){
                temp = p;
            }
        }
        assertEquals(temp, instance.getChosenPerson());       
    }
    
}
