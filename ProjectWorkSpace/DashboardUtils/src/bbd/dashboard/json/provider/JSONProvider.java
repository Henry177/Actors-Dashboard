package bbd.dashboard.json.provider;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONObject;

import bbd.dashboard.json.xmltojson.JenkinsXMLToJSON;

public class JSONProvider 
{	
	public static JSONObject GetJSON() throws ParserConfigurationException, IOException 
	{
		return JenkinsXMLToJSON.GetJenkinsJSON();
	}
}