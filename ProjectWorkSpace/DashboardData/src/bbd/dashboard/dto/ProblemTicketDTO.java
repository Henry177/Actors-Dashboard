package bbd.dashboard.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProblemTicketDTO {
	private String status;
	private Date date;
	private String title;
	private String description;
	private String assignee;
	private String enviroment;
	private int id;
	private List<String> images;
	
	public ProblemTicketDTO(String status, Date date, String title, String description) {
		super();
		this.setStatus(status);
		this.setDate(date);
		this.setTitle(title);
		this.setDescription(description);
		this.images = new ArrayList<String>();
	}

	public ProblemTicketDTO() {
		this("", null, "", "");
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String code) {
		this.status = code;
	}
	
	public Date getDate() {
		return date;
	}
	
	public String getSDate() {
		if(date == null)
			return "[blank]";

		return new SimpleDateFormat("dd/MM HH:mm:ss").format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setAssignee(String assign)
	{
		this.assignee =assign;
	}
	
	public String getAssignee()
	{
		return assignee;
	}
	
	public void setEnviroment(String enviroment)
	{
		this.enviroment = enviroment;
	}

	public String getEnviroment()
	{
		return enviroment;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public int getID()
	{
		return id;
	}
	
	public List<String> getImages() {
		return images;
	}

	public void addImage(String image) {
		this.images.add(image);
	}	
}
