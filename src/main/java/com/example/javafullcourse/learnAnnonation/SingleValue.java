package com.example.javafullcourse.learnAnnonation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation4{
    int value();
    int defaultValue() default 100;
}

@MyAnnotation4(102)
public class SingleValue {
    @MyAnnotation4(101)
    public static void myMethod() {

    }

    public static void main(String[] args) {
        try {
            SingleValue ob = new SingleValue();
            Method m = ob.getClass().getMethod("myMethod");
            Annotation[] annos = m.getAnnotations();

            System.out.println("All annotations for myMeth: ");
            for(Annotation a: annos) {
                System.out.println(a);
            }
        }catch(Exception e) {

        }
    }
}
