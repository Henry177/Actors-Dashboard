package bbd.dashboard.sessionbean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import bbd.dashboard.DashboardUtils;

/**
 * Session Bean implementation class TestBean
 */
@ManagedBean(name = "TestBean")
@SessionScoped
public class TestBean implements Serializable {

	private static final long serialVersionUID = -5016908257738925664L;
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
    
    public List<ProblemItem> getProblems() {
    	List<ProblemItem> tmp = new ArrayList<ProblemItem>();
    	
    	tmp.add(new ProblemItem(null, "6.0.6.41.34"));
    	try
    	{
	    	tmp.add(new ProblemItem(new SimpleDateFormat("dd/MM HH:mm:ss").parse("02/06 11:52:15"), "#127"));
	    	tmp.add(new ProblemItem(new SimpleDateFormat("dd/MM HH:mm:ss").parse("02/06 12:16:45"), "#1458"));
	    	tmp.add(new ProblemItem(new SimpleDateFormat("dd/MM HH:mm:ss").parse("02/06 13:12:05"), "#5426"));
    	} catch(ParseException e) {
    		DashboardUtils.log(e.getMessage());
    	}
    	
    	return tmp;
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

	public class ProblemItem {
		
		private Date date;    	
		private String code;
		
		public ProblemItem(Date date, String code) {
			setDate(date);
			setCode(code);
		}

		public String getDate() {
			if(date == null)
				return "[blank]";
			return new SimpleDateFormat("dd/MM HH:mm:ss").format(date);
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getCode() {
			if(date == null)
				return "";
			return "(" + code + ")";
		}

		public void setCode(String code) {
			this.code = code;
		}	
		
		public String getDescription() {
			return "Some description";
		}
		
		public String getImage() {
			return "url('" + DashboardUtils.getIPandPort() + "GoogleMaterials/Images/programer.png')";
		}
	}
}
