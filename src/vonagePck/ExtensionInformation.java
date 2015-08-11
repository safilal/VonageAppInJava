package vonagePck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import TestingPackage.VonConfig.DbQuery;
import TestingPackage.ConnectToVonAPI.CreateSession;

public class ExtensionInformation {
	DbQuery vonSettings = new DbQuery();
	private String urlDomain = vonSettings.getVonApi();
	private String extInfo = vonSettings.getVonExtInfo();
	CreateSession vonClient = new CreateSession();
	private URLConnection connection = vonClient.getConnection();
	private InputStream response;
	private String extension = "830"; // pass in your extension
	
	
	public void extInfo(){
			
			try {
				connection = new URL(urlDomain + extInfo + extension).openConnection();
				response = connection.getInputStream();
				BufferedReader responseContent = new BufferedReader(new InputStreamReader(response));
				String inputLine;
				while ((inputLine = responseContent.readLine()) != null) 
					System.out.println(inputLine);
				responseContent.close();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
					
		}
}	