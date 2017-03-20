package uk.gov.dvla.osg.ackpreafp;

import java.util.ArrayList;
import java.util.List;

public class OutputAckRecord {
	
	private String ott, outOtt, titleCode, name1, name2, add1, add2, add3, add4, add5, pc, fleetNo, langFlag, type;
	private List<VrmArray> vrmArray;

	public String getOtt() {
		return ott;
	}

	public void setOtt(String ott) {
		this.ott = ott;
	}
	
	public String getOutputOtt(){
		return outOtt;
	}
	
	public void setOutputOtt(String ott){
		String result = ott;
		if( !(this.fleetNo.isEmpty()) ){
			if( "371".equalsIgnoreCase(ott) ){
				result ="373";
			}
			if( "372".equalsIgnoreCase(ott) ){
				result ="373";
			}
			if( "373".equalsIgnoreCase(ott) ){
				result ="374";
			}
			if( "374".equalsIgnoreCase(ott) ){
				result ="374";
			}
		} else{
			if(vrmArray.size() == 1){
				if( "371".equalsIgnoreCase(ott) ){
					result ="371";
				}
				if( "372".equalsIgnoreCase(ott) ){
					result ="371";
				}
				if( "373".equalsIgnoreCase(ott) ){
					result ="372";
				}
				if( "374".equalsIgnoreCase(ott) ){
					result ="372";
				}
			}else{
				if( "371".equalsIgnoreCase(ott) ){
					result ="373";
				}
				if( "372".equalsIgnoreCase(ott) ){
					result ="373";
				}
				if( "373".equalsIgnoreCase(ott) ){
					result ="374";
				}
				if( "374".equalsIgnoreCase(ott) ){
					result ="374";
				}
			}
			
		}
		this.outOtt = result;
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

	public String getLangFlag() {
		if( ("371".equals(ott)) || ("372".equals(ott)) ){
			langFlag="E";
		}else{
			langFlag="W";
		}
		return langFlag;
	}

	public String getType() {
		switch (ott){
			case "371": type = "V955";
			break;
			case "372": type = "V956";
			break;
			case "373": type = "V955W";
			break;
			case "374": type = "V956W";
			break;
		}
		return type;
	}

	public List<VrmArray> getVrmArray() {
		return vrmArray;
	}

	public void setVrmArray(List<VrmArray> vrmArray) {
		this.vrmArray = new ArrayList<VrmArray>();
		this.vrmArray = vrmArray;
	}
	
	@Override
	public String toString(){
		String out ="";
		String delim = "|";
		
		

		for(VrmArray str : this.vrmArray){
			out = out + str.toString() + ";";
		}
		if(out.length()>0){
			out = out.substring(0, out.length()-1);
		}

		String result = String.format("%-3.3s" + delim + "%-10.10s" + delim + "%-6.6s" + delim + 
				"%-10.10s" + delim + "%-60.60s" + delim + "%-60.60s" + delim + "%-35.35s" + delim +
				"%-35.35s" + delim + "%-35.35s" + delim + "%-35.35s" + delim + "%-35.35s" + delim + 
				"%-8.8s",
				outOtt,vrmArray.get(0).getVrm(),fleetNo,titleCode,name1,name2,add1,add2,add3,add4,add5,pc) +
				delim + getLangFlag() + delim + out + delim + vrmArray.size() + delim + getType() + delim;
		
		return result;
	}

}
