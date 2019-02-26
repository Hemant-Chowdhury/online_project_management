package com.opm.database;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
		private String username; 
	 	private String password;
	 	private String name;
	 	private String email;
	 	private String image;
	 	private String company;
	 	private Timestamp lastChecked;
	 	
	 	public User(String username, String password, String name, String email, String image, String company, Timestamp lastChecked) {
			this.username = username;
			this.password = password;
			this.name = name;
			this.email = email;
			this.image = image;
			this.company = company;
			this.lastChecked = lastChecked;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Timestamp getLastChecked() {
			return lastChecked;
		}

		public void setLastChecked(Timestamp lastChecked) {
			this.lastChecked = lastChecked;
		}

		public User() {
	 		
	 	}
		
}
