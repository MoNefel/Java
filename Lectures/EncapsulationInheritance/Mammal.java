package Lectures.EncapsulationInheritance;

public class Mammal {
    
    //attributes
    private String name;
    private boolean gotMilk;
    private Integer limbs;

    //constructor
    public Mammal(){}

    public Mammal(String name, boolean gotMilk, Integer limbs){
        this.name = name;
        this.gotMilk = gotMilk;
        this.limbs = limbs;
    }


    //methods
    public String whatAmI(){
        return "I am a mammal";
    }

    //getters and setters
    public String getName(){
        return name;
    }

    public Integer getLimbs(){
        return limbs;
    }

    public boolean getGotMilk(){
        return gotMilk;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGotMilk(boolean bool){
        this.gotMilk = bool;
    }

    public void setLimbs(Integer num){
         this.limbs = num;
    }
}
