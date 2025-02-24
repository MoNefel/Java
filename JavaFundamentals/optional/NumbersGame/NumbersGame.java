package JavaFundamentals.optional.NumbersGame;

import java.util.Random;

public class NumbersGame {
     public static void main(String[] args){
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");
        System.out.println("Can you guess the number?");
        System.out.println("If you are not up to the task, you can always type 'q' to quit.");

        int answer = new Random().nextInt(0,10); // The answers should be generated before the while loop

        while(true){
            String guess = System.console().readLine();

            if(guess.equals("q")){
                System.out.println("I knew you didn't have it in you.");
                System.out.println("Shutting down...");
                break;
            }

            try{ // Use a try block to make sure guesses are always numbers
                if(Integer.parseInt(guess)<0 || Integer.parseInt(guess)>10){ // First we check if the number is between 0 and 10
                    System.out.println("Your number is not between 0 and 10...");
                }else if(Integer.parseInt(guess)==answer){
                    System.out.println("Lucky guess! But can you do it again?");
                    break;
                }else{
                    System.out.println("Swing and a miss! Keep trying...");
                }
            }catch(NumberFormatException n){
                System.out.println("A letter is not a number...");
            }
        }

        System.out.println("Game over. Shutting down...");
    }
}
