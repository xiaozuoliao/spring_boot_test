package com.jacoco;

import com.jacoco.utils.Tools;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JacocoPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(JacocoPlatformApplication.class, args);

		Tools.loadName();
	}

}
