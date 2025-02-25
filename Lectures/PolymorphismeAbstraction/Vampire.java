package Lectures.PolymorphismeAbstraction;

// when we implements an interface we must implement all his abstract methods and attributes

public class Vampire extends Monster implements Skills, Hobbies {
    
    private String cloakColor;

    public void whatAmI(){
        System.out.println("I am a Vampire");
    }

    public void catchPhrase(){
        System.out.println("I'm gonna suck your blood ");
    }
}
