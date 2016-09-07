package GeneratorDataProvider;

import java.util.ArrayList;
import java.util.List;

public class PathProvider
{
	 @SuppressWarnings("serial")
	public static List<String> JenkinsPaths = new ArrayList<String>() {{
	    add("http://corebuild:8080/api/xml");
	    add("http://guibuild:8080/api/xml");
	}};
}
