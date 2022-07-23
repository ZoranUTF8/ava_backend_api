package com.zoranjanjic.demorest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity(name = "queryHistory")
@Table(name ="queryHistory")


public class History {

	
	@Id
	@Column(name = "idqueryHistory")
	private int idqueryHistory;
	
	@Column(name = "personName")
	private String personName;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "queryDate")
	private String queryDate;
	
	@Column(name = "queryPath")
	private String queryPath;
	
	@Column(name = "queryTime")
	private String queryTime;
	
	@Column(name = "queryParams")
	private String queryParams;
	
	
	public History() {
		// TODO Auto-generated constructor stub
	}


	




	public History(String personName, String phoneNumber, String queryDate, String queryPath,
			String queryTime, String queryParams) {
		this.personName = personName;
		this.phoneNumber = phoneNumber;
		this.queryDate = queryDate;
		this.queryPath = queryPath;
		this.queryTime = queryTime;
		this.queryParams = queryParams;
	}







	public int getIdqueryHistory() {
		return idqueryHistory;
	}




	public void setIdqueryHistory(int idqueryHistory) {
		this.idqueryHistory = idqueryHistory;
	}




	public String getPersonName() {
		return personName;
	}




	public void setPersonName(String personName) {
		this.personName = personName;
	}




	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}




	public String getQueryDate() {
		return queryDate;
	}




	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}




	public String getQueryPath() {
		return queryPath;
	}




	public void setQueryPath(String queryPath) {
		this.queryPath = queryPath;
	}




	public String getQueryTime() {
		return queryTime;
	}




	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}




	public String getQueryParams() {
		return queryParams;
	}




	public void setQueryParams(String queryParams) {
		this.queryParams = queryParams;
	}


	@Override
	public String toString() {
		
		return "Name: "+ this.personName + " Phone number: "+this.phoneNumber+ " Query date: "+this.queryDate+" Query path:  "+this.queryPath+" Query time: "+this.queryTime + " Query params: "+this.queryParams; 
				
	}


	
}
