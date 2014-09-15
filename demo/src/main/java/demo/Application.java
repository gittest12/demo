package demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import DCDM.HibernateUtil;
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

		long id1 = dcdm.addSwitchTemplate(1,2,11,12,13,14,"here",24);
		System.out.println("added id = "+id1);
		long id2 = dcdm.addSwitchTemplate(11,12,111,112,113,114,"here1",34);
		System.out.println("added id = "+id2);    
		dcdm.deleteSwitchTemplate(id2);
		System.out.println("deleted id = "+id2);  
		dcdm.updateSwitchDimentions(id1, 500, 600, 700);
		System.out.println("updated id = "+id1);  
		HibernateUtil.closeSessionFactory();
	}
	
	
	/* Method to CREATE a switch in the database */
	public long addSwitchTemplate(int switchType, int switchName, int hight,
			float width, float depth, float energy, String location,
			int numberOfPorts){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Long switchID = null;
		try{
			tx = session.beginTransaction();
			SwitchTemplate switchTemplate = new SwitchTemplate(switchType, switchName, hight,
					width, depth, energy, location, numberOfPorts);
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
	public void deleteSwitchTemplate(Long switchTemplateID){
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			SwitchTemplate switchTemplate = 
					(SwitchTemplate)session.get(SwitchTemplate.class, switchTemplateID); 
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
