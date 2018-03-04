package tdb.rejet.rapport.config;

public enum ConfigEnum {
	
	DATE_DEBUT("rejet.dateDebut"),
	DATE_FIN("rejet.dateFin"),
	REJECT_DIRECTORY("rejet.directory"),
	OUT_PUT_FILE_PATH("rejet.output.fileName");
	
	private String key;
	

	ConfigEnum(String key) {
		this.key = key;
	}
	
	String getKey() {
		return key;
	}
}
