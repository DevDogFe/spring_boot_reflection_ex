package ex03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // 메서드에 선언 가능한 어노테이션으로 정의
public @interface RequestMapping {

    String uri(); // 어노테이션 요소
}
