package bbd.dashboard;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.NetworkInterface;
import java.net.SocketException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class DashboardUtils {	
	
	private static GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
	
	public static String getIPandPort() {
		try {
			NetworkInterface tmp = NetworkInterface.getNetworkInterfaces().nextElement();
			return "http://" + tmp.getInetAddresses().nextElement().toString().substring(1) + ":8080/";
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void writeJsonFile(String fileName, Object obj, Class<?> objClass) {
		//GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
		Gson gson = builder.create();
		Log.info("start");
		Log.info("filename=" + fileName);
		File tmp = new File(fileName);
		if(!tmp.getParentFile().exists())
			tmp.getParentFile().mkdirs();
		
		try {
			FileWriter writer= new FileWriter(fileName);
			String json = "";
			if(objClass == null)
				json = obj.toString();
			else
				json = gson.toJson(obj, objClass);
			writer.write(json);
			writer.close();
			Log.info("File saved: " + tmp.getAbsolutePath());
		} catch (FileNotFoundException e) {
			Log.error(e.getMessage());
			Log.error(e);
		} catch (IOException e) {
			Log.error(e.getMessage());
			Log.error(e);
		}	
		Log.info("end");
	}
	
	public static <T> T readJsonFile(String fileName, Class<T> objClass) {		
		try {			
			FileInputStream fstream = new FileInputStream(fileName);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String json = "";
			String line;
			while((line = br.readLine()) != null)
				json += line;
			
			Log.info("json=" + json);
			fstream.close();
			//GsonBuilder builder = new GsonBuilder();
			Gson gson = new Gson();//builder.create();
			return gson.fromJson(json, objClass);
		} catch (FileNotFoundException e) {
			Log.error(e.getMessage());
			Log.error(e);
		} catch (IOException e) {
			Log.error(e.getMessage());
			Log.error(e);
		} catch (JsonSyntaxException e) {
			Log.error(e.getMessage());
			Log.error(e);
		}		
		return null;
	}
	
	/*public static <T> T fromJson(String json, Class<T> objClass) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.fromJson(json, objClass);
	}*/
	
	public static <T> T fromJson(String json, Type objClass) {
		GsonBuilder builder = new GsonBuilder();
		//builder.registerTypeAdapter(EnvironmentDTO.class, new EnvironmentSerializer());
		Gson gson = builder.create();
		Log.info("objClass=" + objClass);
		Log.info("json=" + json);
		return gson.fromJson(json, objClass);
	}
	
	public static String toJson(Object obj, Type objClass) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.toJson(obj, objClass);
	}
}
