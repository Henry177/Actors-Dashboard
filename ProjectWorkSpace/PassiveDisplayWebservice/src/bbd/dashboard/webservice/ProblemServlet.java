package bbd.dashboard.webservice;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.reflect.TypeToken;

import bbd.dashboard.DashboardUtils;
import bbd.dashboard.Log;
import bbd.dashboard.dao.redmine.RedmineDAO;

@WebServlet("/ProblemServlet")
public class ProblemServlet  extends HttpServlet {
	private static final long serialVersionUID = -5654083149577817261L;

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {	
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		Log.info("Start");
		Log.info("request=" + request);
	}
}
