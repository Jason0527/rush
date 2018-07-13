package com.jason.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author jason
 *
 */
@MapperScan("com.jason.boot.specific.*.dao")
@SpringBootApplication
public class RushApplication {

	public static void main(String[] args) {
		SpringApplication.run(RushApplication.class, args);
	}
}
