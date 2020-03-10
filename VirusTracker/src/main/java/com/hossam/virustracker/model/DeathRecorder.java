package com.hossam.virustracker.model;

public class DeathRecorder {
		
		private String state;
		private String country;
		private int totalDeathCases;
		private int todayDeathCases;
		public String getState() {
				return state;
		}
		public String getCountry() {
				return country;
		}
		public int getTotalDeathCases() {
				return totalDeathCases;
		}
		public int getTodayDeathCases() {
				return todayDeathCases;
		}
		public void setState(String state) {
				this.state = state;
		}
		public void setCountry(String country) {
				this.country = country;
		}
		public void setTotalDeathCases(int totalDeathCases) {
				this.totalDeathCases = totalDeathCases;
		}
		public void setTodayDeathCases(int todayDeathCases) {
				this.todayDeathCases = todayDeathCases;
		}
		
		
		
	
}
