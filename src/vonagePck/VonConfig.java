package vonagePck;
/*
* The information in this class are meant to be collected from the databse
* then use the getters to get the values when needed in other classes
* For time sake and security, I removed all classes and information about my Database.
* I still kept the method to query these details from the database
* I will put together a database connection and query examples later
* As you can see I am using a nested static class, this makes the events in this class 
* happen only once, which I find more secure and lower the risk opportunities to be hacked
* each time you connect to the Databse and collect this information, 
* you open the door for others to get to your DB  
*/
import java.util.ArrayList;
//import java.util.Properties;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class VonConfig {
	public static class DbQuery{
		
		//These are the paths that Vonage provide in their API documentation
		private String VonApi= "https://my.vonagebusiness.com";
		private String VonAuthPath = "/appserver/rest/user/null";
		private String VonLiveStatusPath = "/presence/dashui?filterExtension=";
		private String VonExtInfoPath = "/presence/rest/extension/";
		private String VonCallHistoryPath = "/presence/rest/callhistory/";
		private String VonCallRecordingPath = "/presence/rest/callrecording/";
		private String VonConferencePath = "/presence/rest/conference/";
		private String VonCallQueuePath = "/presence/rest/queue/";
		private String VonUsername; 
		private String VonPassword;
		private String VonExtension;
		private Statement stmt = null;
		private ResultSet rsults = null;
		
		//ConnectToDB conToDb = new ConnectToDB();
		
		public ArrayList<VonConfig> getLogins(){	
			ArrayList<VonConfig> logins = new ArrayList<VonConfig>();
			String query = "SELECT username, password, extension FROM Users";
			
			try {
				//stmt = ConnectToDB.getConn().createStatement();
				rsults = stmt.executeQuery(query);
				while(rsults.next()){
					VonUsername = rsults.getString("username");
					VonPassword = rsults.getString("password");
					VonExtension =  rsults.getString("extension");
					System.out.println(	VonUsername + ", "
										+ VonPassword + ", "
										+ VonExtension);
				}
				stmt.close();
				rsults.close();
				//ConnectToDB.getConn();
				return logins;
			} catch (SQLException sql){
				//Catch error, store in error array list for email
				StringBuilder error = new StringBuilder();
				error.append(System.getProperty("line.separator"));
				error.append(sql.getMessage());
				error.append(System.getProperty("line.separator"));
				error.append(System.getProperty("line.separator"));
				error.append(System.getProperty("line.separator"));
				error.append(System.getProperty("line.separator"));
			}
			return logins;
		}//end getLogins()
	
	
		//Setter & getters
		public String getVonApi() {
			return VonApi;
		}
		public void setVonApi(String vonApi) {
			VonApi = vonApi;
		}
		public String getVonAuthPath() {
			return VonAuthPath;
		}
		public void setVonAuthPath(String vonAuthPath) {
			VonAuthPath = vonAuthPath;
		}
		public String getVonLiveStatus() {
			return VonLiveStatusPath;
		}
		public void setVonLiveStatus(String vonLiveStatus) {
			VonLiveStatusPath = vonLiveStatus;
		}
		public String getVonExtInfo() {
			return VonExtInfoPath;
		}
		public void setVonExtInfo(String vonExtInfo) {
			VonExtInfoPath = vonExtInfo;
		}
		public String getVonCallHistory() {
			return VonCallHistoryPath;
		}
		public void setVonCallHistory(String vonCallHistory) {
			VonCallHistoryPath = vonCallHistory;
		}
		public String getVonCallRecording() {
			return VonCallRecordingPath;
		}
		public void setVonCallRecording(String vonCallRecording) {
			VonCallRecordingPath = vonCallRecording;
		}
		public String getVonConference() {
			return VonConferencePath;
		}
		public void setVonConference(String vonConference) {
			VonConferencePath = vonConference;
		}
		public String getVonCallQueue() {
			return VonCallQueuePath;
		}
		public void setVonCallQueue(String vonCallQueue) {
			VonCallQueuePath = vonCallQueue;
		}
		public String getVonUsername() {
			return VonUsername;
		}
		public void setVonUsername(String vonUsername) {
			VonUsername = vonUsername;
		}
		public String getVonPassword() {
			return VonPassword;
		}
		public void setVonPassword(String vonPassword) {
			VonPassword = vonPassword;
		}
		public String getVonExtension() {
			return VonExtension;
		}
		public void setVonExtension(String vonExtension) {
			VonExtension = vonExtension;
		}
		//End Setters & getters
		
	}//End DbQuery Class
}//End VonConfig Class
