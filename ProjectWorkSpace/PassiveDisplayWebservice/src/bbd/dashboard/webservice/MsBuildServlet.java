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
import bbd.dashboard.Log;
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
		Log.infoEnabled = true;
		Log.info("Start");
		MSBuildDAO dao = MSBuildDAO.getInstance();
		
		String environment = request.getParameter("environment");
		String revision = request.getParameter("revision");
		String status = request.getParameter("status");
		Log.info("environment=" + environment);
		Log.info("revision=" + revision);
		Log.info("status=" + status);
		Log.info("statusString(Integer.parseInt(status))=" + statusString(Integer.parseInt(status)));
		MSBuildDTO obj = new MSBuildDTO();
		obj.setRevision(revision);
		obj.setStatus(statusString(Integer.parseInt(status)));
		dao.updateDropStatus(environment, obj);
		Log.info("End");
		Type map = new TypeToken<HashMap<String, MSBuildDTO>>(){}.getType();
		response.getWriter().append(DashboardUtils.toJson(dao.getDropStatus(), map));
		Log.infoEnabled = false;
	}
	
	public String statusString(int status)
	{
		switch(status)
		{
			case 0:	return "New";	
			case 1:	return "SandBox Updated";
			case 2:	return "Initialised";
			case 3:	return "UI Done";
			case 4:	return "SC Done";
			case 5:	return "Comp Verified";
			case 6:	return "Document Updated";
			case 7:	return "Deployed";
			case 8:	return "Release Notes Generated";
			case 9: return "Check List Generated";
			case 10: return "Prepared";
			case 11: return "Sent";
			default: return"";
		}
	}
	
}