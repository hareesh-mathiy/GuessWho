package coe528.FP;

/**
 *
 * @author 
 */
public class Person {
    //OVERVIEW: Creates the Person object given the name, gender, hair color,
    //          skin color, eye color and age.
    
    private String name, gender, hairColor, skinColor, eyeColor, age;
    
    public Person(String name, String gender, String hairColor, String skinColor,
            String eyeColor, String age){
        //EFFECTS: constructor which initializes instance variables.
        this.name = name;
        this.gender = gender;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.age = age;
    }

    /**
     * @return the name of the person
     */
    public String getName() {
        //EFFECTS: Returns the name of the person
        return name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
         //EFFECTS: Returns the gender of the person
        return gender;
    }

    /**
     * @return the hairColor
     */
    public String getHairColor() {
         //EFFECTS: Returns the hair color of the person
        return hairColor;
    }
    
    /**
     * @return the skinColor
     */
    public String getSkinColor() {
         //EFFECTS: Returns the skin color of the person
        return skinColor;
    }

    /**
     * @return the eyeColor
     */
    public String getEyeColor() {
        //EFFECTS: Returns the eye color of the person
        return eyeColor;
    }

    /**
     * @return the age
     */
    public String getAge() {
         //EFFECTS: Returns the age of the person
        return age;
    }
    
}
