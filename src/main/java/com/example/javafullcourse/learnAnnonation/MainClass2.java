package com.example.javafullcourse.learnAnnonation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    String stringValue();
    int intValue();
}
public class MainClass2 {
    @MyAnnotation2(stringValue = "Annotation Example", intValue = 100)
    public static void myMethod(String str, int i ) {
    }

    public static void main(String[] a) {
        try {
            MainClass2 ob = new MainClass2();
            Class c = ob.getClass();
            Method m = c.getMethod("myMethod", String.class, int.class);
            MyAnnotation2 anno = m.getAnnotation(MyAnnotation2.class);
            System.out.println(anno.stringValue() + "" + anno.intValue());
        }catch(NoSuchMethodException e) {
            System.out.println("Mymethod2 Not found");
        }
    }


}
