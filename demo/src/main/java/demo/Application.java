package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import DCDM.DCDMtest;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {

		System.out.println("Test....");

		SpringApplication.run(Application.class, args);

		DCDMtest dcdm = new DCDMtest();
		if (dcdm.test()){
			System.out.println("**** Hibernate test succeeded");
		}else{
			System.out.println("**** Hibernate test failed");
		}
	}
	
}
