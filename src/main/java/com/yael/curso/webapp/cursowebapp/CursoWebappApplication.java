package com.yael.curso.webapp.cursowebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication

// // aqui es para agregar archivos properties
// // @PropertySource("classpath:values.properties")

// //cuando son muchos properties
// // @PropertySources({
// // 	@PropertySource("classpath:values.properties")
// // 	@PropertySource("classpath:values2.properties")
// // })


public class CursoWebappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoWebappApplication.class, args);
	}

}
