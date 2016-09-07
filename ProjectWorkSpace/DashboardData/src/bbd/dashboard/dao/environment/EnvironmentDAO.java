package bbd.dashboard.dao.environment;

import java.util.List;

import bbd.dashboard.Constants;
import bbd.dashboard.Result;

public interface EnvironmentDAO extends Constants {

	String ENVIRONMENT_LIST_FILE_NAME = "../Config/EnvironmentFilter.json";
	
	Result<String> getEnvironments();
	
	Result<List<String>> getEnvironmentList();
}
