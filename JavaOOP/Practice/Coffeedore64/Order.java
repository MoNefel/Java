package JavaOOP.Practice.Coffeedore64;

import java.util.ArrayList;

public class Order {
    
    private String name; 
    private boolean ready; 
    private ArrayList<Item> items;

    //constructor
    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

    //Overloaded Constructor
    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }


    //ORDER METHODS
    public void addItem(Item item){
        items.add(item);
    }

    public String getStatusMessage(){
        if(this.ready){
            return "Your order is ready.";
        }else{
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal(){
        double total = 0;
        for(Item item : items){
            total += item.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.println("Customer Name: " + this.name);
        for(Item item : items){
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $"+getOrderTotal());
    }


    //getters
    public String getName(){
        return name;
    }
    
    public boolean getReady(){
        return ready;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
}
