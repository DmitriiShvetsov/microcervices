package com.shved.third;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestThirdApplication {

	public static void main(String[] args) {
		SpringApplication.from(ThirdApplication::main).with(TestThirdApplication.class).run(args);
	}

}
