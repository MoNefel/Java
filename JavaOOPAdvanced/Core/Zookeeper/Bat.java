package JavaOOPAdvanced.Core.Zookeeper;

public class Bat extends Mammal{
    
    public Bat(){
        super(300);
    }

    public void fly(){
        System.out.println("The bat is flying it is a airborne");
        this.energyLevel -= 50;
    }

    public void eatHumans(){
        System.out.println("The bat is satisfaction with human blood");
        this.energyLevel += 25;
    }

    public void attackTown(){
        System.out.println("The town has been attacked by bats");
        this.energyLevel -= 100;
    }
}
