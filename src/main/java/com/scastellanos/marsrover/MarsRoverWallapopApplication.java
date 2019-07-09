package com.scastellanos.marsrover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.scastellanos.marsrover")
public class MarsRoverWallapopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsRoverWallapopApplication.class, args);
	}

}
