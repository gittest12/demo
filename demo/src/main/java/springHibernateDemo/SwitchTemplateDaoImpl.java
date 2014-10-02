package springHibernateDemo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import DCDM.SwitchPort;
import DCDM.SwitchTemplate;

public class SwitchTemplateDaoImpl implements SwitchTemplateDao{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insert(SwitchTemplate switchTemplate){
		Transaction trans = sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(switchTemplate);
		trans.commit();	
	}

	public List<SwitchTemplate> selectAll(){
		Transaction trans = sessionFactory.getCurrentSession().beginTransaction();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SwitchTemplate.class);
		List<SwitchTemplate> switches = (List<SwitchTemplate>) criteria.list();
		trans.commit();	
		return switches;
	}

	public void addPortToSwitch(SwitchTemplate switchTemplate, SwitchPort port){
		port.setSwitchTemplate(switchTemplate);
		Transaction trans = sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(port);
		trans.commit();	
	}
	
}
