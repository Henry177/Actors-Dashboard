package MainProvider;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONObject;

import XMLToJSONBuilders.JenkinsXMLToJSON;
import bbd.dashboard.Log;

public class JSONProvider 
{	
	public static void main(String[] args) throws ParserConfigurationException, IOException
	{
		Log.logToFile = false;
		Log.infoEnabled = true;
		System.out.println(GetJSON());
	}
	
	public static JSONObject GetJSON() throws ParserConfigurationException, IOException 
	{
		return JenkinsXMLToJSON.GetJenkinsJSON();
	}
}