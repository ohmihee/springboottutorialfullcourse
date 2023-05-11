package com.example.javafullcourse.learnFormat;

import java.io.File;
import java.text.MessageFormat;
import java.util.Scanner;

public class MessageFormatEx551 {
    public static void main(String[] args) throws Exception {
        String tableName ="USER_INFO";
        String fileName = "data4.txt";
        String msg = "INSERT INTO "
                + tableName + " VALUES (''{0}'',''{1}'',{2},''{3}'');";
        // 파일에서 출력해 온 데이터를 각각 위의 숫자의 위치에 맞게 넣어준다.
        Scanner s = new Scanner(new File(fileName));
        String pattern = "{0}/{1}/{2}/{3}";
        // 읽어올 파일에서 데이터는 위와 같이 '/'로 구분자가 되어 있어야 한다.

        MessageFormat mf = new MessageFormat(pattern);
        while(s.hasNextLine()) {
            // line 즉 한 줄을 기준으로 하여 데이터를 가져온다..
            String line = s.nextLine();
            Object[] objs = mf.parse(line);
            // 구분자 '/'를 기준으로 파싱하여 가져온 데이터를 objs에 담는다.

            System.out.println(
                    MessageFormat.format(msg, objs)
                    // 파싱되어 objs에 담긴 데이터를 msg 형식에 맞추어 출력한다.
            );
        }
        s.close();
        // 파일을 닫는다.
    }
}