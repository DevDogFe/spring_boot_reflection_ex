package ch01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainTest {

    // main
    public static void main(String[] args) throws Exception {
        
        Class<?> clazz = Class.forName("ch01.UserController");
        System.out.println(clazz);
        System.out.println("clazz.toString() = " + clazz.toString());
        System.out.println("-----------------------------------");

        // 필드 접근
        Field publicField = clazz.getField("name");
        Field privateField = clazz.getDeclaredField("age");
        System.out.println("publicField = " + publicField);
        System.out.println("privateField = " + privateField);
        System.out.println("-----------------------------------");

        // 메서드 접근
        Method publicMethod = clazz.getMethod("login");
        Method privateMethod = clazz.getDeclaredMethod("join");
        System.out.println("publicMethod = " + publicMethod);
        System.out.println("privateMethod = " + privateMethod);
        System.out.println("-----------------------------------");

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for (Constructor<?> c: constructors
             ) {
            System.out.println("생성자: " + c);
        }
    } // end of main

} // end of class
