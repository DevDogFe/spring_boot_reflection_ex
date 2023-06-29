package ex03;

import ex02.UserController;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class App {

    /**
     *
     * 이 함수는 특정 패키지 내의(ex02 or ex03) 모든 클래스를 스캔하고
     * @Controller 어노테이션이 붙어 있는 클래스들을 확인하여 Set<Class<?>>
     * 형태의 자료구조에 담고 반환한다.
     */
    public static Set<Class<?>> componentScan(String pkg) throws Exception{
        // 현재 스레드의 컨텍스트 클래스 로더를 가져온다.
        // 특정 스레드가 어떤 클래스를 로드해야 하는지 결정하는데 사용(클래스 로더)
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Set<Class<?>> classes = new HashSet<>();

        // pkg -> ex02, ex03
        // 클래스 로더를 사용하여, 주어진 패키지명에 해당하는 URL을 가져온다.
        URL packageUrl = classLoader.getResource(pkg);
        File packageDirectory = new File(packageUrl.toURI());
        // 해당 패키치(디렉토리)에 있는 모든 파일을 순회한다.
        for (File file: packageDirectory.listFiles()){
            // App.class UserController.class 등..
            if(file.getName().endsWith(".class")){
                String className = pkg + "." + file.getName().replace(".class", "");
                // System.out.println("classNAme: " + className);
                Class<?> cls = Class.forName(className);

                classes.add(cls);
            }
        }

        System.out.println(packageUrl);
        System.out.println(packageDirectory);
        return classes;
    }

    /**
     * 이 함수는 사용자가 입력한 URI 방식에 값(uri)을 넘겨받아 componentScan 함수에서 실행한
     * Set<Class<?>> 타입의 데이터들 중에 사용자가 입력한 값과
     * @RequestMapping 어노테이션의 요소값(uri)을 비교하여
     * 일치하면 해당 메서드를 호출시키는 역할을 한다.
     */
    public static void findUri(Set<Class<?>> classes, String uri) throws Exception{
        boolean isFind = false;
        for(Class<?> cls: classes){
            // @Controller 어노테이션이 존재하는지 확인
            if(cls.isAnnotationPresent(Controller.class)) {
                // 생성자를 통해서 메모리에 올리고 참조 변수를 닫아둔다.
                Object instance = cls.getDeclaredConstructor().newInstance();
                // 해당 클래스에 모든 메서드 정보를 담아둔다.
                Method[] methods = cls.getDeclaredMethods();
                for (Method mt : methods){
                    Annotation annotation = mt.getDeclaredAnnotation(RequestMapping.class);
                    if(annotation != null){
                        RequestMapping rm = (RequestMapping) annotation;
                        if(rm.uri().equals(uri)){
                            isFind = true;
                            // uri 값이 일치한다면 해당 메서드를 호출한다.
                            mt.invoke(instance);
                            break;
                        }
                    }
                }

            }
        } // end of for
        if(isFind == false){
            System.out.println("404 Not Found");
        }
    }

    // main 함수
    public static void main(String[] args) throws Exception {

        // 컴퍼넌트 스캔 수행
        Set<Class<?>> classes = componentScan("ex03");
        System.out.println(classes);

        // 사용자 입력을 받는 객체 필요
        // 사용자 입력 받는 (브라우저 주소값 이력)
        Scanner sc = new Scanner(System.in);
        String uri = sc.nextLine();
        findUri(classes, uri);

        // 실제 URI 맵핑 확인

    } // end of main

} // end of class
