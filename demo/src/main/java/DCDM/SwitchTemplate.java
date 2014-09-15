package DCDM;

import javax.persistence.*;

@Entity
@Table(name = "SWITCH_TEMPLATE")
public class SwitchTemplate {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
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
	@Column(name = "Number_of_ports")
	int NumberOfPorts;

	public SwitchTemplate() {

	}

	public SwitchTemplate(int switchType, int switchName, float height,
			float width, float depth, float energy, String location,
			int numberOfPorts) {
		super();
		this.switchType = switchType;
		this.switchName = switchName;
		this.height = height;
		this.width = width;
		this.depth = depth;
		this.energy = energy;
		this.location = location;
		NumberOfPorts = numberOfPorts;
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
		return NumberOfPorts;
	}




	public void setNumberOfPorts(int numberOfPorts) {
		NumberOfPorts = numberOfPorts;
	}

	//	•	Switch Type:  (e.g., SAN or Data)
	//	•	Switch Name: (e.g., Brocade 8000)0
	//	•	Switch ID Number:
	//	•	Dimensions of Switch:
	//	o	Height of Switch (in U’s)
	//	o	Width of Switch (in Inches)
	//	o	Depth of Switch (in Inches)
	//	•	Switch Energy requirements:
	//	•	Switch Location:
	//	•	Number of Ports (total):

}
