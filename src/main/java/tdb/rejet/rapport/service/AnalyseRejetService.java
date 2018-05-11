package tdb.rejet.rapport.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import tdb.rejet.rapport.config.ConfigInitializer;
import tdb.rejet.rapport.config.ProjectConfig;
import tdb.rejet.rapport.config.Utils;

public class AnalyseRejetService {
	
	private static final Logger logger = Logger.getLogger(AnalyseRejetService.class);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
	
	List<InfoOffice> getRejectedOfficeCodeList() throws IOException {
		ProjectConfig config = ConfigInitializer.getConfig();
		File directory = new File(config.getRejectDirectory());
    	List<File> fileList = Arrays.stream(directory.listFiles())
    		.filter(p -> p.lastModified() > Utils.getDateTimeFromString(config.getDateDebut()) && p.lastModified() < Utils.getDateTimeFromString(config.getDateFin()) && "txt".equals(FilenameUtils.getExtension(p.getName())))
    		.collect(Collectors.toList()); 
    	List<InfoOffice> codeList = new ArrayList<>();
    	Charset charset = Charset.forName("ISO-8859-1"); 
    	for(File file : fileList) {
    		Path path = file.toPath();
    		String dateRejet = sdf.format(file.lastModified());
    		Files.lines(path, charset).filter(p -> p.contains("CSN"))
    						.forEach(p ->{
    							String[] str = p.split(" ");
    							codeList.add(new InfoOffice(str[20], str[23], dateRejet));
    						});
    	}
    	  logger.info(codeList.size() + " TDB rejetés");
    return codeList;
}
	
	public void generateXlsRejectReport() throws IOException {
		List<InfoOffice> officeCodeList = getRejectedOfficeCodeList();
		if(officeCodeList.isEmpty()) {
			return;
		}
		//Set Header columns
		HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("FirstSheet");  
        HSSFRow rowhead = sheet.createRow((short)0);
        rowhead.createCell(0).setCellValue("Date  du rejet");
        rowhead.createCell(1).setCellValue("Code CSN Transmis");
        rowhead.createCell(2).setCellValue("Code CRPCEN Transmis");
        rowhead.createCell(3).setCellValue("Motif du rejet");
        
        //Set entries
        for(int i =0; i< officeCodeList.size(); i++) {
        	HSSFRow row = sheet.createRow((short) i+1);
        	row.createCell(0).setCellValue(officeCodeList.get(i).getDateRejet());
        	row.createCell(1).setCellValue(officeCodeList.get(i).getCodeCsn());
        	row.createCell(2).setCellValue(officeCodeList.get(i).getCodeCrpcen());
        	row.createCell(3).setCellValue("le couple CSN - CRPCEN n'existe pas dans l'organisation");
        }
     
        FileOutputStream fileOut = new FileOutputStream( ConfigInitializer.getConfig().getOutputFilePath());
        workbook.write(fileOut);
        fileOut.close();
        logger.info("Fichier généré!");
	}

}
