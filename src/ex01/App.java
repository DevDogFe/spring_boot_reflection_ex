package ex01;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // 사용자 입력을 받는 객체 필요
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();

        UserController userController = new UserController();

        if (path.equals("/login")) {
            userController.login();
        } else if (path.equals("/join")) {
            userController.join();
        } else {
            System.out.println("404 Not Found!");
        }




    }

}
