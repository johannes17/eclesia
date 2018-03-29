package br.vix.rws.eclesia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EclesiaApplication {

	private static ApplicationContext APPLICATION_CONTEXT;
	
	public static void main(String[] args) {
		APPLICATION_CONTEXT = SpringApplication.run(EclesiaApplication.class, args);
	}

	public static <T> T getBean(Class<T> requiredType) {
		return APPLICATION_CONTEXT.getBean(requiredType);
	}


}
