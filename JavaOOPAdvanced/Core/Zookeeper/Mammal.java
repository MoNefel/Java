package JavaOOPAdvanced.Core.Zookeeper;

public class Mammal {
    
    //Attribute
    protected int energyLevel;
	
    //Constructor
    public Mammal(int energyLevel) {
		this.energyLevel = energyLevel;
	}

    //Methods
	public int displayEnergy() {
		System.out.println("Energy Level: " + energyLevel);
		return energyLevel;
	}


}
