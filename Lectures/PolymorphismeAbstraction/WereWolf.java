package Lectures.PolymorphismeAbstraction;

public class WereWolf extends Monster implements Skills {

    private String furColor;
    private Integer nailLength;
    
    //methods
    public void whatAmI(){
        super.whatAmI(); // => the parents method
        //System.out.println("I am a WreWofl");
    }

    public void howl(){
        System.out.println("awoowooo");
    }

    
    public void catchPhrase() {
        System.out.println("I'm ganna eat you");
    }
}
