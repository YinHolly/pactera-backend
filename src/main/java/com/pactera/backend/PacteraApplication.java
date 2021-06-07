package com.pactera.backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
* class: PacteraApplication  
* @author Holly.y.yin
* @date 2021/06/01
*
 */
@SpringBootApplication
@MapperScan("com.pactera.backend.mapper")
public class PacteraApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PacteraApplication.class);
		app.run(args);

	}

}
