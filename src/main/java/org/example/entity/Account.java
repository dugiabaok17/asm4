package org.example.entity;

import java.time.LocalDate;

public class Account {
	private Integer accountId;
	private String email;
	private String userName;
	private String fullName;
	private Integer departmentId;
	private String createDate;
	public Account(Integer accountId, String email, String userName, String fullName, Integer department) {
		
		this.accountId = accountId;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.departmentId = department;
		
	}
	
	
	public Account(Integer accountId, String email, String userName, String fullName, Integer departmentId,
			String createDate) {
		super();
		this.accountId = accountId;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.departmentId = departmentId;
		this.createDate = createDate;
	}


	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", email=" + email + ", userName=" + userName + ", fullName="
				+ fullName + ", department=" + departmentId + ", createDate=" + createDate + "]";
	}
	
}
