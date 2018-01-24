package coe528.FP;

/**
 *
 * @author Hareesh Mathiyalagan, David Nguyen, Laksan Sukumar
 */
public class Person {                              
    /*OVERVIEW: Creates the Person object given the name, gender, hair color,
                skin color, eye color and age.all variables are mutable strings
                all string can only have specific answers which form the person class.
                This class is mutable.

      Abstract Function
      AF(c) = {c.gender.string | gender == "male" || "female"}
            = {c.hairColor.string | hairColour == "black" || "red" || "white" || "blonde" ||"brown"}
            = {c.skinColor.string | skinColor == "black" || "brown"||  "white" || "yellow"}
            = {c.eyeColor.string | eyeColor == "black" || "green"|| "blue" || "brown"}
            = {c.age.string | age == "child" || "adult"|| "senior"}
   
      Representation Invariant
      c.name && c.gender && c.hairColour && c.skinColour && c.eyeColour && c.age && is a String
    */
    
    private String name, gender, hairColor, skinColor, eyeColor, age;

    public Person(String name, String gender, String hairColor, String skinColor,
            String eyeColor, String age) {
        //EFFECTS: constructor which initializes instance variables.
        this.name = name;
        this.gender = gender;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.age = age;
    }

    public String getName() {
        //EFFECTS: Returns the name of the person
        return name;
    }

    public String getGender() {
        //EFFECTS: Returns the gender of the person
        return gender;
    }

    public String getHairColor() {
        //EFFECTS: Returns the hair color of the person
        return hairColor;
    }

    public String getSkinColor() {
        //EFFECTS: Returns the skin color of the person
        return skinColor;
    }

    public String getEyeColor() {
        //EFFECTS: Returns the eye color of the person
        return eyeColor;
    }

    public String getAge() {
        //EFFECTS: Returns the age of the person
        return age;
    }
 
    public boolean repOK() {
        Object a = this.name;
        Object b = this.gender;
        Object c = this.hairColor;
        Object d = this.skinColor;
        Object e = this.eyeColor;
        Object f = this.age;

        if (!(a instanceof String) || !(b instanceof String) || !(c instanceof String) || !(d instanceof String) || !(e instanceof String) || !(f instanceof String)) {
            return false;
        }
        else return true;
    }

    @Override
    public String toString() {
        String a,b,c,d,e;
        
        if (this.gender == "male") a = "male";
        else a = "female";

        if (this.hairColor == "black")  b = "black";
        else if (this.hairColor == "brown") b = "brown";
        else if (this.hairColor == "red") b = "red";
        else if (this.hairColor == "white") b = "white";
        else b = "blonde";

        if (this.skinColor == "black") c = "black";
        else if (this.skinColor == "brown") c = "brown";
        else if (this.skinColor == "white") c = "white";
        else c = "yellow";

        if (this.eyeColor == "black") d = "black";
        else if (this.eyeColor == "green") d = "green";
        else if (this.eyeColor == "blue") d = "blue";
        else d = "brown";

        if (this.age == "child")  e = "child";
        else if (this.age == "adult") e = "adult";
        else e = "senior";
        
        return a + " | " + b + " | " +  c + " | " +  d + " | " +  e;
    }
}
