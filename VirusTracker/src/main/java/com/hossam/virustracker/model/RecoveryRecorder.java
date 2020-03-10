package com.hossam.virustracker.model;

public class RecoveryRecorder {
		
		private String state;
		private String country;
		private int totalRecoveryCases;
		private int todayRecoveryCases;
		public String getState() {
				return state;
		}
		public String getCountry() {
				return country;
		}
		public int getTotalRecoveryCases() {
				return totalRecoveryCases;
		}
		public int getTodayRecoveryCases() {
				return todayRecoveryCases;
		}
		public void setState(String state) {
				this.state = state;
		}
		public void setCountry(String country) {
				this.country = country;
		}
		public void setTotalRecoveryCases(int totalRecoveryCases) {
				this.totalRecoveryCases = totalRecoveryCases;
		}
		public void setTodayRecoveryCases(int todayRecoveryCases) {
				this.todayRecoveryCases = todayRecoveryCases;
		}
		
		
		
		
}
