package com.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(value = {"classpath:"+Bootup.APPLICATION_CONTEXT_XML})
@SpringBootApplication
public class SpringBoot04Application {
	
	public static void main(String[] args) {
		if (args == null || args.length == 0) {
			boolean flag = new Bootup().createAopConfig4MultiDatasource();
			if (!flag) {
				return;
			}
			args = new String[]{"1"};
		}
		
		SpringApplication.run(SpringBoot04Application.class, args);
	}

}

