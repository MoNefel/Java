package Lectures.PolymorphismeAbstraction;

public interface Skills {
    
    abstract void whatAmI();

    abstract void catchPhrase();

    public default void monsterMash(){
        System.out.println("It was a monster mash !!");
    }
}
