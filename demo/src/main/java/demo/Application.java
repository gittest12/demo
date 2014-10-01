package demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springHibernateDemo.SwitchTemplateDaoImpl;
import springHibernateDemo.SwitchTemplateService;
import DCDM.DCDMtest;
import DCDM.SwitchPort;
import DCDM.SwitchTemplate;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {

		System.out.println("Test....");

		SpringApplication.run(Application.class, args);

		//		DCDMtest dcdm = new DCDMtest();
		//		if (dcdm.test()){
		//			System.out.println("**** Hibernate test succeeded");
		//		}else{
		//			System.out.println("**** Hibernate test failed");
		//		}
		//		dcdm.test();


		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		SwitchTemplateService service = (SwitchTemplateService) context.getBean("switchTemplateService");
		SwitchTemplateDaoImpl switchDao = (SwitchTemplateDaoImpl) context.getBean("switchDao");

		SwitchPort port1 = (SwitchPort) context.getBean("switchPort");
		port1.setType("LC");
		port1.setNumber(21);

		SwitchPort port2 = (SwitchPort) context.getBean("switchPort");
		port2.setType("Copper");
		port2.setNumber(25);

		SwitchTemplate switchTemplate = new SwitchTemplate(1,2,11,12,13,14,"here",14,"unknown");
		service.addSwitchTemplate(switchTemplate);
		switchDao.addPortToSwitch(switchTemplate, port1);
		switchDao.addPortToSwitch(switchTemplate, port2);


		//		long id1 = addSwitchTemplate(switchTemplate);
		//		addPortToSwitchTemplate(port1, switchTemplate);
		//		addPortToSwitchTemplate(port2, switchTemplate);
		switchTemplate.printSwitch();

		switchTemplate = new SwitchTemplate(21,22,211,212,213,214,"here",24,"unknown");
		service.addSwitchTemplate(switchTemplate);
		switchDao.addPortToSwitch(switchTemplate, port1);
		switchDao.addPortToSwitch(switchTemplate, port2);
		//		long id2 = addSwitchTemplate(switchTemplate);
		//		addPortToSwitchTemplate(port1, switchTemplate);
		//		addPortToSwitchTemplate(port2, switchTemplate);
		switchTemplate.printSwitch();

		switchTemplate = new SwitchTemplate(311,312,311,312,313,314,"here1",34,"unknown");
		service.addSwitchTemplate(switchTemplate);
		switchDao.addPortToSwitch(switchTemplate, port1);
		switchDao.addPortToSwitch(switchTemplate, port2);
		//		long id3 = addSwitchTemplate(switchTemplate);
		//		addPortToSwitchTemplate(port1, switchTemplate);
		//		addPortToSwitchTemplate(port2, switchTemplate);
		switchTemplate.printSwitch();


		List<SwitchTemplate> switches = service.fetchAllSwitches();
		System.out.println("The list of all persons = " + switches);

		((ClassPathXmlApplicationContext) context).close();
	}

}
