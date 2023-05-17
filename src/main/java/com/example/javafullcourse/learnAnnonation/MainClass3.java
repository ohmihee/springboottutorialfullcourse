package com.example.javafullcourse.learnAnnonation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

// single member Annotation
@Retention(RetentionPolicy.RUNTIME)
@interface SingleMemberAnnotation {
    int value();
}


@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
    String stringValue();
    int intValue() default 0;
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description() default " default description";
}

@SingleMemberAnnotation(111)
@What(description = "An annotation test class")
@MyAnnotation3(stringValue = "for class")
public class MainClass3 {
    @What(description = "An annotation test method")
    @MyAnnotation3(stringValue = "Annotation Example", intValue = 100)
    public static void myMethod(String str, int i ) {

    }

    public static void main(String[] args) {
        try {
            MainClass3 ob = new MainClass3();
            Annotation[] annos = ob.getClass().getAnnotations();

            Method m = ob.getClass().getMethod("myMethod", String.class, int.class);
            Annotation[] annos2 = m.getAnnotations();

            System.out.println("All annotations for Meta2");
            for(Annotation a : annos) {
                System.out.println(a);
            }

            System.out.println("All annotations for myMeth");
            for(Annotation a : annos2) {
                System.out.println(a);
            }
        }catch(Exception e) {

        }
    }
}
