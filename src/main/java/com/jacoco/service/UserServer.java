package com.jacoco.service;

import com.jacoco.dao.ReaderTool;
import com.jacoco.dao.WriterTool;
import com.jacoco.utils.Tools;
import java.io.IOException;

public class UserServer {


    public String getUserInfo(int uid) throws IOException {
        return ReaderTool.readTxt(uid);
    }


    public String getUserName(int uid) {
        return ReaderTool.readName(uid);
    }

    public int setUserInfo(String info, int uid) {
        try {
            WriterTool.saveTxt(info, uid);
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int serUserName(String name, int uid) {
        try {
            Tools.setName(name, uid);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
