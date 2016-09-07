package bbd.dashboard.dao.problemticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bbd.dashboard.Result;
import bbd.dashboard.dto.ProblemTicketDTO;


public class ProblemTicketDBDAO implements ProblemTicketDAO {

	private static ProblemTicketDBDAO instance;
	
	public static ProblemTicketDBDAO getInstance() {
		if(instance == null)
			instance = new ProblemTicketDBDAO();
		
		return instance;
	}
	
	private ProblemTicketDBDAO(){}
	
	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_CONNECTION = "jdbc:h2:~/test";
	private static final String DB_USER = "";
	private static final String DB_PASSWORD = "";
	
	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
		    Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
		    System.out.println(e.getMessage());
		}
		try {
		    dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
			    DB_PASSWORD);
		    return dbConnection;
		} catch (SQLException e) {
		    System.out.println(e.getMessage());
		}
		return dbConnection;
	}

	/*
	 *CREATE TABLE BAProblem(
		Id int primary key,
		Assignee Varchar(30),
		Title Varchar(50),
		Description Varchar(100),
		Status Varchar(10),
		Environment Varchar(20),
		Images Varchar(100)
	 );
	 
	 ID is Auto
	 **/
	@Override
	public Result<List<ProblemTicketDTO>> getProblemTickets() {
		/*// TODO Auto-generated method stub
		Connection connection = getDBConnection();
        	Statement stmt = null;
		stmt = connection.createStatement();
		try{
			ResultSet result = stmt.executeQuery("select * from BAProblem");
			List <ProblemTicketDTO> list = new ArrayList<ProblemTicketDTO>();
			
			ProblemTicketDTO problem = null;
			while(result.next)
			{
				problem = new ProblemTicketDTO();
				problem.setAssignee(result.getString('Assignee');
				problem.setTitle(result.getString('Title'));
				problem.setDescription(result.getString('Description'));
				problem.setStatus(result.getString('Status'));
				problem.setEnvironment(result.getString('Environment'));
				problem.setID(result.getInt('Id'));
				
				//image paths searated by ';'
				String images = result.getString("Images");
				String [] parts = images.split(";");
				
				for (int i = 0;i < parts.length,i++)
				{
					problem.addImage(parts[i]);
				}
				list.add(problem);
			}*/
		//Result<List<ProblemTicketDTO>> results = new Result<List<ProblemTicketDTO>>(list);
		Result<List<ProblemTicketDTO>> results = new Result<List<ProblemTicketDTO>>(new ArrayList<ProblemTicketDTO>());
			return results;
	/*	}catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		*/
	}

	@Override
	public Result<String> addProblemTicket(ProblemTicketDTO problem) {
		// TODO Auto-generated method stub
		/*Connection connection = getDBConnection();
		PreparedStatement insertStatement;
		String InsertQuery = "INSERT INTO BAProblems" + "( Assignee, Title, Description, Status, Environment,Images) values" + "(?,?,?,?,?,?)";
		
		try
		{
			insertStatement = connection.prepareStatement(InsertQuery);
			insertStatement.setString(1, problem.getAssignee());
			insertStatement.setString(2, problem.getTitle());
			insertStatement.setString(3, problem.getDescription());
			insertStatement.setString(4, problem.getStatus());
			insertStatement.setString(5, problem.getEnvironment());
			
			List <String> list = problem.getImages();
			String Image = list.get(0);
			for (int i =1;i < list.length;i++)
			{
				Image = Image.concat(";"+list.get(i));
			}
			insertPreparedStatement.setString(6,Image);
			insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();*/
			return new Result<String>("success");
	/*	}         
		catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}            
		*/
	}
	
	public Result<String> updateProblemTicketStatus(ProblemTicketDTO problem) {
		
		/*Connection connection = getDBConnection();
		PreparedStatement updateStatement;
		String UpdateQuery = "UPDATE BAProblems SET Status=? where Id=?";
		
		try
		{
			updateStatement = connection.prepareStatement(UpdateQuery);
			updateStatement.setString(1, problem.getStatus());
			updateStatement.setInt(2, problem.getID());
			updateStatement.executeUpdate();
			updateStatement.close();*/
			return new Result<String>("success");
	/*	}         
		catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		} */
	}
	
public Result<String> updateProblemTicketAssignee(ProblemTicketDTO problem) {
		
		Connection connection = getDBConnection();
		PreparedStatement updateStatement;
		String UpdateQuery = "UPDATE BAProblems SET Assignee=? where Id=?";
		
		try
		{
			updateStatement = connection.prepareStatement(UpdateQuery);
			updateStatement.setString(1, problem.getAssignee());
			updateStatement.setInt(2, problem.getID());
			updateStatement.executeUpdate();
			updateStatement.close();
			return Result<String>("success");
		}         
		catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		} 
	}
	
	public Result<String> DeleteProblemTicket(ProblemTicketDTO problem) {
		Connection connection = getDBConnection();
		PreparedStatement deleteStatement;
		String DeleteQuery = "Delete BAProblems where Id=?";
		
		/*try
		{*/
			/*deleteStatement = connection.prepareStatement(InsertQuery);
			deleteStatement.setString(1, problem.getID());
			deleteStatement.executeUpdate();
			deleteStatement.close();*/
			return new Result<String>("success");
	/*	}         
		catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		} */
	}
	
}
