package bbd.dashboard.dao.environment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Log.infoEnabled = true;
		Log.info("Start");
		List<EnvironmentDTO> resultList = new ArrayList<EnvironmentDTO>();
		String jsonObject = getEnvironmentsJSON().getValue();
		Log.info(jsonObject);
		
		Map<String, EnvironmentDTO> map = new HashMap<String, EnvironmentDTO>(); 
		//format json environment object to hash map
		//Type type = TypeToken.get(HashMap<String, EnvironmentDTO>)
		//map = DashboardUtils.fromJson(jsonObject, type);
		Log.info(map);
		//add each element of the map to an array list
		for(Map.Entry<String, EnvironmentDTO> entity: map.entrySet()) {
			Log.info(entity.getKey());
			resultList.add(entity.getValue());
		}
		
		Result<List<EnvironmentDTO>> result = new Result<List<EnvironmentDTO>>(resultList);
		Log.info("End");
		Log.infoEnabled = false;
		return result;
	}

	@Override
	public Result<String> getEnvironmentsJSON() {
		String json = "";		
		json = "{\n"
				+ "\"CorCpp\":{\"Name\":\"CorCpp\",\"Building\":\"false\",\"EstimatedDuration\":\"5646\",\"Number\":\"105\",\"Result\":\"SUCCESS\",\"Timestamp\":\"3534654\"},\n"
				+ "\"CorPreProd\":{\"Name\":\"CorPreProd\",\"Building\":\"false\",\"EstimatedDuration\":\"5646\",\"Number\":\"105\",\"Result\":\"FAILED\",\"Timestamp\":\"3534654\"},\n"
				+ "\"Prod\":{\"Name\":\"CorPreProd\",\"Building\":\"false\",\"EstimatedDuration\":\"5646\",\"Number\":\"105\",\"Result\":\"BUILDING\",\"Timestamp\":\"3534654\"},\n"
				+ "\"Test\":{\"Name\":\"CorPreProd\",\"Building\":\"false\",\"EstimatedDuration\":\"5646\",\"Number\":\"105\",\"Result\":\"FAILED\",\"Timestamp\":\"3534654\"}\n"
				+ "}";
		
		/*try {
			json = JSONProvider.GetJSONFor(JSONSourceObject.JenkinsCore).toJSONString();
			Log.info(json);
		} catch (ParserConfigurationException e) {
		} catch (IOException e) {
		}*/
		
		Result<String> result = new Result<String>(json);
		return result;
	}
}
