package demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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

		Application dcdm = new Application();

		SwitchPort port1 = new SwitchPort("LC",21);
		SwitchPort port2 = new SwitchPort("Copper",25);

		SwitchTemplate switchTemplate = new SwitchTemplate(1,2,11,12,13,14,"here",14,"unknown");
		long id1 = dcdm.addSwitchTemplate(switchTemplate);
		dcdm.addPortToSwitchTemplate(port1, switchTemplate);
		dcdm.addPortToSwitchTemplate(port2, switchTemplate);
		switchTemplate.printSwitch();

		switchTemplate = new SwitchTemplate(21,22,211,212,213,214,"here",24,"unknown");
		long id2 = dcdm.addSwitchTemplate(switchTemplate);
		dcdm.addPortToSwitchTemplate(port1, switchTemplate);
		dcdm.addPortToSwitchTemplate(port2, switchTemplate);
		switchTemplate.printSwitch();
		
		switchTemplate = new SwitchTemplate(311,312,311,312,313,314,"here1",34,"unknown");
		long id3 = dcdm.addSwitchTemplate(switchTemplate);
		dcdm.addPortToSwitchTemplate(port1, switchTemplate);
		dcdm.addPortToSwitchTemplate(port2, switchTemplate);
		switchTemplate.printSwitch();

		dcdm.deleteSwitchTemplate(id2);
		System.out.println("deleted id = "+id2);  
		dcdm.updateSwitchDimentions(id1, 500, 600, 700);
		System.out.println("updated id = "+id1);  
		HibernateUtil.closeSessionFactory();
	}
	
	
	/* Method to CREATE a switch in the database */
	public long addSwitchTemplate(SwitchTemplate switchTemplate){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Long switchID = null;
		try{
			tx = session.beginTransaction();
			switchID = (Long) session.save(switchTemplate); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return switchID;
	}
	/* Method to DELETE an switchTemplate from the records */
	public void addPortToSwitchTemplate(SwitchPort port, SwitchTemplate switchTemplate){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			port.setSwitchTemplate(switchTemplate);
			session.save(port); 
			
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}  


	/* Method to DELETE an switchTemplate from the records */
	public void deleteSwitchTemplate(Long switchTemplateID){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			SwitchTemplate switchTemplate = 
					(SwitchTemplate)session.get(SwitchTemplate.class, switchTemplateID); 
			switchTemplate.getPorts().clear();
			session.delete(switchTemplate); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}  

	/* Method to DELETE an switchTemplate from the records */
	public void updateSwitchDimentions(long switchTemplateID, float height, float width, float depth){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			SwitchTemplate switchTemplate = 
					(SwitchTemplate)session.get(SwitchTemplate.class, switchTemplateID);
			switchTemplate.setHeight(height);
			switchTemplate.setDepth(depth);
			switchTemplate.setWidth(width);
			session.update(switchTemplate); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}  

}
