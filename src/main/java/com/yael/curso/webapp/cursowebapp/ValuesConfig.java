package com.yael.curso.webapp.cursowebapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
    // esto es para que acepte caracteres especiales como acentos y ñ
    @PropertySource("classpath:values.properties")
// 	@PropertySource("classpath:values2.properties")
})
public class ValuesConfig {

    
}
