package bbd.dashboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.h2.jdbcx.JdbcDataSource;

import bbd.dashboard.Log;

@Resources({
	@Resource(name="DashboardDS", lookup="java:jboss/datasources/DashboardDS", type=JdbcDataSource.class)
})

public class DashboardDAO {

	private static DashboardDAO instance;
	private DashboardDAO() {
		
	}
	
	public static DashboardDAO getInstance() {
		if(instance == null)
			instance = new DashboardDAO();
		
		return instance;
	}
	
	public void getConnection() {
		Log.info("Start");
		try {
			Connection connection = DriverManager.getConnection("java:jboss/datasources/DashboardDS");
			Log.info("connection=" + connection);
		} catch (SQLException e) {
			Log.error(e);
		}
		Log.info("End");
	}
	
}
