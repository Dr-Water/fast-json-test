package com.ratel.json;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonApplication.class, args);
		System.out.println("启动成功");
	}

}
