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
        
        long id = dcdm.addSwitchTemplate(1,2,11,12,13,14,"here",24);
        System.out.println("id = "+id);
        id = dcdm.addSwitchTemplate(11,12,111,112,113,114,"here1",34);
        System.out.println("id = "+id);        
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
    

}
