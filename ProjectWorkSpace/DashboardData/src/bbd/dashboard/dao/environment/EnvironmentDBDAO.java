package bbd.dashboard.dao.environment;

import java.util.List;

import bbd.dashboard.Result;
import bbd.dashboard.dto.EnvironmentDTO;

public class EnvironmentDBDAO implements EnvironmentDAO {

	private static EnvironmentDBDAO instance;
	
	public static EnvironmentDBDAO getInstance() {
		if(instance == null)
			instance = new EnvironmentDBDAO();
		
		return instance;
	}
	
	private EnvironmentDBDAO(){}

	@Override
	public Result<List<EnvironmentDTO>> getEnvironments() {
		// TODO call back end and get json from there		
		return null;
	}

	@Override
	public Result<String> getEnvironmentsJSON() {
		// TODO Auto-generated method stub
		return null;
	}	
}
