import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MsBuildServlet")
public class MsBuildServlet extends HttpServlet 
{
	private static final long serialVersionUID = 3032697945058045637L;
	private String environment;
	private String revision;
	private String status;
	
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException	
	{		
		MSBuildSingleton.getDropStatus();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		environment = request.getParameter("environment");
		revision = request.getParameter("revision");
		status = request.getParameter("status");
		
		MSBuildDTO obj = new MSBuildDTO();
		obj.setRevision(revision);
		obj.setStatus(statusString(Integer.parseInt(status)));
		MSBuildSingleton.updateDropStatus(environment, obj);
	}
	
	public String statusString(int status)
	{
		switch(status)
		{
			case 1:	return "New";	
			case 2:	return "SandBox Updated";
			case 3:	return "Initialised";
			case 4:	return "UI Done";
			case 5:	return "SC Done";
			case 6:	return "Comp Verified";
			case 7:	return "Document Updated";
			case 8:	return "Deployed";
			case 9:	return "Release Notes Generated";
			case 10: return "Check List Generated";
			case 11: return "Prepared";
			case 12: return "Sent";
			default: return"";
		}
	}
	
}