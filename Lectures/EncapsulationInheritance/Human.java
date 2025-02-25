package Lectures.EncapsulationInheritance;

//extends mean inheriting, so the class Human inheritate the attributes and methods from the Mammal Class.
public class Human extends Mammal {
    
    private String hobby;
    private boolean playVideo;

    public Human(){}

    public Human(String name, boolean gotMilk, Integer limbs){
        super(name, gotMilk, limbs);
    }

}
