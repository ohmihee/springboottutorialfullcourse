package com.example.javafullcourse.learnAnnonation;

import java.lang.reflect.Field;
import java.util.UUID;

public class UUIDGeneratorProcessor {
    public static void process(Object object) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(UUIDGenerator.class)) {
                field.setAccessible(true);
                try {
                    field.set(object, UUID.randomUUID().toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
