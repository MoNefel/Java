package JavaOOP.Practice.Coffeedore64;

public class Item {

     
    private String name;
    private double price;
    private int index;

    //Constructor
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }

    //getters
    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getIndex(){
        return this.index;
    }

    //Setters
    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setIndex(int idx){
        this.index = idx;
    }
    
}
