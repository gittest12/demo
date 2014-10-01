package springHibernateDemo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import DCDM.SwitchPort;
import DCDM.SwitchTemplate;

public class SwitchTemplateDaoImpl /*extends HibernateDaoSupport*/ implements SwitchTemplateDao{
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void insert(SwitchTemplate switchTemplate){
//		sessionFactory.getCurrentSession().save(switchTemplate);
		Transaction trans = sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(switchTemplate);
		trans.commit();	
	}

	public List<SwitchTemplate> selectAll(){
//		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SwitchTemplate.class);
//		sessionFactory.getCurrentSession().
//		DetachedCriteria criteria = DetachedCriteria.forClass(SwitchTemplate.class);
//		return (List<SwitchTemplate>) getHibernateTemplate().findByCriteria(criteria);
		Transaction trans = sessionFactory.getCurrentSession().beginTransaction();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SwitchTemplate.class);
		List<SwitchTemplate> switches = (List<SwitchTemplate>) criteria.list();
		trans.commit();	
		return switches;
	}

	public void addPortToSwitch(SwitchTemplate switchTemplate, SwitchPort port){
		port.setSwitchTemplate(switchTemplate);
//		sessionFactory.getCurrentSession().save(port);
		Transaction trans = sessionFactory.getCurrentSession().beginTransaction();
		sessionFactory.getCurrentSession().save(port);
		trans.commit();	
	}
	
}
