package org.example.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.entity.Department;
import org.example.utils.JDBCUtils;
import org.example.utils.ScannerUtils;

public class DepartmentRepository {
	private List<Department> list = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	public List<Department> findAll() throws ClassNotFoundException, SQLException {

		Statement s = JDBCUtils.getConnection().createStatement();

		ResultSet rs = s.executeQuery("select * from department");
		// show data
		while (rs.next()) {
			list.add(new Department(rs.getInt(1), rs.getString(2)));
		}
		return list;

	}

	public String save() {
		String sqlInsert = "INSERT INTO `asm04`.`department` (`department_name`) VALUES (?)";
		try {

			PreparedStatement stmt = JDBCUtils.getConnection().prepareStatement(sqlInsert);
			System.out.println("Xin mời bạn nhập tên phòng");
			stmt.setString(1, ScannerUtils.inputString(sc, ""));
			if (stmt.executeUpdate() > 0) {
				
				return "insert thành công";
			}
            
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "insert thất bại";
	}
	
	public String update() {
		String sqlInsert = "UPDATE `asm04`.`department` SET `department_name` = ? WHERE (`department_id` = ? )"
				+ "";
		try {

			PreparedStatement stmt = JDBCUtils.getConnection().prepareStatement(sqlInsert);
			System.out.println("Xin mời bạn nhập id phòng cần sửa");
			stmt.setInt(2, ScannerUtils.inputInt(sc, "xin mời nhập số nguyên"));
			System.out.println("Xin mời bạn nhập tên phòng cần sửa");
			stmt.setString(1, ScannerUtils.inputString(sc, ""));
			if (stmt.executeUpdate() > 0) {
				
				return "update thành công";
			}
            
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "update thất bại";
	}
	
	
	public String delete() {
		String sqlInsert = "DELETE FROM `asm04`.`department` WHERE (`department_id` = ?)";
		try {

			PreparedStatement stmt = JDBCUtils.getConnection().prepareStatement(sqlInsert);
			System.out.println("Xin mời bạn nhập id phòng cần xóa");
			stmt.setInt(1, ScannerUtils.inputInt(sc, "xin mời nhập số nguyên"));
			
			if (stmt.executeUpdate() > 0) {
				
				return "delete thành công";
			}
            
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "delete thất bại";
	}
}
