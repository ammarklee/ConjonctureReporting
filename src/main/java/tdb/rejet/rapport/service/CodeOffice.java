package tdb.rejet.rapport.service;
public class CodeOffice{
	
	String codeCsn;
	String codeCrpcen;
	
	public CodeOffice(String codeCsn, String codeCrpcen) {
		this.codeCsn = codeCsn;
		this.codeCrpcen = codeCrpcen;
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