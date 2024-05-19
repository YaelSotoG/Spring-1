package com.yael.curso.webapp.cursowebapp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yael.curso.webapp.cursowebapp.models.Users;
import com.yael.curso.webapp.cursowebapp.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/var")

public class PathVariableController {

    @Value("${config.username}")
    private String username;
    // @Value("${config.message}")
    // private String message;
    @Value("${config.listOfValues}")
    // private String[] listOfValues; //ambas funcionan igual
    private List<String> listOfValues;
    @Value("${config.code}")
    private Integer code;


    @Value("#{ '${config.listOfValues}'.split(',')}")
    private List<String> valueList;
   
    @Value("#{'${config.listOfValues}'}")
    private String valueString;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;
  
    @Value("#{${config.valuesMap}.product}")
    private String product;
    @Value("#{${config.valuesMap}.price}")
    private String price;

    //buscar algun componente de spring en el contenedor
    @Autowired
    private Environment enviroment;

    //el "message dentro del path variable debe de ser el mismo en el baz/{message}"
    @GetMapping("/baz/{message}")       
    public ParamDto baz(@PathVariable(name = "message") String message) {
        ParamDto param= new ParamDto();
        param.setMessage(message);
        return param;
    
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixParathVar(@PathVariable String product, @PathVariable Long id) {
        Map<String,Object> json= new HashMap<>();
        json.put("product",product);
        json.put("id",id);
        return json;
    }


    @PostMapping("/create")
    public Users create(@RequestBody Users user) {
        //TODO: process POST request
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> getMethodName(@Value("${config.message}") String message) {
        Map<String,Object> json= new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("message2", enviroment.getProperty("config.message"));
        json.put("code2", Integer.valueOf(enviroment.getProperty("config.code")));
        json.put("listOfValues", listOfValues);
        json.put("valueList", valueList);
        json.put("valueString", valueString);
        json.put("valuesMap", valuesMap);
        json.put("product", product);
        json.put("price", price);
        return json;
    }
    
    
    
    

}
