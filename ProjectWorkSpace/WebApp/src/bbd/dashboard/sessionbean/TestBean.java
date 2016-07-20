package bbd.dashboard.sessionbean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bbd.dashboard.Log;
import bbd.dashboard.Result;
import bbd.dashboard.dao.DAOType;
import bbd.dashboard.dao.environment.EnvironmentDAO;
import bbd.dashboard.dao.environment.EnvironmentDAOFactory;
import bbd.dashboard.dao.problemticket.ProblemTicketDAO;
import bbd.dashboard.dao.problemticket.ProblemTicketDAOFactory;
import bbd.dashboard.dto.EnvironmentDTO;
import bbd.dashboard.dto.ProblemTicketDTO;

/**
 * Session Bean implementation class TestBean
 */
@ManagedBean(name = "TestBean")
@SessionScoped
public class TestBean implements Serializable {

	private static final long serialVersionUID = -5016908257738925664L;
	private final DAOType daoType = DAOType.FILE; 
	private String name;
    /**
     * Default constructor. 
     */
    public TestBean() {
        name = "Tests";
    }

    public String getName() {
		return name;
	}
    
    public List<EnvironmentDTO> getEnvironments() {
		Log.infoEnabled = true;
		Log.info("Start");
		EnvironmentDAO dao = EnvironmentDAOFactory.getInstance().getDAO(daoType);
		
		Result<List<EnvironmentDTO>> result = dao.getEnvironments();
		
		if(!result.isError()) {
			List<EnvironmentDTO> environmentList = result.getValue();
			return environmentList;
		}
		Log.info("end");
		Log.infoEnabled = false;
		return null;			
    }
    
    public List<ProblemTicketDTO> getProblems() {
    	Log.info("Start");
    	ProblemTicketDAO dao = ProblemTicketDAOFactory.getInstance().getDAO(daoType);
    	Result<List<ProblemTicketDTO>> result = dao.getProblemTickets();
    	Log.info("result=" + result);
    	Log.info("end");
    	return result.getValue();	
    }
    
    public void addProblem(ProblemTicketDTO dto) {
    	Log.infoEnabled = true;
    	Log.info("Start");
    	
    	Log.info("code=" + dto.getCode());
    	//TODO presist problem
    	Log.info("end");
    	Log.infoEnabled = false;
    }
   
    
    public String getDisplayMessage() {
    	return "06 June 09:15 – Quote not returning";
    }
    
}
