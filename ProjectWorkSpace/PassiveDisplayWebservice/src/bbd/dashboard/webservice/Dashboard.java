package bbd.dashboard.webservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbd.dashboard.Log;
import bbd.dashboard.Result;
import bbd.dashboard.dao.DAOType;
import bbd.dashboard.dao.environment.EnvironmentDAO;
import bbd.dashboard.dao.environment.EnvironmentDAOFactory;

/**
 * Servlet implementation class HalloWorld
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Log.infoEnabled = true;
		EnvironmentDAO dao = EnvironmentDAOFactory.getInstance().getDAO(DAOType.FILE);
		Result<String> result = dao.getEnvironments();
		response.getWriter().append(result.getValue());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
