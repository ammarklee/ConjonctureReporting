package tdb.rejet.rapport.service;
public class InfoOffice{
	
	String codeCsn;
	String codeCrpcen;
	String dateRejet;
	
	public String getDateRejet() {
		return dateRejet;
	}
	public void setDateRejet(String dateRejet) {
		this.dateRejet = dateRejet;
	}
	public InfoOffice(String codeCsn, String codeCrpcen, String dateRejet) {
		this.codeCsn = codeCsn;
		this.codeCrpcen = codeCrpcen;
		this.dateRejet =dateRejet;
	}
	public String getCodeCsn() {
		return codeCsn;
	}
	public void setCodeCsn(String codeCsn) {
		this.codeCsn = codeCsn;
	}
	public String getCodeCrpcen() {
		return codeCrpcen;
	}
	public void setCodeCrpcen(String codeCrpcen) {
		this.codeCrpcen = codeCrpcen;
	}
	
}