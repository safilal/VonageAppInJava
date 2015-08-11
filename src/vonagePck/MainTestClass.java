package vonagePck;



import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import TestingPackage.ConnectToVonAPI.CreateSession;

public class MainTestClass {

	public static void main(String[] args) throws UnknownHostException, IOException, SQLException {
	
		CreateSession session = new CreateSession();
		try {
			session.createClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtensionInformation extInfo = new ExtensionInformation();
		try {
			extInfo.extInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		vonLiveStatus vonStatus = new vonLiveStatus();
		try {
			vonStatus.monitorVonStatus();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VonCallHistory vonCallHistory = new VonCallHistory();
		try {
			vonCallHistory.vonCallHistory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}