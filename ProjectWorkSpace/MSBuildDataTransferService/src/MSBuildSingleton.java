import java.util.HashMap;
import java.util.Map;

public class MSBuildSingleton
{
	static Map<String, MSBuildDTO> data;
	
	private MSBuildSingleton()
	{
		data = new HashMap<String, MSBuildDTO>();
	}
	
	public static void updateDropStatus(String environment, MSBuildDTO info)
	{
		data.put(environment, info);
	}
	
	public static Map<String, MSBuildDTO> getDropStatus()
	{
		return data;
	}

}
