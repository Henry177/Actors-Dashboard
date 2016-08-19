package bbd.dashboard.dao.msbuild;

import java.util.HashMap;
import java.util.Map;

import bbd.dashboard.dto.MSBuildDTO;

public class MSBuildDAO
{
	private static Map<String, MSBuildDTO> data;
	private static MSBuildDAO instance;
	
	private MSBuildDAO()
	{
		data = new HashMap<String, MSBuildDTO>();
	}
	
	public static MSBuildDAO getInstance() {
		if(instance == null)
			instance = new MSBuildDAO();
		
		return instance;
	}
	
	public void updateDropStatus(String environment, MSBuildDTO info)
	{
		data.remove(environment);
		data.put(environment, info);
	}
	
	public Map<String, MSBuildDTO> getDropStatus()
	{
		return data;
	}

}
