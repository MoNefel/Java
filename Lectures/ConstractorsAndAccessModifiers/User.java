package Lectures.ConstractorsAndAccessModifiers;

//Acces Modifiers
//public, private, static, protected, default
//getters and setters
public class User {

    //attributes :
    private String name;
    private String email;
    private Integer age;

    static Integer totalUsers = 0; // global for the class User and when we want to acces it from another Class you should call it by the class name (User.totalUsers)

    //constructor
    public User(){
        totalUsers ++;
    }

    //constructor overLoading
    public User(String name, String email, Integer age){
        totalUsers ++;
        this.name = name;
        this.email = email;
        this.age = age;
    }


    //methods
    //getter
    public String getName(){
        return this.name;
    }

    //setter
    public void setName(String name){
        this.name = name;
    }

    //getter
    public String getEmail(){
        return this.email;
    }

    //setter
    public void setEmail(String email){
        this.email = email;
    }

    //getter
    public Integer getAge(){
        return this.age;
    }

    //setter
    public void setAge(Integer age){
        this.age = age;
    }
}
