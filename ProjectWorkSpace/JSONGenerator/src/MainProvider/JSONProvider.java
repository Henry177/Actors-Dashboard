package MainProvider;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.JSONObject;

import GeneratorDataProvider.JSONSourceObject;
import GeneratorDataProvider.PathProvider;
import XMLToJSONBuilders.JenkinsXMLToJSON;

public class JSONProvider 
{	
	public static void main(String[] args) throws ParserConfigurationException, IOException
	{
		System.out.println(GetJSONFor(JSONSourceObject.JenkinsCore));
	}
	
	public static JSONObject GetJSONFor(JSONSourceObject JSONSourceName) throws ParserConfigurationException, IOException 
	{
		switch (JSONSourceName) 
		{
		case JenkinsCore:
		{
			return JenkinsCoreJSON()
		}
		default:
			return null;
		}
	}
	
	private static JSONObject JenkinsCoreJSON() throws ParserConfigurationException, IOException
	{
		return JenkinsXMLToJSON.GetJenkinsCoreJSON(PathProvider.JenkinsCoreXMLURL);
	}
}