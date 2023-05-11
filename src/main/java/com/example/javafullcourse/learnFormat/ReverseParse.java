package com.example.javafullcourse.learnFormat;

import java.io.File;
import java.text.*;
import java.util.Scanner;

public class ReverseParse {
    public static void main(String[] args) throws Exception {
        String fileName = "sqldata.txt";
        Scanner s = new Scanner(new File(fileName));
        String pattern =
                "INSERT INTO USER_INFO VALUES ({0},{1},{2},{3});";
        MessageFormat mf = new MessageFormat(pattern);
        Object[] objs = new Object[0];
        int i = 0;
        while(s.hasNextLine()) {
            String line = s.nextLine();
            objs[i] = mf.parse(line);
            i++;
        }

        for (int i2 = 0; i2 < objs.length; i2++) {
            for(int j=0; j < objs.length; ++j) {
             System.out.print(objs[j] + ",");
            }
            System.out.println();
        }
    }
}
