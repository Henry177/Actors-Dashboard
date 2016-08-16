package bbd.dashboard.dto;

import com.google.gson.annotations.SerializedName;

public class EnvironmentDTO {
    	
	@SerializedName(value = "Building")
	private boolean building;
	
	@SerializedName(value = "EstimatedDuration")
	private String estimatedDuration;
	
	@SerializedName(value = "Number")
	private String number;
	
	@SerializedName(value = "Timestamp")
	private String timestamp;
	
	@SerializedName(value = "Name")
	private String name;
	
	@SerializedName(value = "Result")
	private String result;

	public boolean isBuilding() {
		return building;
	}

	public void setBuilding(boolean building) {
		this.building = building;
	}

	public String getEstimatedDuration() {
		return estimatedDuration;
	}

	public void setEstimatedDuration(String estimatedDuration) {
		this.estimatedDuration = estimatedDuration;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}


