package bbd.dashboard.dao.msbuild;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import bbd.dashboard.Constants;
import bbd.dashboard.DashboardUtils;
import bbd.dashboard.Log;
import bbd.dashboard.dto.MSBuildDTO;

public class MSBuildDAO implements Constants
{	
	private Type mapType = new TypeToken<Map<String, MSBuildDTO>>(){}.getType();
	private Map<String, MSBuildDTO> data;
	private static MSBuildDAO instance;
	
	private MSBuildDAO()
	{
		loadData();
	}
	
	public static MSBuildDAO getInstance() {
		if(instance == null)
			instance = new MSBuildDAO();
		
		return instance;
	}
	
	public void updateDropStatus(String environment, MSBuildDTO info)
	{
		Log.infoEnabled = true;
		Log.errorEnabled = true;
		Log.info("Start");
		data.put(environment, info);
		saveData();
		Log.info("End");
		Log.errorEnabled = false;
		Log.infoEnabled = false;
	}
	
	public Map<String, MSBuildDTO> getDropStatus()
	{
		return data;
	}
	
	private void loadData() {	
		data = DashboardUtils.readJsonFile(MSBUILD_FILE, mapType);
		if(data == null)
			data = new HashMap<String, MSBuildDTO>();
	}
	
	private void saveData() {
		DashboardUtils.writeJsonFile(MSBUILD_FILE, data, mapType);
	}

}
