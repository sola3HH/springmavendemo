package com.hh.springmavendemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hh.springmavendemo.dao")
@SpringBootApplication
public class SpringmavendemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmavendemoApplication.class, args);
	}

}
