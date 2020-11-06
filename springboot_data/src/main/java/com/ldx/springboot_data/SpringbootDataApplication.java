package com.ldx.springboot_data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ldx.springboot_data.mapper")
@SpringBootApplication
public class SpringbootDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDataApplication.class, args);
	}

}
