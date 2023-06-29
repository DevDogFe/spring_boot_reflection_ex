package ch01;

public class UserController {
    public String name;
    private int age;
    public UserController(){

    }
    public  UserController(String name){
        this.name = name;
    }

    public void login(){
        System.out.println("login()메서드 호출");
    }
    private void join(){
        System.out.println("join()메서드 호출");
    }
}
