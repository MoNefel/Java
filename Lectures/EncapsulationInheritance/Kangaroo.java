package Lectures.EncapsulationInheritance;

public class Kangaroo extends Mammal {
    
    private String pouchType;
    private boolean canBox;
    private Integer jumpHeight;

    public String getPouchType(){
        return pouchType;
    }

    public void setTouchType(String pt){
        this.pouchType = pt;
    }
}
