package demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import DCDM.DCDMtest;
import DCDM.HibernateUtil;
import DCDM.SwitchPort;
import DCDM.SwitchTemplate;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		System.out.println("Test....");

		SpringApplication.run(Application.class, args);


		sessionFactory = HibernateUtil.getSessionFactory();

		DCDMtest dcdm = new DCDMtest();
		if (dcdm.test()){
			System.out.println("**** Hibernate test succeeded");
		}else{
			System.out.println("**** Hibernate test failed");
		}
	}
	
}
