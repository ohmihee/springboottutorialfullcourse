package com.example.javafullcourse.tutorial.annonation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String stringValue() default "default";
    int intValue() default 10;
}

class Meta {
    @MyAnnotation()
    public static void myMeth(){
        Meta ob = new Meta();

        try {
            Class c = ob.getClass();
            Method m = c.getMethod("myMeth");

            MyAnnotation anno = m.getAnnotation(MyAnnotation.class);
            System.out.println(anno.stringValue()+":"+anno.intValue());

        }catch(NoSuchMethodException e) {
            System.out.println("error : " + e);
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}

public class MainClass {
    @MyAnnotation(stringValue = "test", intValue = 1)
    public static void myMethod() {

    }
}
