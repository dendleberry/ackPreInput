package uk.gov.dvla.osg.ackpreafp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	//Define logger
	private static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {
		LOGGER.info("Starting uk.gov.dvla.osg.ackpreafp.Main");
		
		//Will be args
		String fileName = args[0];
		String output = args[1];
		
		//Will be props
		String equalityFieldIndexes = "";
		String inputDelimitter = "\\x1a";
		int arrayMax=400;
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			List<InputAckRecord> ackRecords = new ArrayList<InputAckRecord>();
			String line;
			while ((line = br.readLine()) != null) {
				String[] part = line.split(inputDelimitter, -1);
				InputAckRecord ar = new InputAckRecord();
				ar.setOtt(part[0].trim());
				ar.setVrm(part[1].trim());
				ar.setTitleCode(part[2].trim());
				ar.setName1(part[3].trim());
				ar.setName2(part[4].trim());
				ar.setAdd1(part[5].trim());
				ar.setAdd2(part[6].trim());
				ar.setAdd3(part[7].trim());
				ar.setAdd4(part[8].trim());
				ar.setAdd5(part[9].trim());
				ar.setPc(part[10].trim());
				ar.setFleetNo(part[11].trim());
				ar.setLetterDate(part[12].trim());
				ar.setSornDate(part[13].trim());
				ar.setUnknown1(part[14].trim());
				ar.setUnknown2(part[15].trim());
				ar.setUnknown3(part[16].trim());
				ar.setMake(part[17].trim());
				ar.setModel(part[18].trim());
				ackRecords.add(ar);
			}
			
			Collections.sort(ackRecords);
			
			int j =0;
			InputAckRecord current,next;
			OutputAckRecord oar;
			
			List<OutputAckRecord> outputArray = new ArrayList<OutputAckRecord>();
			VrmArray vrms;
			List<VrmArray> array = null;
			
			for( int i =0; i < ackRecords.size(); i++ ){
				
				if( i==0 ){
					array = new ArrayList<VrmArray>();
				}
				
				j = i + 1;
				vrms = new VrmArray();
				current = ackRecords.get(i);
				
				vrms.setVrm(current.getVrm());
				vrms.setMake(current.getMake());
				vrms.setModel(current.getModel());
				vrms.setLetterDate(current.getLetterDate());
				vrms.setSornDate(current.getSornDate());
				array.add(vrms);
				
				try{
					next = ackRecords.get(j);
					if( !(current.equals(next)) || !("".equals(current.getFleetNo().trim() ) ) ){
						oar = new OutputAckRecord();
						oar.setFleetNo(current.getFleetNo());
						oar.setVrmArray(array);
						oar.setOtt(current.getOtt());
						oar.setOutputOtt(current.getOtt());
						oar.setTitleCode(current.getTitleCode());
						oar.setName1(current.getName1());
						oar.setName2(current.getName2());
						oar.setAdd1(current.getAdd1());
						oar.setAdd2(current.getAdd2());
						oar.setAdd3(current.getAdd3());
						oar.setAdd4(current.getAdd4());
						oar.setAdd5(current.getAdd5());
						oar.setPc(current.getPc());
						
						outputArray.add(oar);
						array = new ArrayList<VrmArray>();
					}
				}catch (IndexOutOfBoundsException e){
					LOGGER.info("Last record, i = {}",i);
					oar = new OutputAckRecord();
					oar.setFleetNo(current.getFleetNo());
					oar.setVrmArray(array);
					oar.setOtt(current.getOtt());
					oar.setOutputOtt(current.getOtt());
					oar.setTitleCode(current.getTitleCode());
					oar.setName1(current.getName1());
					oar.setName2(current.getName2());
					oar.setAdd1(current.getAdd1());
					oar.setAdd2(current.getAdd2());
					oar.setAdd3(current.getAdd3());
					oar.setAdd4(current.getAdd4());
					oar.setAdd5(current.getAdd5());
					oar.setPc(current.getPc());
					
					outputArray.add(oar);
					array = new ArrayList<VrmArray>();
				}
			}

			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(output,false)));
			
			for(OutputAckRecord out : outputArray){
				pw.println(out);
			}
			
			pw.close();
			


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
