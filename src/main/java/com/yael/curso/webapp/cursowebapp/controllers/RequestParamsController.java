package com.yael.curso.webapp.cursowebapp.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.yael.curso.webapp.cursowebapp.models.dto.ParamDto;
import com.yael.curso.webapp.cursowebapp.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/params")
public class RequestParamsController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false,defaultValue = "Hola que tal") String message) {
        ParamDto param= new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamMixDto Bar(@RequestParam ()  String text,@RequestParam Integer code) {
        ParamMixDto params=new ParamMixDto();
        params.setMessage(text);
        params.setCode(code);
        return params;

    }
    
    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request){
        Integer code = 0;
        try{
            code=Integer.parseInt(request.getParameter("code"));
        }
        catch(NumberFormatException e){

        }
        ParamMixDto params=new ParamMixDto();
        params.setCode(code);
        params.setMessage(request.getParameter("message"));
        return params;
    }
    
    
}
