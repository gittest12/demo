package demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import DCDM.SwitchTemplate;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
    public static void main(String[] args) {
    	System.out.println("Test... develop branch");
        SpringApplication.run(Application.class, args);
        

        sessionFactory = createSessionFactory();
        
        Application dcdm = new Application();
        
        dcdm.addSwitchTemplate(1,2,1000,11,12,13,14,"here",24);
        dcdm.addSwitchTemplate(11,12,1001,111,112,113,114,"here1",34);
   
        
        
    }
    /* Method to CREATE a switch in the database */
    public Integer addSwitchTemplate(int switchType, int switchName, int id, int hight,
			float width, float depth, float energy, String location,
			int numberOfPorts){
       Session session = sessionFactory.openSession();
       Transaction tx = null;
       Integer switchID = null;
       try{
          tx = session.beginTransaction();
          SwitchTemplate switchTemplate = new SwitchTemplate(switchType, switchName, id, hight,
      			width, depth, energy, location, numberOfPorts);
          switchID = (Integer) session.save(switchTemplate); 
          tx.commit();
       }catch (HibernateException e) {
          if (tx!=null) tx.rollback();
          e.printStackTrace(); 
       }finally {
          session.close(); 
       }
       return switchID;
    }
    
    public static SessionFactory createSessionFactory() {
    	org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();        
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

}
