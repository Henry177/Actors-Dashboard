package GeneratorDataProvider;

public class JenkinsColorStatusConverter 
{
	public static String getStatusFromColor(String color) 
	{
		switch (color.toLowerCase()) 
		{
		case "blue":
			return "Success";
		case "blue_anime":
			return "Building after Success";
		case "red":
			return "Failed";
		case "red_anime":
			return "Building after Failure";
		case "aborted":
			return "Aborted";
		case "aborted_anime":
			return "Building after Abort";
		case "disabled":
			return "Disabled";
		case "disabled_anime":
			return "Building after Disabled";
		case "yellow":
			return "Unstable";
		case "yellow_anime":
			return "Building after Unstable";
		default:
			return "NOSTATUS";
		}
	}
}
