package com.springBoot;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import com.multi.dataSource.MultiDataSource;
import com.multi.log.LogAfterReturning;
import com.multi.log.LogBefore;
import com.multi.log.LogCoreAfterReturning;
import com.springBoot.boot.AopConfig;
import com.springBoot.boot.Bootup;

@ImportResource(value = {"classpath:"+Bootup.APPLICATION_CONTEXT_XML})
@SpringBootApplication
public class SpringBoot04Application {
	
	public static void main(String[] args) {
		
		if (args == null || args.length == 0) {
			try {
				AopConfig element1 = new AopConfig(MultiDataSource.class, 1);
				AopConfig element2 = new AopConfig(LogBefore.class, 2);
				AopConfig element3 = new AopConfig(LogAfterReturning.class, 2);
				AopConfig element4 = new AopConfig(LogCoreAfterReturning.class, 3);
				AopConfig[] arr    = new AopConfig[] { element1, element2, element3, element4 };
				String[]  pkgs     = new String[] { "com.multi", "com.springBoot.example" };
				
				boolean flag = new Bootup().createAopConfigByAnnotation(Arrays.asList(arr), pkgs);  
				if ( !flag ) {
					return;
				}
				args = new String[]{"1"};
				
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
		
		SpringApplication.run(SpringBoot04Application.class, args);
	}

}

