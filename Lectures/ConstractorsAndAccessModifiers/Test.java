package Lectures.ConstractorsAndAccessModifiers;

public class Test {
    public static void main(String[] args) {
        User userOne = new User();
        User userTwo = new User("med", "med@g.com", 33);
        userOne.setName("akez");
        userOne.setEmail("email.com");
        userOne.setAge(35);
        System.out.println(userOne.getName());
        System.out.println(userTwo.getName());
        User userThree = new User();
        System.out.println("Number of users is :" + User.totalUsers);
        
    }
    
}
