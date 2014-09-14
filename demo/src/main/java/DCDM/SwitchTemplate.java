package DCDM;

public class SwitchTemplate {
	int switchType;
	int switchName;
	int id = 0;
	int hight; 	// U
	float width;	// inch
	float depth;	// inch
	float energy;
	String location;
	int NumberOfPorts;
	
	public SwitchTemplate() {

	}

	public SwitchTemplate(int switchType, int switchName, int id, int hight,
			float width, float depth, float energy, String location,
			int numberOfPorts) {
		super();
		this.switchType = switchType;
		this.switchName = switchName;
		this.id = id;
		this.hight = hight;
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




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public int getHight() {
		return hight;
	}




	public void setHight(int hight) {
		this.hight = hight;
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
