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
	
	public static JSONObject GetJenkinsCoreJSON(String path) throws ParserConfigurationException, IOException
	{	
		jObj = new JSONObject();
		
		GetXML(path);

		NodeList jobs = doc.getElementsByTagName("job");

		return getCoreJSONFromXML(jobs);
	}
	
	private static void GetXML(String path) throws IOException, ParserConfigurationException
	{
		resetObjects(path);
		
		try 
		{
			doc = dBuidler.parse(connection.getInputStream());
			doc.getDocumentElement().normalize();
		} 
		catch (SAXException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}

	@SuppressWarnings({ "unchecked" })
	private static JSONObject getCoreJSONFromXML(NodeList jobs) throws IOException, ParserConfigurationException
	{	
		if(jobs != null)
		{
			for (int i = 0; i < jobs.getLength(); i++)
			{
				Element currJob = (Element) jobs.item(i);
				
				String currJobName = currJob.getElementsByTagName("name").item(0).getTextContent();	
				
				String currJobURL = currJob.getElementsByTagName("url").item(0).getTextContent();
				
				GetXML(currJobURL + "api/xml");
				NodeList builds = doc.getElementsByTagName("build");
				Element thisBuild = (Element) builds.item(0);
				String buildURL = thisBuild.getElementsByTagName("url").item(0).getTextContent();
				
				GetXML(buildURL + "api/xml");
				
				JSONObject jobObject = new JSONObject();
				
				NodeList tmp = doc.getElementsByTagName("building");
				if((tmp != null) && (tmp.item(0) != null))
					jobObject.put("Building", tmp.item(0).getTextContent());
				
				tmp = doc.getElementsByTagName("estimatedDuration");
				if((tmp != null) && (tmp.item(0) != null))
					jobObject.put("EstimatedDuration", tmp.item(0).getTextContent());
				
				tmp = doc.getElementsByTagName("number");
				if((tmp != null) && (tmp.item(0) != null))
					jobObject.put("Number", tmp.item(0).getTextContent());
				
				tmp = doc.getElementsByTagName("result");
				if((tmp != null) && (tmp.item(0) != null))
					jobObject.put("Result", tmp.item(0).getTextContent());
				
				tmp = doc.getElementsByTagName("timestamp");
				if((tmp != null) && (tmp.item(0) != null))
					jobObject.put("Timestamp", tmp.item(0).getTextContent());
		
				jobObject.put("Name", currJobName);
				
				jObj.put(currJobName, jobObject);
			}
		}
		else
		{
			jObj.put("error", "failed to connect to Jenkins");
		}
		
		return jObj;
	}
}