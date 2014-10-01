package springHibernateDemo;

import java.util.List;

import DCDM.SwitchPort;
import DCDM.SwitchTemplate;

public interface SwitchTemplateDao {
	public void insert(SwitchTemplate switchTemplate);

	public List<SwitchTemplate> selectAll();

	public void addPortToSwitch(SwitchTemplate switchTemplate, SwitchPort port);
}
