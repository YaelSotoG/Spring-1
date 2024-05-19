package com.yael.curso.webapp.cursowebapp.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.yael.curso.webapp.cursowebapp.models.Users;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){

        Users user=new Users("Yael","Soto");
        model.addAttribute("title", "hola mundo spring");
        model.addAttribute("user",  user);
        // model.addAttribute("lastname", "soto");
        
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        // model.addAttribute("users",users);
        model.addAttribute("title","listado de usuarios");
        return "list";
    }


    // esto es para cuando queremos que estos datos se utilicen en varios metodos
    @ModelAttribute("users")
    public List<Users> usersModel(){
        List<Users> users=Arrays.asList(
            new Users("yael","soto","xyarock@gmail.com"),
            new Users("osman","soto")
        );
        return users;
    }
    
}
