package DCDM;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SWITCH_PORT")
public class SwitchPort {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "port_id")
	long id;	
	
	@Column(name = "port_type")
	String type;
	
	@Column(name = "port_number")
	int number;

	@ManyToOne
    @JoinColumn(name="switch_id")
    private SwitchTemplate switchTemplate;	
	
	public SwitchPort() {

	}

	public SwitchPort(String type, int number) {
		super();
		this.type = type;
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public SwitchTemplate getSwitchTemplate() {
		return switchTemplate;
	}

	public void setSwitchTemplate(SwitchTemplate switchTemplate) {
		this.switchTemplate = switchTemplate;
	}

	
	
	
	
}
