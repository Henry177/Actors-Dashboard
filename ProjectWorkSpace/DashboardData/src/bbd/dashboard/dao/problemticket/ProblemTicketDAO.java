package bbd.dashboard.dao.problemticket;

import java.util.List;

import bbd.dashboard.Result;
import bbd.dashboard.dto.ProblemTicketDTO;

public interface ProblemTicketDAO {

	Result<List<ProblemTicketDTO>> getProblemTickets();
	
	Result<String> addProblemTicket(ProblemTicketDTO problem);
	
	Result<String> updateProblemTicketStatus(ProblemTicketDTO problem);
	
	Result<String> updateProblemTicketAssignee(ProblemTicketDTO problem);
	
	Result<String> DeleteProblemTicket(ProblemTicketDTO problem);
}
