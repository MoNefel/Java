package Lectures.PolymorphismeAbstraction;

public class Monster {
    
    //attributes
    private String name;
    private Integer fearFactor;
    private String bestMovie;
    private boolean undead;


    //methods
    public void whatAmI(){
        System.out.println("I'am a monster!!");
    }

    //constructor
    public Monster(){}

    //getters
    public String getName(){
        return name;
    }

    public Integer getFearFactor(){
        return fearFactor;
    }

    public String getBestMovie(){
        return bestMovie;
    }

    public boolean getUndead(){
        return undead;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }

    public void setFearFactor(Integer rating){
        this.fearFactor = rating;
    }

    public void setBestMovie(String bestMovie){
        this.bestMovie = bestMovie;
    }

    public void setUndead(boolean undead){
        this.undead = undead;
    }
}
