package tdb.rejet.rapport.config;

public class ProjectConfig {
	
	 private String rejectDirectory;
	 private String dateDebut;
     private String dateFin;
     private String outputFilePath;

     public String getRejectDirectory() {
 		return rejectDirectory;
 	}
 	public void setRejectDirectory(String rejectDirectory) {
 		this.rejectDirectory = rejectDirectory;
 	}
 	public String getDateDebut() {
 		return dateDebut;
 	}
 	public void setDateDebut(String dateDebut) {
 		this.dateDebut = dateDebut;
 	}
 	public String getDateFin() {
 		return dateFin;
 	}
 	public void setDateFin(String dateFin) {
 		this.dateFin = dateFin;
 	}
 	public String getOutputFilePath() {
 		return outputFilePath;
 	}
 	public void setOutputFilePath(String outputFilePath) {
 		this.outputFilePath = outputFilePath;
 	}
}
