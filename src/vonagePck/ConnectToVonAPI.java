package vonagePck;


/*
*	Developer: Souhail Afilal
*	In this class, we connect to Vonage REST API using URLConnection
*	We get the cookie and make them available for other following request
*	Such As Live Status, History and Extension's Information (See the other classes)
*/
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import TestingPackage.VonConfig.DbQuery;

    

public class ConnectToVonAPI{
	public static class CreateSession{
		
		DbQuery vonSettings = new DbQuery();
		private CookieManager cookieManager = new CookieManager(null, CookiePolicy.ACCEPT_ALL);
		private String urlDomain = vonSettings.getVonApi();
		private String urlAuth = vonSettings.getVonAuthPath();
		private String username = "your username";
		private String password = "your password??";
		private String charset = "UTF-8";
		private URLConnection connection;

		
		public void createClient() throws Exception {
			CookieHandler.setDefault(cookieManager);
			String queryAuth = String.format("htmlLogin=%s&htmlPassword=%s",
					URLEncoder.encode(username, charset),
					URLEncoder.encode(password, charset));
			try{
			connection= new URL(urlDomain + urlAuth + "?" + queryAuth).openConnection();
			List<String> cookies = connection.getHeaderFields().get("Set-Cookie");
			
			for (String cookie : cookies) {
			    connection.addRequestProperty("Cookie", cookie.split(";", 2)[0]);
			}
			}catch (Exception e){
				//Catch error, store in error array list for email
				StringBuilder error = new StringBuilder();
				error.append(System.getProperty("line.separator"));
				error.append(e.getMessage());
				error.append(System.getProperty("line.separator"));
				error.append(System.getProperty("line.separator"));
				error.append(System.getProperty("line.separator"));
				error.append(System.getProperty("line.separator"));
			}
		}
		/* we are going to use these getters and setters when 
		*  sending other requests in other classes
		*/
		public URLConnection getConnection() {
			return connection;
		}

		public void setConnection(URLConnection connection) {
			this.connection = connection;
		}
			
	}
}


