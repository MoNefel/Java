package JavaOOPAdvanced.Practice.Devices;

public class Phone extends Device{

    public void makeCall(){
        System.out.println("You maked a call.");
        battery -= 5;
        status();
    }

    public void playGame(){
        System.out.println("You played a game.");
        battery -= 20;
        status();
    }

    public void charge(){
        System.out.println("You are charging your phone.");
        battery += 50;
        status();
    }
    
}
