package bbd.dashboard.dao;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import bbd.dashboard.DashboardUtils;

public class StringFilterDAO {

	private List<String> filterdNames;
	private String listFileName;
	private Type listType;
	
	public StringFilterDAO(String listFileName) {
		this.listFileName = listFileName;
		listType = new TypeToken<ArrayList<String>>(){}.getType();
		loadData();
	}

	public List<String> getFilterList() {
		loadData();
		return filterdNames;
	}

	private void loadData() {	
		filterdNames = DashboardUtils.readJsonFile(listFileName, listType);
		if(filterdNames == null)
			filterdNames = new ArrayList<String>();
	}
	
	public void addString(String newString) {
		if(filterdNames == null)
			loadData();
		
		if(!filterdNames.contains(newString.trim())) {
			filterdNames.add(newString);
			saveData();
		}
	}
	
	public void removeString(String removeString) {
		if(filterdNames == null)
			loadData();
		
		filterdNames.remove(removeString);
		saveData();
	}
	
	private void saveData() {
		DashboardUtils.writeJsonFile(listFileName, filterdNames, listType);
	}
	
	
}
