package DCDM;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "SWITCH_TEMPLATE")
public class SwitchTemplate {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "switch_id")
	long id;	
	@Column(name = "switch_type")
	int switchType;
	@Column(name = "switch_name")
	int switchName;
	@Column(name = "height")
	float height; 	// U
	@Column(name = "width")
	float width;	// inch
	@Column(name = "depth")
	float depth;	// inch
	@Column(name = "energy")
	float energy;
	@Column(name = "location")
	String location;
	@Column(name = "number_of_ports")
	int numberOfPorts;
	@Column(name = "port_naming_convention")
	String portNamingConvention;
	
    @OneToMany(fetch = FetchType.LAZY, mappedBy="switchTemplate",orphanRemoval=true)
    private Set<SwitchPort> ports = new HashSet<SwitchPort>();

	
	// setting def value if adding a new column to existing table
//	@Column(name = "port_naming", nullable = false, columnDefinition = "varchar(255) default 'xxxzzzunknown'")
//	String PortNaming;

	public SwitchTemplate() {

	}




	public SwitchTemplate(int switchType, int switchName, float height,
			float width, float depth, float energy, String location,
			int numberOfPorts, String portNamingConvention) {
		super();
		this.switchType = switchType;
		this.switchName = switchName;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.energy = energy;
		this.location = location;
		this.numberOfPorts = numberOfPorts;
		this.portNamingConvention = portNamingConvention;
	}

	public void printSwitch(){
		System.out.println("id = "+id+"switchType = "+switchType+ " switchName = "+switchName+ " height = "+height+
				" width = "+width+" depth = "+depth+" energy = "+energy+" location = "+location+
				" numberOfPorts = "+numberOfPorts+" portNamingConvention = "+portNamingConvention);
	}
	public String getPortNamingConvention() {
		return portNamingConvention;
	}

	public Set<SwitchPort> getPorts() {
		return ports;
	}




	public void setPorts(Set<SwitchPort> ports) {
		this.ports = ports;
	}




	public void setPortNamingConvention(String portNamingConvention) {
		this.portNamingConvention = portNamingConvention;
	}


	public int getSwitchType() {
		return switchType;
	}




	public void setSwitchType(int switchType) {
		this.switchType = switchType;
	}




	public int getSwitchName() {
		return switchName;
	}




	public void setSwitchName(int switchName) {
		this.switchName = switchName;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getHeight() {
		return height;
	}




	public void setHeight(float height) {
		this.height = height;
	}




	public float getWidth() {
		return width;
	}




	public void setWidth(float width) {
		this.width = width;
	}




	public float getDepth() {
		return depth;
	}




	public void setDepth(float depth) {
		this.depth = depth;
	}




	public float getEnergy() {
		return energy;
	}




	public void setEnergy(float energy) {
		this.energy = energy;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public int getNumberOfPorts() {
		return numberOfPorts;
	}




	public void setNumberOfPorts(int numberOfPorts) {
		this.numberOfPorts = numberOfPorts;
	}


}
