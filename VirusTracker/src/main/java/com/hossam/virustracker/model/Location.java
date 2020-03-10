package com.hossam.virustracker.model;

public class Location {
		
		private String country;
		private String state;
		private int totalCases;
		private int todayNewCases;
		
		
		
		public String getState() {
				return state;
		}
		public String getCountry() {
				return country;
		}
		public int getTotalCases() {
				return totalCases;
		}
		public void setState(String state) {
				this.state = state;
		}
		public void setCountry(String country) {
				this.country = country;
		}
		public void setTotalCases(int totalCases) {
				this.totalCases = totalCases;
		}
		public int getTodayNewCases() {
				return todayNewCases;
		}
		public void setTodayNewCases(int todayNewCases) {
				this.todayNewCases = todayNewCases;
		}
		

}
