package bbd.dashboard.dao.environment;

import java.util.List;

import bbd.dashboard.Result;
import bbd.dashboard.dto.EnvironmentDTO;

public interface EnvironmentDAO {

	Result<List<EnvironmentDTO>> getEnvironments();

}
