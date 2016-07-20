package bbd.dashboard.dao.environment;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

import bbd.dashboard.DashboardUtils;
import bbd.dashboard.Log;
import bbd.dashboard.Result;
import bbd.dashboard.dto.EnvironmentDTO;

public class EnvironmentFileDAO implements EnvironmentDAO {
	
	private static EnvironmentFileDAO instance;
	
	public static EnvironmentFileDAO getInstance() {
		if(instance == null)
			instance = new EnvironmentFileDAO();
		
		return instance;
	}
	
	private EnvironmentFileDAO(){}

	@Override
	public Result<List<EnvironmentDTO>> getEnvironments() {
		List<EnvironmentDTO> resultList = new ArrayList<EnvironmentDTO>();
		//TODO swap for back end call;
		String jsonObject = "{\n"
				+ "\"Environment3\":{\"Status\":\"Aborted\",\"Name\":\"CoreProdDebug\"}\n"
				+ ",\"Environment4\":{\"Status\":\"Disabled\",\"Name\":\"CoreTrunk\"}\n"
				+ ",\"Environment5\":{\"Status\":\"Success\",\"Name\":\"CoreTrunkDebug\"}\n"
				+ ",\"Environment6\":{\"Status\":\"Success\",\"Name\":\"DB Backup - ActTrunkTest\"}\n"
				+ ",\"Environment0\":{\"Status\":\"Success\",\"Name\":\"CorePPPPCI\"}\n"
				+ ",\"Environment1\":{\"Status\":\"Success\",\"Name\":\"CorePreProd\"}\n"
				+ ",\"Environment2\":{\"Status\":\"Failed\",\"Name\":\"CorePreProdDebug\"}\n"
				+ "}";
		Log.info(jsonObject);
		
		Type type = new TypeToken<HashMap<String, EnvironmentDTO>>(){}.getType();
		Map<String, EnvironmentDTO> map = new HashMap<String, EnvironmentDTO>(); 
		//format json environment object to hash map
		map = DashboardUtils.fromJson(jsonObject, type);
		Log.info(map);
		//add each element of the map to an array list
		for(Map.Entry<String, EnvironmentDTO> entity: map.entrySet()) {
			Log.info(entity.getKey());
			resultList.add(entity.getValue());
		}
		
		Result<List<EnvironmentDTO>> result = new Result<List<EnvironmentDTO>>(resultList);
		return result;
	}
}
