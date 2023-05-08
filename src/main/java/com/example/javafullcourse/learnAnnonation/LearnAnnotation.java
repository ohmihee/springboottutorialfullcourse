package com.example.javafullcourse.learnAnnonation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LearnAnnotation {
    String value();
};

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Id {
    IdType strategy() default IdType.AUTO;
    String name() default "";
}
enum IdType {
    AUTO("auto"),
    UUID("uuid"),
    SEQUENCE("sequence");
    private String value;
    IdType (String value) {
        if (value == "uuid") {
            this.value = java.util.UUID.randomUUID().toString();
        } else {
            this.value = value;
        }
    }
    String getValue () {
        return value;
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Id2 {
    IdType value () default IdType.AUTO;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Entity {
    IdType id () default IdType.AUTO;;
}

@Entity(id=IdType.UUID)
class MyClass3 {
    private String id;
    void setId () {
//        Class<MyClass3> obj = MyClass3.class;
//        Entity annotation = obj.getAnnotation(Entity.class);
//        if (annotation.id().getValue().equals("uuid")) {
//         this.id = UUID.randomUUID().toString();
//        } else {
//            this.id = annotation.id().toString();
//        }
    }
    String getId () {
        return this.id;
    }
}


class MyClass2 {
    @Id2(IdType.SEQUENCE)
    private String id;
    public String getId () {
        return id;
    }
}
class MyClass {
    @Id(strategy = IdType.SEQUENCE)
    private String id;
    public String getId () {
        return id;
    }
}

//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
//public @interface UUIDId {
//    // UUID 값을 할당하는 메서드
//    static void assignUUID(Object obj) throws IllegalAccessException {
//        Field[] fields = obj.getClass().getDeclaredFields(); // 클래스에 선언된 모든 필드 가져오기
//        for (Field field : fields) {
//            if (field.isAnnotationPresent(UUIDId.class)) { // UUIDId 어노테이션이 적용된 필드인지 확인
//                field.setAccessible(true); // private 필드에 접근하기 위해 accessible 변경
//                if (field.getType() == UUID.class) { // 필드의 타입이 UUID일 경우에만 UUID 값 할당
//                    UUID uuid = UUID.randomUUID(); // 새로운 UUID 생성
//                    field.set(obj, uuid); // UUID 값을 필드에 할당
//                }
//            }
//        }
//    }
//}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Timer {
}

class MyClass4 {
    @Timer
    public void myMethod() {
        try {
            Thread.sleep(1000); // 1초간 실행 지연
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class TimerAspect {
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        if (method.isAnnotationPresent(Timer.class)) {
            long startTime = System.currentTimeMillis();
            Object result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            System.out.println(method.getName() + " 실행 시간: " + (endTime - startTime) + "ms");
            return result;
        } else {
            return joinPoint.proceed();
        }
    }
}
