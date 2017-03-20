package uk.gov.dvla.osg.ackpreafp;

public class VrmArray {
	
	private String vrm, letterDate, sornDate, make, model;

	public String getVrm() {
		return vrm;
	}

	public void setVrm(String vrm) {
		this.vrm = vrm;
	}

	public String getLetterDate() {
		return letterDate;
	}

	public void setLetterDate(String letterDate) {
		this.letterDate = letterDate;
	}

	public String getSornDate() {
		return sornDate;
	}

	public void setSornDate(String sornDate) {
		this.sornDate = sornDate;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString(){
		return vrm + ":" + sornDate + ":" + letterDate + ":" + make + ":" + model;
	}
}
