package bbd.dashboard.webservice;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.reflect.TypeToken;

import bbd.dashboard.dao.redmine.RedmineDAO;

@WebServlet("/RedmineServlet")
public class RedmineServlet  extends HttpServlet {
	private static final long serialVersionUID = -5654083149577817261L;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {	
		RedmineDAO dao = RedmineDAO.getInstance();
		
		List<String> ids = dao.getRedmineId();
		
		if(ids != null) {		
			Type list = new TypeToken<List<JSONObject>>(){}.getType();
			response.getWriter().append(dao.GetRedmineQuery(ids));
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{}
}
