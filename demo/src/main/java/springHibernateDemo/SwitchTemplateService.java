package springHibernateDemo;

import java.util.List;

import DCDM.SwitchTemplate;


public class SwitchTemplateService {

	private SwitchTemplateDaoImpl switchDao;


	public SwitchTemplateDaoImpl getSwitchDao() {
		return switchDao;
	}

	public void setSwitchDao(SwitchTemplateDaoImpl switchDao) {
		this.switchDao = switchDao;
	}

	public SwitchTemplateDaoImpl getSwitchTemplateDao() {
		return switchDao;
	}


	public void addSwitchTemplate(SwitchTemplate switchTemplate) {
		getSwitchDao().insert(switchTemplate);
	}

	public List<SwitchTemplate> fetchAllSwitches() {
		return getSwitchDao().selectAll();
	}
}
