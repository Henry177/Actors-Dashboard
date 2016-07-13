package bbd.dashboard.sessionbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bbd.dashboard.Log;
import bbd.dashboard.Result;
import bbd.dashboard.dao.DAOType;
import bbd.dashboard.dao.ProblemTicketDAO;
import bbd.dashboard.dao.ProblemTicketDAOFactory;
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
    
    public List<EnvironmentStatus> getEnvironments() {
    	List<EnvironmentStatus> tmp = new ArrayList<EnvironmentStatus>();
    	
    	tmp.add(new EnvironmentStatus("Prod", "6.0.6.41.34", "Delivered"));
    	tmp.add(new EnvironmentStatus("PreProd++", "6.0.6.42.6", "Delivered"));
    	tmp.add(new EnvironmentStatus("PreProd", "6.0.7.9", "Started"));
    	tmp.add(new EnvironmentStatus("Trunck", "1096.0", "Backend Started"));
    	
    	return tmp;
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
    	Log.info("end");
    	Log.infoEnabled = false;
    }
   
    
    public String getDisplayMessage() {
    	return "06 June 09:15 – Quote not returning";
    }
    
    public class EnvironmentStatus {
    	
    	private String name;    	
		private String version;
    	private String status;
   	
    	public EnvironmentStatus(String name, String version, String status) {
			setName(name);
			setVersion(version);
			setStatus(status);
		}
    	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getVersion() {
			return version;
		}
		public void setVersion(String version) {
			this.version = version;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
    }
}
