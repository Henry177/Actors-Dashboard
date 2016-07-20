package bbd.dashboard.dao.environment;

import bbd.dashboard.dao.DAOType;

public class EnvironmentDAOFactory {
	
	private static EnvironmentDAOFactory instance;
	
	private EnvironmentDAOFactory(){};
	
	public static EnvironmentDAOFactory getInstance() {
		if(instance == null)
			instance = new EnvironmentDAOFactory();
		
		return instance;
	}
	
	public EnvironmentDAO getDAO(DAOType type) {
		if(type == DAOType.DB)
			return EnvironmentDBDAO.getInstance(); 
		
		return EnvironmentFileDAO.getInstance();
	}
}
