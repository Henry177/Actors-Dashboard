package src.bbd.dashboard.webservice;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import bbd.dashboard.DashboardUtils;
import src.bbd.dashboard.dto.MSBuildDTO;

import src.bbd.dashboard.dto.EnvironmentDTO;
import src.bbd.dashboard.dto.MSBuildDTO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.reflect.TypeToken;



public class ConfigServlet extends HttpServlet implements ServletConstants{
	
	private Type mapType = new TypeToken<Map<String, ArrayList>>(){}.getType();
	private ArrayList <String> list;
	private Map<String, ArrayList<String>> data;
	
	public ConfigServlet()
	{
		list = new ArrayList<String>();
		//data = new HashMap<String, ArrayList>();
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException	
	{
		data = DashboardUtils.readJsonFile(CONFIG_FILE, mapType);
		if(data == null)
		{
			data = new HashMap<String, ArrayList<String>>();
			Type mapTypems = new TypeToken<Map<String, MSBuildDTO>>(){}.getType();
			Map <String,MSBuildDTO> msbuild = DashboardUtils.readJsonFile(MSBUILD_FILE, mapTypems);
			
			if (msbuild != null)
			{
				int i = 0;
				 for (Map.Entry<String,MSBuildDTO>  entry :  msbuild.entrySet())
				 {
					 //Set <String> env =  msbuild.keySet();
					 list.add(entry.getKey());
					 list.add("");
					 list.add("0");
					 data.put("DropSettings"+i, list);
					 i++;
				 }
			}
			
			Type mapType = new TypeToken<Map<String,EnvironmentDTO >>(){}.getType();
			Map<String,EnvironmentDTO> jenkinsDate = DashboardUtils.readJsonFile(ENVIRONMENT_LIST_FILE_NAME, mapType);
			
			if (jenkinsDate != null)
			{
				 int i = 0;
				 for (Map.Entry<String,EnvironmentDTO>  entry :  jenkinsDate.entrySet())
				 {
						 list.add(entry.getKey());
						 list.add("");
						 list.add("0");
						 data.put("CISettings"+i, list); 
				 }
			}
			
			response.getWriter().append(DashboardUtils.toJson(data, mapType));
			
		}
		else
		{
			Type mapTypems = new TypeToken<Map<String, MSBuildDTO>>(){}.getType();
			Map <String,MSBuildDTO> msbuild = DashboardUtils.readJsonFile(MSBUILD_FILE, mapTypems);
			
			if (msbuild != null)
			{
				 int i = 0;
				 for (Map.Entry<String,MSBuildDTO>  entry :  msbuild.entrySet())
				 {
					 //Set <String> env =  msbuild.keySet();
					 boolean done =  data.containsKey("DropSettings"+i);
					 if (!done)
					 {
						 list.add(entry.getKey());
						 list.add("");
						 list.add("0");
						 data.put("DropSettings"+i, list); 
					 }
					 i++;
				 }
			}
			Type mapTypeenv = new TypeToken<Map<String,EnvironmentDTO>>(){}.getType();
			Map<String,EnvironmentDTO> jenkinsDate = DashboardUtils.readJsonFile(ENVIRONMENT_LIST_FILE_NAME, mapType);
			
			if (jenkinsDate != null)
			{
				 int i = 0;
				 for (Map.Entry<String,EnvironmentDTO>  entry :  jenkinsDate.entrySet())
				 {
					 //Set <String> env =  msbuild.keySet();
					 boolean done =  data.containsKey("CISettings"+i);
					 //List<String>list = new ArrayList<String>();
					 if (!done)
					 {
						 list.add(entry.getKey());
						 list.add("");
						 list.add("0");
						 data.put("CISettings"+i, list); 
					 }
					 i++;
				 }
			}
			
			response.getWriter().append(DashboardUtils.toJson(data, mapType));
	}
	
	public void doPostPageLayput(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		data = DashboardUtils.readJsonFile(CONFIG_FILE, mapType);
		String color = request.getParameter('Color');
		String textSize =  request.getParameter('textSize');
		list.add(color);
		list.add(textSize);
		if (data == null)
		{
			data = new HashMap<String, ArrayList>();
			data.put("PageLayput", list);
			DashboardUtils.writeJsonFile(CONFIG_FILE,data,mapType);
			//response.getWriter().append(DashboardUtils.toJson('Success', String));
		}
		else
		{
			data.replace("PageLayput",list);
			DashboardUtils.writeJsonFile(CONFIG_FILE,data,mapType);
		}
		response.getWriter().append(DashboardUtils.toJson("Success", String));
	}
	
	public void doPostDropSettings(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		String [] environment =  request.getParameter('environmentNameDrop');
		String [] orderBand = request.getParameter('OrderBandDrop');
		// for true and  for false
		String [] displayDrop = request.getParameterValues('toDisplayDrop');
		
		data = DashboardUtils.readJsonFile(CONFIG_FILE, mapType);
		if (data == null)
		{
			//environment+Order Band+Display drop follow each other starting from environmnet
			data = new HashMap<String, ArrayList>();
			for (int i=0;i < environment.length;i++)
			{
				list.clear();
				list.add(environment[i]);
				list.add(orderBand[i]);
				list.add(displayDrop[i]);
				data.put("DropSettings"+i, list);
			}
		}
		else
		{
				for (int i=0;i < environment.length;i++)
				{
					list.clear();
					list.add(environment[i]);
					list.add(orderBand[i]);
					list.add(displayDrop[i]);
					if(data.containsKey("DropSettings"+i))
					{
						data.replace("DropSettings"+i, list);
					}
					else
					{
						data.puy("DropSettings"+i, list);
					}
					
				}
			}
		//data.put("DropSettings", list);
		DashboardUtils.writeJsonFile(CONFIG_FILE,data,mapType);
		response.getWriter().append(DashboardUtils.toJson("Success",String));
	}
	
	public void doPostCISettings(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		String [] environment =  request.getParameter('environmentNameDrop');
		String [] orderBand = request.getParameter('OrderBandDrop');
		// for true and  for false
		String [] displayDrop = request.getParameterValues('toDisplayDrop');
		
		//environment+Order Band+Display drop follow each other starting from environmnet
		data = DashboardUtils.readJsonFile(CONFIG_FILE, mapType);
		if (data == null)
		{
			//environment+Order Band+Display drop follow each other starting from environmnet
			data = new HashMap<String, ArrayList>();
			for (int i=0;i < environment.length;i++)
			{
				list.clear();
				list.add(environment[i]);
				list.add(orderBand[i]);
				list.add(displayDrop[i]);
				data.put("CISettings"+i, list);
			}
		}
		else
		{
				for (int i=0;i < environment.length;i++)
				{
					list.clear();
					list.add(environment[i]);
					list.add(orderBand[i]);
					list.add(displayDrop[i]);
					if(data.containsKey("CISettings"+i))
					{
						data.replace("CISettings"+i, list);
					}
					else
					{
						data.puy("CISettings"+i, list);
					}
					
				}
			}
		
		DashboardUtils.writeJsonFile(CONFIG_FILE,data,mapType);
		response.getWriter().append(DashboardUtils.toJson("Success", String));
	}
	
	public void doPostRedmine(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String [] field =  request.getParameter('fieldName');
		// for true and  for false
		String [] display = request.getParameterValues('Display');
		
		//environment+Order Band+Display drop follow each other starting from environmnet
		data = DashboardUtils.readJsonFile(CONFIG_FILE, mapType);
		if (data == null)
		{
				//environment+Order Band+Display drop follow each other starting from environmnet
				data = new HashMap<String, ArrayList>();
				for (int i=0;i < environment.length;i++)
				{
					list.clear();
					list.add(environment[i]);
					list.add(orderBand[i]);
					list.add(displayDrop[i]);
					data.put("Redmine"+i, list);
				}
		}
		else
		{
				for (int i=0;i < environment.length;i++)
				{
					list.clear();
					list.add(environment[i]);
					list.add(orderBand[i]);
					list.add(displayDrop[i]);
					if(data.containsKey("Redmine"+i))
					{
						data.replace("Redmine"+i, list);
					}
					else
					{
						data.puy("Redmine"+i, list);
					}
							
				}
			}
		}
		
		DashboardUtils.writeJsonFile(CONFIG_FILE,data,mapType);
		//String suc = 
		response.getWriter().append(DashboardUtils.toJson("Success",String));
	}
}
