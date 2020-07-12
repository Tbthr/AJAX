package com.lyq.ajax.controller;

import com.lyq.ajax.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @PostMapping("/a1")
    public void ajax1(String name, HttpServletResponse response) throws IOException {
        if ("admin".equals(name)) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @GetMapping("/a2")
    public List<User> ajax2() {
        List<User> list = new ArrayList<User>();
        list.add(new User("秦疆1号", 3, "男"));
        list.add(new User("秦疆2号", 3, "男"));
        list.add(new User("秦疆3号", 3, "男"));
        return list;
    }

    @RequestMapping("/a3")
    public String ajax3(String name, String pwd) {
        String msg = "";
        //模拟数据库中存在数据
        if ("admin".equals(name) && "123456".equals(pwd)) {
            msg = "OK";
        } else {
            msg = "用户名或密码输入错误";
        }
        return msg;
    }
}