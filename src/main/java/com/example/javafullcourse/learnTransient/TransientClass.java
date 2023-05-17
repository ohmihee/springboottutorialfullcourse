package com.example.javafullcourse.learnTransient;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class TransientClass {
    public static void main(String[] args) throws Exception {
        User a = new User("A", "B");
        System.out.println("logon a = " + a);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("User.out"));
        o.writeObject(a);
        o.close();

        Thread.sleep(1000); // Delay for 1 second

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("User.out"));
        System.out.println("Recovering object at " + new Date());
        a = (User) in.readObject();
        System.out.println("logon a = " + a);
    }
}

class User implements Serializable {
    private Date date = new Date();

    private String username;

    private transient String password;

    public User(String name, String pwd) {
        username = name;
        password = pwd;
    }

    public String toString() {
        String pwd = (password == null) ? "(n/a)" : password;
        return "logon info: \n   username: " + username + "\n   date: " + date + "\n   password: "
                + pwd;
    }
}
