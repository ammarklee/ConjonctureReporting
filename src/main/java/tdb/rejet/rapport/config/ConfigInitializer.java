package tdb.rejet.rapport.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;



public class ConfigInitializer {
	
	private static final Logger logger = Logger.getLogger(ConfigInitializer.class);
	
	private static ProjectConfig config = null;
	
	final static ProjectConfig setConfig() {
		Properties properties = new Properties();
        FileInputStream input = null;
		try {
			input = new FileInputStream("D:\\Conjoncture\\conf\\conjoncture.properties");
			properties.load(input);
		} catch (FileNotFoundException e) {
			logger.fatal(e.getMessage());
		} catch (IOException e) {
			logger.fatal(e.getMessage());
		}
       
        config = new ProjectConfig();
        config.setDateDebut(properties.getProperty(ConfigEnum.DATE_DEBUT.getKey()));
        config.setDateFin(properties.getProperty(ConfigEnum.DATE_FIN.getKey()));
        config.setRejectDirectory(properties.getProperty(ConfigEnum.REJECT_DIRECTORY.getKey()));
        config.setOutputFilePath(properties.getProperty(ConfigEnum.OUT_PUT_FILE_PATH.getKey()));
        return config;
		
	}
	
	
	public final static ProjectConfig getConfig() {
		if (config == null) {
			return setConfig();
		} else {
			return config; 
		}
	} 

}
