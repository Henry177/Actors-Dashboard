package bbd.dashboard.dao;

import java.util.List;

import bbd.dashboard.Result;
import bbd.dashboard.dto.ProblemTicketDTO;

public interface ProblemTicketDAO {

	Result<List<ProblemTicketDTO>> getProblemTickets();
	
	Result<String> addProblemTicket(ProblemTicketDTO problem);
}
