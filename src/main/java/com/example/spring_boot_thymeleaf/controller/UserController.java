package com.example.spring_boot_thymeleaf.controller;


import com.example.spring_boot_thymeleaf.model.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("demo")
    public String demo(Model model) {
        List<User> lst = new ArrayList<>();
        lst.add(new User(1, "Tom", 30));
        lst.add(new User(2, "Jerry", 29));
        lst.add(new User(3, "Nancy", 27));
        model.addAttribute("list", lst);

        return "demo";
    }

    private String convertGPA(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade < 90 && grade >= 80) {
            return "B";
        } else if (grade < 80 && grade >= 70) {
            return "C";
        } else if (grade < 70 && grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    @ModelAttribute("httpRequest")
    public HttpServletRequest requestURI(final HttpServletRequest request) {
        return request;
    }

    @RequestMapping("demo3")
    public String demo3(HttpServletRequest request, Model model) {
        if (request == null) {
            System.out.println("HttpServletRequest is null");
        } else {
            System.out.println("HttpServletRequest is not null");
        }

        // Request
        request.setAttribute("request", "request data");
        // Session
        request.getSession().setAttribute("session", "session data");
        // Application
        request.getSession().getServletContext().setAttribute("application", "application data");
        requestURI(request);
        return "demo2";
    }

}
