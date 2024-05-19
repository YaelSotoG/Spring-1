package com.yael.curso.webapp.cursowebapp.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.yael.curso.webapp.cursowebapp.models.Users;
import com.yael.curso.webapp.cursowebapp.models.dto.dto;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class UserRestController {

    
    @GetMapping("/detailsrest")
    public dto details(){
        dto userdto=new dto();
        Users user=new Users("Yael","Soto");
        userdto.setUser(user);
        userdto.setTitle("Usuario con dto");{}
        return userdto;
    }
    
    
    

    @GetMapping("/list")
    public List<Users> list(){
        Users user=new Users("Yael","Soto");
        Users user2=new Users("Paty","Perez");
        Users user3=new Users("Osman","Soto");
        
        List<Users> users=Arrays.asList(user,user2,user3);
        
        //hace lo mismo que arriba pero arriba en una sola linea
        //este sirve para hacer arreglos con for
        
        // List<Users> users = new ArrayList<>();
        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        return users;

    }

    @GetMapping("/detailsrest/map")
    public Map<String, Object> detailsMap(){

        Users user=new Users("Yael","Soto");
        Map<String, Object>body=new HashMap<>();
        body.put("title", "hola mundo spring");
        body.put("user", user);
        return body;
    }
}
