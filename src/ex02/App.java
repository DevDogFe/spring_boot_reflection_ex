package ex02;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

public class App {

    public static void findUri(UserController uc, String uri) throws Exception {
        boolean isFind = false;

        // 리플렉션을 활용해서 UserController에 선언된 메서드 정보를 가져오자.
        Method[] methods = uc.getClass().getMethods();

        for (Method mt : methods) {
            // 해당 메서드에 선언된 RequestMapping 어노테이션을 가져오기
            Annotation anno = mt.getDeclaredAnnotation(RequestMapping.class);
            RequestMapping rm = (RequestMapping) anno;
            if (rm != null) {
                if (rm.uri().equals(uri)) {
                    isFind = true;
                    // 메서드 호출
                    mt.invoke(uc);
                    // break; // 찾았으니 반복문 종료
                }
            }
        }
        if (isFind == false) {
            System.out.println("404 Not Found");
        }

    }

    public static void main(String[] args) throws Exception {

        // 사용자 입력을 받는 객체 필요
        Scanner sc = new Scanner(System.in);
        String uri = sc.nextLine();

        findUri(new UserController(), uri);

    }

}
