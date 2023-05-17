package com.example.javafullcourse.learnAnnonation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyMarker {
}

public class Marker {

    public void notExistMeth() {

    }

    @MyMarker
    public static void myMeth() {
        Marker ob = new Marker();


        try {
            Method m = ob.getClass().getMethod("myMeth");
            Method notExistMethod = ob.getClass().getMethod("notExistMeth");
            if (m.isAnnotationPresent(MyMarker.class)) {
                System.out.println("MyMarker is present. in myMeth");
            }
            if (notExistMethod.isAnnotationPresent(MyMarker.class)) {
                System.out.println("MyMarker is present. in notExistMeth" );
            }
        }catch(NoSuchMethodException e) {
            System.out.println("Method Not Found");
        }
    }

    public static void main(String args[]) {
        myMeth();
    }
}
