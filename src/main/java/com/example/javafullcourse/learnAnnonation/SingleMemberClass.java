package com.example.javafullcourse.learnAnnonation;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle {
    int value();
}

public class SingleMemberClass {
    @MySingle(100)
    public static void myMeth() {
        SingleMemberClass ob = new SingleMemberClass();

        try {
            Method m = ob.getClass().getMethod("myMeth");
            MySingle anno = m.getAnnotation(MySingle.class);
            System.out.println(anno.value());
        } catch(NoSuchMethodException e) {
            System.out.println("Method not found");
        }
    }

    public static void main(String argsp[]) {
        myMeth();
    }

}
