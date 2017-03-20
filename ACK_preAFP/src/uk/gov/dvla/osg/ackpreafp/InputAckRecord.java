package uk.gov.dvla.osg.ackpreafp;

public class InputAckRecord implements Comparable<InputAckRecord> {
	
	private String ott, vrm, titleCode, name1, name2, add1, add2, add3, add4, add5, pc,
	fleetNo, letterDate, sornDate, unknown1, unknown2, unknown3, make, model;

	@Override
	public String toString(){
		String delim = "" + (char)Integer.parseInt("1A",16);
		return 	ott + delim +
				vrm + delim +
				titleCode + delim +
				name1 + delim +
				name2 + delim +
				add1 + delim +
				add2 + delim +
				add3 + delim +
				add4 + delim +
				add5 + delim +
				pc + delim +
				fleetNo + delim +
				letterDate + delim +
				sornDate + delim +
				unknown1 + delim +
				unknown2 + delim +
				unknown3 + delim +
				make + delim +
				model + delim;
	}
	
	public String print(){
		String delim = "|";
		String result = String.format("%-3.3s" + delim + "%-10.10s" + delim + "%-16.16s" + delim +
				"%-6.6s" + delim + "%-10.10s" + delim + "%-60.60s" + delim + "%-60.60s" + delim +
				"%-35.35s" + delim + "%-35.35s" + delim + "%-35.35s" + delim + "%-35.35s" + delim + 
				"%-35.35s" + delim + "%-8.8s" + delim + "%-10.10s" + delim + "%-10.10s" + delim + 
				"%-6.6s" + delim + "%-8.8s" + delim + "%-1.1s" + delim,
				ott,"","",fleetNo,titleCode,name1,name2,add1,add2,add3,add4,add5,pc,"","","","","");
		
		return result;
	}
	
	public String getOtt() {
		return ott;
	}

	public void setOtt(String ott) {
		this.ott = ott;
	}

	public String getVrm() {
		return vrm;
	}

	public void setVrm(String vrm) {
		this.vrm = vrm;
	}

	public String getTitleCode() {
		return titleCode;
	}

	public void setTitleCode(String titleCode) {
		this.titleCode = titleCode;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getAdd3() {
		return add3;
	}

	public void setAdd3(String add3) {
		this.add3 = add3;
	}

	public String getAdd4() {
		return add4;
	}

	public void setAdd4(String add4) {
		this.add4 = add4;
	}

	public String getAdd5() {
		return add5;
	}

	public void setAdd5(String add5) {
		this.add5 = add5;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public String getFleetNo() {
		return fleetNo;
	}

	public void setFleetNo(String fleetNo) {
		this.fleetNo = fleetNo;
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

	public String getUnknown1() {
		return unknown1;
	}

	public void setUnknown1(String unknown1) {
		this.unknown1 = unknown1;
	}

	public String getUnknown2() {
		return unknown2;
	}

	public void setUnknown2(String unknown2) {
		this.unknown2 = unknown2;
	}

	public String getUnknown3() {
		return unknown3;
	}

	public void setUnknown3(String unknown3) {
		this.unknown3 = unknown3;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((add1 == null) ? 0 : add1.hashCode());
		result = prime * result + ((add2 == null) ? 0 : add2.hashCode());
		result = prime * result + ((add3 == null) ? 0 : add3.hashCode());
		result = prime * result + ((add4 == null) ? 0 : add4.hashCode());
		result = prime * result + ((add5 == null) ? 0 : add5.hashCode());
		result = prime * result + ((fleetNo == null) ? 0 : fleetNo.hashCode());
		result = prime * result + ((name1 == null) ? 0 : name1.hashCode());
		result = prime * result + ((name2 == null) ? 0 : name2.hashCode());
		result = prime * result + ((ott == null) ? 0 : ott.hashCode());
		result = prime * result + ((pc == null) ? 0 : pc.hashCode());
		result = prime * result
				+ ((titleCode == null) ? 0 : titleCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InputAckRecord other = (InputAckRecord) obj;
		if (add1 == null) {
			if (other.add1 != null)
				return false;
		} else if (!add1.equals(other.add1))
			return false;
		if (add2 == null) {
			if (other.add2 != null)
				return false;
		} else if (!add2.equals(other.add2))
			return false;
		if (add3 == null) {
			if (other.add3 != null)
				return false;
		} else if (!add3.equals(other.add3))
			return false;
		if (add4 == null) {
			if (other.add4 != null)
				return false;
		} else if (!add4.equals(other.add4))
			return false;
		if (add5 == null) {
			if (other.add5 != null)
				return false;
		} else if (!add5.equals(other.add5))
			return false;
		if (fleetNo == null) {
			if (other.fleetNo != null)
				return false;
		} else if (!fleetNo.equals(other.fleetNo))
			return false;
		if (name1 == null) {
			if (other.name1 != null)
				return false;
		} else if (!name1.equals(other.name1))
			return false;
		if (name2 == null) {
			if (other.name2 != null)
				return false;
		} else if (!name2.equals(other.name2))
			return false;
		if (ott == null) {
			if (other.ott != null)
				return false;
		} else if (!ott.equals(other.ott))
			return false;
		if (pc == null) {
			if (other.pc != null)
				return false;
		} else if (!pc.equals(other.pc))
			return false;
		if (titleCode == null) {
			if (other.titleCode != null)
				return false;
		} else if (!titleCode.equals(other.titleCode))
			return false;
		return true;
	}

	@Override
	public int compareTo(InputAckRecord o) {

        int add1diff = add1.compareToIgnoreCase(o.add1);
        if(add1diff != 0){
            return add1diff;
        }
        int add2diff = add2.compareToIgnoreCase(o.add2);
        if(add2diff != 0){
            return add2diff;
        }
        int add3diff = add3.compareToIgnoreCase(o.add3);
        if(add3diff != 0){
            return add3diff;
        }
        int add4diff = add4.compareToIgnoreCase(o.add4);
        if(add4diff != 0){
            return add4diff;
        }
        int add5diff = add5.compareToIgnoreCase(o.add5);
        if(add5diff != 0){
            return add5diff;
        }
        int fleetNodiff = fleetNo.compareToIgnoreCase(o.fleetNo);
        if(fleetNodiff != 0){
            return fleetNodiff;
        }
        int name1diff = name1.compareToIgnoreCase(o.name1);
        if(name1diff != 0){
            return name1diff;
        }
        int name2diff = name2.compareToIgnoreCase(o.name2);
        if(name2diff != 0){
            return name2diff;
        }
        int ottdiff = ott.compareToIgnoreCase(o.ott);
        if(ottdiff != 0){
            return ottdiff;
        }
        int pcdiff = pc.compareToIgnoreCase(o.pc);
        if(pcdiff != 0){
            return pcdiff;
        }
        int titleCodediff = titleCode.compareToIgnoreCase(o.titleCode);

        return titleCodediff;
        
		
	}



}
