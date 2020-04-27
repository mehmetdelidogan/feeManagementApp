package com.LastManagement.feeApp.repositories;

public class AccountantDto {
	
	private String name;
    private String email;
    
	public AccountantDto() {
	}

	public AccountantDto(String name, String email) {
		this.name = name;
		this.email = email;
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

	@Override
	public String toString() {
		return "AccountantDto [name=" + name + ", email=" + email + "]";
	}

}
