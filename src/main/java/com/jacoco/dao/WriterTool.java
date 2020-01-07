package com.jacoco.dao;

import org.springframework.util.ResourceUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterTool {


    public static void saveTxt(String info, int uid) throws IOException {

        String path = new File(ResourceUtils.getURL("classpath:").getPath()).getAbsolutePath();
        System.out.println(path);
        File file = new File(path);
        File filename = new File(path + "/" + uid + ".txt");
        if (!file.exists()) {
            try {
                file.createNewFile();// 不存在直接创建
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 写入内容
        String content = info;
        writeToBuffer(content, filename);
    }

    private static void writeToBuffer(String content, File filename) {
        try {
            FileWriter fw = new FileWriter(filename.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
            System.out.println("success");
        } catch (IOException e) {
            System.out.println("fail");
            e.printStackTrace();
        }

    }
}
