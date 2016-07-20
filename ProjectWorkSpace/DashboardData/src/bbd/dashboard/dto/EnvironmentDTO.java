package bbd.dashboard.dto;

import com.google.gson.annotations.SerializedName;

public class EnvironmentDTO {
    	
	@SerializedName(value = "Status")
	private String status;
	
	@SerializedName(value = "Name")
	private String name;
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}   	
	
	@Override
	public String toString() {
		return "{NameTest=" + name +", Status=" + status + "}";
	}
    
}
