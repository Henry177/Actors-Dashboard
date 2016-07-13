package bbd.dashboard.bean.model;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import bbd.dashboard.Log;
import bbd.dashboard.dto.ProblemTicketDTO;
import bbd.dashboard.sessionbean.TestBean;

@ManagedBean(name = "ProblemBean")
@SessionScoped
public class ProblemBean implements Serializable{

	private static final long serialVersionUID = 7175705132306365411L;
	private ProblemTicketDTO dto;

	@ManagedProperty(value="#{TestBean}")
	private TestBean bean;
	
	public void setBean(TestBean bean) {
		this.bean = bean;
	}
	
	public TestBean getBean() {
		return bean;
	}
	
	public ProblemBean() {	
		this(new ProblemTicketDTO());
	}
	
	public ProblemBean(ProblemTicketDTO dto) {
		this.dto = dto;
	}
	
	public ProblemTicketDTO getDTO() {
		return dto;
	}
	
	public void submit() {
		bean.addProblem(getDTO());
	}
	
	public String getCode() {
		return dto.getCode();
	}
	
	public void setCode(String code) {
		Log.info("code=" + code);
		dto.setCode(code);
	}
	
	public String getDescription() {
		return dto.getDescription();
	}
	
	public void setDescription(String description) {
		dto.setDescription(description);
	}
	
	public List<String> getImages() {
		return dto.getImages();
	}
	
	/*public void getImages(List<String> images) {
		//return dto.setImages(images);
	}*/
	
}
