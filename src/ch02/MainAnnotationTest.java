package ch02;

public class MainAnnotationTest {
    public static void main(String[] args) {
        // 리플렉션기법 - 클래스의 정보를 가지고 오거나 조작할 수 있다.
        Class<TestClass> testClazz = TestClass.class;
        // 방어적 코드 - TestClass에 우리가 정의한 어노테이션이 존재하는가?
        if (testClazz.isAnnotationPresent(MyCustomAnnotation.class)) {
            System.out.println("testClazz = " + testClazz);
            // TEstClass 클래스에서 어노테이션에 요소 값을 추출하기
            MyCustomAnnotation annotation = testClazz.getAnnotation(MyCustomAnnotation.class);
            System.out.println("annotation = " + annotation.value());
        }
    }
}
