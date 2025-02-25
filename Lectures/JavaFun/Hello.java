package Lectures;

public class Hello {
    public void hello(){
        System.out.println("hello helloo!");
    }

    //Over Loading functions, same name diffrente signatures or parametres
    public String newFun(String name, String day){
        return "Hellooo";
    }

    public String newFun(String name){
        return "Hellooo";
    }
    public String newFun(String name, String day, String month){
        return "Hellooo";
    }
}
