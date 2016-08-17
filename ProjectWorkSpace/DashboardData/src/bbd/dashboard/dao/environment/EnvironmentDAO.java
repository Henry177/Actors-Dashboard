package bbd.dashboard.dao.environment;

import java.util.List;

import bbd.dashboard.Result;
import bbd.dashboard.dto.EnvironmentDTO;

public interface EnvironmentDAO {

	String ENVIRONMENT_LIST_FILE_NAME = "../Config/EnvironmentFilter.json";
	
	Result<String> getEnvironments();
	
	Result<List<String>> getEnvironmentList();
}
