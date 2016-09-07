package XMLToJSONBuilders;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import GeneratorDataProvider.PathProvider;
import bbd.dashboard.Log;

public class JenkinsXMLToJSON
{
	private static URL url;
	private static URLConnection connection;
	private static DocumentBuilderFactory dbFactory;
	private static DocumentBuilder dBuidler;
	private static Document doc;
	private static JSONObject jObj;
	
	private static void resetObjects(String path) throws IOException, ParserConfigurationException
	{
		url = new URL(path);
		connection = url.openConnection();
		dbFactory = DocumentBuilderFactory.newInstance();
		dBuidler = dbFactory.newDocumentBuilder();
		doc = null;		
	}
	
	public static JSONObject GetJenkinsJSON() throws ParserConfigurationException, IOException
	{	
		jObj = new JSONObject();
		
		for(String path : PathProvider.JenkinsPaths)
		{			
			GetXML(path);
			NodeList jobs = doc.getElementsByTagName("job");
			getJSONFromXML(jobs, path);
		}
		
		return jObj;
	}
	
	private static void GetXML(String path) throws IOException, ParserConfigurationException
	{
		path = path.replace("/:", ":");
		
		resetObjects(path);
		
		try 
		{
			doc = dBuidler.parse(connection.getInputStream());
			doc.getDocumentElement().normalize();
		} 
		catch (SAXException e)
		{
			Log.error(e);
		} 
		catch (IOException e) 
		{
			Log.error(e);
		}	
	}

	@SuppressWarnings({ "unchecked" })
	private static void getJSONFromXML(NodeList jobs, String env) throws IOException, ParserConfigurationException
	{	
		if(jobs != null)
		{
			for (int i = 0; i < jobs.getLength(); i++)
			{
				Element currJob = (Element) jobs.item(i);
				
				String currJobName = currJob.getElementsByTagName("name").item(0).getTextContent();					
				String currJobURL = currJob.getElementsByTagName("url").item(0).getTextContent();				
				String jobColor = currJob.getElementsByTagName("color").item(0).getTextContent();
				
				GetXML(currJobURL + "api/xml");
				NodeList builds = doc.getElementsByTagName("build");
				
				JSONObject jobObject = new JSONObject();
				
				jobObject.put("Name", currJobName);
				jobObject.put("Color", jobColor);
				
				if(builds.getLength() > 0)
				{
					Element thisBuild = (Element) builds.item(0);
					String buildURL = thisBuild.getElementsByTagName("url").item(0).getTextContent();
					
					GetXML(buildURL + "api/xml");						
					
					jobObject.put("Building", GetItemValue("building"));
					jobObject.put("Number", GetItemValue("number"));
					jobObject.put("Result", GetItemValue("result"));
				}
				else
					AddBlankObject(jobObject);

				jObj.put(currJobName, jobObject);
			}
		}
		else
		{
			jObj.put("error", "failed to connect to " + env);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static void AddBlankObject(JSONObject jobObject)
	{
		jobObject.put("Building", "");
		jobObject.put("Number", "");
		jobObject.put("Result", "");
	}
	
	private static String GetItemValue(String name)
	{
		NodeList list = doc.getElementsByTagName(name);
		if(list != null && list.item(0) != null)
		{
			return list.item(0).getTextContent();
		}
		else
		{
			return "";
		}
	}
}