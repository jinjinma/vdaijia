package com.tty.vdaijia.model;

import java.io.Serializable;

public class DriverModel implements Serializable{
	private static final long serialVersionUID = -8054272132666382029L;
	
	private int port;
	private String name;
	private int distance;
	private int totalCounts;
	private int driveYear;
	private String homeTown;
	
	public DriverModel(){
		
	}
	
	public DriverModel(int port, String name, int distance, int counts, int years, String homeTown){
		this.port = port;
		this.name = name;
		this.distance = distance;
		this.totalCounts = counts;
		this.driveYear = years;
		this.homeTown = homeTown;
	}
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getTotalCounts() {
		return totalCounts;
	}

	public void setTotalCounts(int totalCounts) {
		this.totalCounts = totalCounts;
	}

	public int getDriveYear() {
		return driveYear;
	}

	public void setDriveYear(int driveYear) {
		this.driveYear = driveYear;
	}

	public String getHomeTown() {
		return homeTown;
	}

	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
