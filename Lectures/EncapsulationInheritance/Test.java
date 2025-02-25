package Lectures.EncapsulationInheritance;

// The four Pillars of OOP : 

//=> Encapsulation : everything is encapsulated in objects. It refers to the concept of bundling data (attributes) and methods (behavior) that operate on the data into a single unit (a class) and restricting direct access to some of the object's components.
//This is typically achieved using access modifiers like private, protected, and public.

//=> Inheritance : is a mechanism where one class acquires the properties and behaviors (fields and methods) of another class.

public class Test {
    public static void main(String[] args) {
        Mammal mammalOne = new Mammal();
        mammalOne.whatAmI();
        mammalOne.getName();

        Human humanOne = new Human("med", false, 4);
        System.out.println(humanOne.getGotMilk());
        System.out.println(humanOne.getName());
        System.out.println(humanOne.getLimbs());

        Kangaroo k1 = new Kangaroo();
        System.out.println(k1.whatAmI());
        k1.setTouchType("big pouch");
        System.out.println(k1.getPouchType());
        k1.setName("Kangaroo Jack");
        System.out.println(k1.getName());
    }
    
}
