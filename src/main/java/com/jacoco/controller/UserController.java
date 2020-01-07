package com.jacoco.controller;

import com.jacoco.service.UserServer;
import com.jacoco.utils.Tools;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@SpringBootApplication
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    String getUserInfo(@RequestParam(value = "uid") int uid) {

        if (uid >= 1) {
            try {
                return new UserServer().getUserInfo(uid);
            } catch (IOException e) {
                e.printStackTrace();
                return e.getMessage();
            }

        } else {
            return "uid 格式错误";
        }


    }

    @RequestMapping(value = "/getUserName", method = RequestMethod.GET)
    String getUserName(@RequestParam(value = "uid") int uid) {
        if (uid >= 1) {
            return new UserServer().getUserName(uid);
        } else {
            return "uid 格式错误";
        }


    }

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    String sayHello() {
        return "hello world!!!";
    }

    @RequestMapping(value = "/setUserInfo", method = RequestMethod.POST)
    int setUserInfo(@RequestParam(value = "uid") int uid, @RequestBody String info) {

        return new UserServer().setUserInfo(info, uid);

    }

    @RequestMapping(value = "/setUserName", method = RequestMethod.POST)
    int setUserName(@RequestParam(value = "uid") int uid, @RequestBody String name) {

        return new UserServer().serUserName(name, uid);

    }

}
