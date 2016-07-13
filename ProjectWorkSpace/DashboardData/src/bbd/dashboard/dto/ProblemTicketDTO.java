package bbd.dashboard.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProblemTicketDTO {
	private String code;
	private Date date;
	private String title;
	private String description;
	private List<String> images;
	
	public ProblemTicketDTO(String code, Date date, String title, String description) {
		super();
		this.setCode(code);
		this.setDate(date);
		this.setTitle(title);
		this.setDescription(description);
		this.images = new ArrayList<String>();
	}

	public ProblemTicketDTO() {
		this("", null, "", "");
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public List<String> getImages() {
		return images;
	}

	public void addImage(String image) {
		this.images.add(image);
	}	
}
