package bbd.dashboard.webservice;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.reflect.TypeToken;

import bbd.dashboard.DashboardUtils;
import bbd.dashboard.dao.msbuild.MSBuildDAO;
import bbd.dashboard.dto.MSBuildDTO;

@WebServlet("/MsBuildServlet")
public class MsBuildServlet extends HttpServlet 
{
	private static final long serialVersionUID = 3032697945058045637L;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException	
	{	
		MSBuildDAO dao = MSBuildDAO.getInstance();
		
		Type map = new TypeToken<HashMap<String, MSBuildDTO>>(){}.getType();
		response.getWriter().append(DashboardUtils.toJson(dao.getDropStatus(), map));
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		MSBuildDAO dao = MSBuildDAO.getInstance();
		
		String environment = request.getParameter("environment");
		String revision = request.getParameter("revision");
		String status = request.getParameter("status");
		
		MSBuildDTO obj = new MSBuildDTO();
		obj.setRevision(revision);
		obj.setStatus(statusString(Integer.parseInt(status)));
		dao.updateDropStatus(environment, obj);
		
		Type map = new TypeToken<HashMap<String, MSBuildDTO>>(){}.getType();
		response.getWriter().append(DashboardUtils.toJson(dao.getDropStatus(), map));
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