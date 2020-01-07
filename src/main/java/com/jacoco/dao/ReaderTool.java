package com.jacoco.dao;
import com.jacoco.utils.Tools;
import org.springframework.core.io.ClassPathResource;
import java.io.*;
import java.util.Map;

public class ReaderTool {

//    public static void main(String[] args) {
//        try {
//           System.out.println( ReaderTool.readTxt(1));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


    public static String readTxt(int uid) throws IOException {
        String filePath = uid + ".txt";
        StringBuffer sb = new StringBuffer();
        readToBuffer(sb, filePath);
        return sb.toString();

    }

    private static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(filePath);
        System.out.println(resource);
        InputStream is = resource.getInputStream();


        String line; // 用来保存每行读取的内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // 读取第一行
        while (line != null) { // 如果 line 为空说明读完了
            buffer.append(line); // 将读到的内容添加到 buffer 中
            buffer.append("\n"); // 添加换行符
            line = reader.readLine(); // 读取下一行
        }
        reader.close();
        is.close();
    }

    public static String readName(int uid) {
        for (Map.Entry<Integer, String> entry : Tools.getNamelist().entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());

            if (entry.getKey() == uid) {
                return entry.getValue();
            }

        }
        return "我是谁";

    }

}
