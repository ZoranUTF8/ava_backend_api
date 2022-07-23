package com.zoranjanjic.demorest;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "queryHistory")
@Table(name = "queryHistory")

public class History {

	@Id
	@Column(name = "idqueryHistory")
	private int idqueryHistory;

	@Column(name = "queryDate")
	private Date queryDate;

	@Column(name = "queryPath")
	private String queryPath;

	@Column(name = "queryTime")
	private Time queryTime;

	@Column(name = "queryParams")
	private String queryParams;

	public History() {
		// TODO Auto-generated constructor stub
	}

	public History(Date queryDate, String queryPath, Time queryTime, String queryParams) {
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

	public Date getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}

	public String getQueryPath() {
		return queryPath;
	}

	public void setQueryPath(String queryPath) {
		this.queryPath = queryPath;
	}

	public Time getQueryTime() {
		return queryTime;
	}

	public void setQueryTime(Time queryTime) {
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

		return " Query date: " + this.queryDate + " Query path:  " + this.queryPath + " Query time: " + this.queryTime
				+ " Query params: " + this.queryParams;

	}

}
