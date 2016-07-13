package bbd.dashboard.dao;

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

	@Override
	public Result<List<ProblemTicketDTO>> getProblemTickets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result<String> addProblemTicket(ProblemTicketDTO problem) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
