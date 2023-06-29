package ch02;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // 클래스레벨에서만 사용할 수 있도록 정의
public @interface MyCustomAnnotation { // 커스텀 어노테이션 정의
    String value() default ""; // 어노테이션 요소 정의
}
