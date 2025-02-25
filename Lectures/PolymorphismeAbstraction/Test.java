package Lectures.PolymorphismeAbstraction;

//=> Polymorphisme : It refers to the ability of objects to take on multiple forms or behaviors depending on the context.
//=> Abstraction : It refers to the concept of hiding the complex implementation details and showing only the essential features of an object.
//It allows you to focus on what an object does rather than how it does it.
public class Test {
    public static void main(String[] args) {
        WereWolf wolfOne = new WereWolf();
        wolfOne.whatAmI();
        wolfOne.monsterMash();
        wolfOne.catchPhrase();

        Vampire dracula = new Vampire();
        dracula.catchPhrase();
        dracula.monsterMash();
        System.out.println(dracula.hobby);
    }
}



//Conclusion :
/* => Encapsulation : storing data in objects,
--> access modifiers, making member variables privates;
using getter and setter

=> Inheritance : classes can extend or inherit attributes and methods from a parent class.
helps us to keep code DRY

=> Polymorphisme : parent and child can have versions of the same method.

=> Abstraction : Interfaces allow us to give a specific structure and set of guidelines that a class must follow.
 if it implements said interfaces.
 * 
 */
