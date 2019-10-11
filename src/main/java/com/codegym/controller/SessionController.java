package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@SessionAttributes("cart")

public class SessionController {
    static List<Integer> list = new ArrayList<>();
    static {
        list.add(1);
        list.add(2);
    }
    @RequestMapping("/index")
    public ModelAndView index(HttpSession session){
        session.setAttribute("list", list);
        session.setAttribute("cart",10);
        ModelAndView modelAndView = new ModelAndView("list");
        return modelAndView;
    }

    @RequestMapping("/a")
    public ModelAndView a(HttpSession session){
        List<Integer> list1 = (List<Integer>) session.getAttribute("list");
        int a = list1.get(0)+1;
        list1.set(0,a);
        session.setAttribute("list", list1);
        ModelAndView modelAndView = new ModelAndView("list");
        return modelAndView;
    }
}
