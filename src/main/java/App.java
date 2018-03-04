
import java.io.IOException;
import tdb.rejet.rapport.service.AnalyseRejetService;


/**
 * Main class
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        AnalyseRejetService service = new AnalyseRejetService();
        service.generateXlsRejectReport();
    }
}


