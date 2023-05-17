package com.example.javafullcourse.learnAnnonation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String stringValue();
    int intValue();
}
public class MainClass {
    @MyAnnotation(stringValue = "Annotation Example", intValue = 100)
    public static void myMethod() {

    }

    public static void main (String[] a) {
        try {
            MainClass ob = new MainClass();
            Class c = ob.getClass();
            Method m = c.getMethod("myMethod");
            MyAnnotation anno = m.getAnnotation(MyAnnotation.class);
            System.out.println(anno.stringValue() + "" + anno.intValue());
        }catch(NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }
}
