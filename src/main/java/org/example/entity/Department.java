package org.example.entity;

public class Department {
	private Integer departmentId;
	private String departmentName;
	
	public Department(Integer departmentId, String departmentName) {
		
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
}
