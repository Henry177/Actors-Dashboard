package bbd.dashboard.dao.environment;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import com.google.gson.reflect.TypeToken;

import bbd.dashboard.DashboardUtils;
import bbd.dashboard.Log;
import bbd.dashboard.Result;
import bbd.dashboard.dao.StringFilterDAO;
import bbd.dashboard.dto.EnvironmentDTO;
import bbd.dashboard.json.provider.JSONProvider;

public class EnvironmentFileDAO implements EnvironmentDAO {
	
	private static EnvironmentFileDAO instance;
	
	public static EnvironmentFileDAO getInstance() {
		if(instance == null)
			instance = new EnvironmentFileDAO();
		
		return instance;
	}
	
	private EnvironmentFileDAO() {
		mStringFilter = new StringFilterDAO(ENVIRONMENT_LIST_FILE_NAME);
		mAvailibleEnvironments = new StringFilterDAO(ENVIRONMENT_CONFIG_FILE);
	}

	
	private StringFilterDAO mStringFilter;
	private StringFilterDAO mAvailibleEnvironments;
	
	@Override
	public Result<String> getEnvironments() {
		Log.info("Start");
		String jsonObject = getEnvironmentsJSON().getValue();
		Log.info(jsonObject);
		
		Map<String, EnvironmentDTO> map = new HashMap<String, EnvironmentDTO>();
		Map<String, EnvironmentDTO> resultMap = new HashMap<String, EnvironmentDTO>();

		Type type = new TypeToken<HashMap<String, EnvironmentDTO>>(){}.getType();
		map = DashboardUtils.fromJson(jsonObject, type);
		Log.info("map=" + map);
		
		
		//add each element of the map to an array list
		int removed = map.size();
		Log.info("environments found=" + removed);
		if(!getEnvironmentList().isError())
			for(String s: getEnvironmentList().getValue()) {
				Log.info(s);
				mStringFilter.addString(s);
				resultMap.put(s, map.get(s));
			}
		removed -= resultMap.size();
		
		Log.info("environments removed=" + removed);
		
		Result<String> result = new Result<String>(DashboardUtils.toJson(resultMap, type));
		Log.info("End");	
		return result;
	}

	private Result<String> getEnvironmentsJSON() {
		Log.info("Start");
		String json = "";		
		/*json = "{\n"
				+ "\"CorCpp\":{\"Name\":\"CorCpp\",\"Building\":\"false\",\"EstimatedDuration\":\"5646\",\"Number\":\"105\",\"Result\":\"SUCCESS\",\"Timestamp\":\"3534654\"},\n"
				+ "\"CorPreProd\":{\"Name\":\"CorPreProd\",\"Building\":\"false\",\"EstimatedDuration\":\"5646\",\"Number\":\"105\",\"Result\":\"FAILED\",\"Timestamp\":\"3534654\"},\n"
				+ "\"CoreTrunkCI\":{\"Name\":\"CorPreProd\",\"Building\":\"false\",\"EstimatedDuration\":\"5646\",\"Number\":\"105\",\"Result\":\"BUILDING\",\"Timestamp\":\"3534654\"},\n"
				+ "\"CorePreProd\":{\"Name\":\"CorPreProd\",\"Building\":\"false\",\"EstimatedDuration\":\"5646\",\"Number\":\"105\",\"Result\":\"FAILED\",\"Timestamp\":\"3534654\"}\n"
				+ "}";*/
		
		try {
			json = JSONProvider.GetJSON().toJSONString();
			Log.info(json);
		} catch (ParserConfigurationException e) {
		} catch (IOException e) {
		}
		
		Log.info("End");
		Result<String> result = new Result<String>(json);
		return result;
	}

	@Override
	public Result<List<String>> getEnvironmentList() {
		Log.info("Start");
		Result<List<String>> result = new Result<>();
		if(mStringFilter != null) {
			result = new Result<>(mStringFilter.getFilterList());
		} else {
			result = new Result<>();
			result.setErrorMessage("Failed to load filter");
		}
		Log.info("result=" + result);
		Log.info("End");
		return result;
	}
}
