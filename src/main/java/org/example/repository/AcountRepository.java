package org.example.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.example.entity.Account;
import org.example.entity.Department;
import org.example.utils.JDBCUtils;
import org.example.utils.ScannerUtils;

public class AcountRepository {
	private List<Account> list = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);

	public List<Account> findAll() throws ClassNotFoundException, SQLException {

		Statement s = JDBCUtils.getConnection().createStatement();

		ResultSet rs = s.executeQuery("select * from account");
		// show data
		while (rs.next()) {
			list.add(new Account(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6)));
		}
		return list;

	}

	public String save() {
		String sqlInsert = "INSERT INTO `asm04`.`account` (`email`, `user_name`, `fullname`, `department_id`) VALUES (?, ?, ?, ?);\r\n"
				+ "";
		try {

			PreparedStatement stmt = JDBCUtils.getConnection().prepareStatement(sqlInsert);
			System.out.println("Xin mời bạn nhập email");
			stmt.setString(1, ScannerUtils.inputString(sc, ""));
			
			System.out.println("Xin mời bạn nhập username");
			stmt.setString(2, ScannerUtils.inputString(sc, ""));
			
			System.out.println("Xin mời bạn nhập fullname");
			stmt.setString(3, ScannerUtils.inputString(sc, ""));
			
			System.out.println("Xin mời bạn nhập department id");
			stmt.setInt(4, ScannerUtils.inputInt(sc, ""));
			
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
		String sqlInsert = " UPDATE `asm04`.`account` SET `email` = ?, "
				+ "`user_name` = ?, `fullname` = ?, `department_id` = ? WHERE (`idaccount` = ?);\r\n"
				+ "";
		
		try {

			PreparedStatement stmt = JDBCUtils.getConnection().prepareStatement(sqlInsert);
			System.out.println("xin mời bạn nhập id account cần sửa");
			stmt.setString(5, ScannerUtils.inputString(sc, ""));
			
			System.out.println("Xin mời bạn nhập email");
			stmt.setString(1, ScannerUtils.inputString(sc, ""));
			
			System.out.println("Xin mời bạn nhập username");
			stmt.setString(2, ScannerUtils.inputString(sc, ""));
			
			System.out.println("Xin mời bạn nhập fullname");
			stmt.setString(3, ScannerUtils.inputString(sc, ""));
			
			System.out.println("Xin mời bạn nhập department id");
			stmt.setInt(4, ScannerUtils.inputInt(sc, ""));
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
		String sqlInsert = "DELETE FROM `asm04`.`account` WHERE (`idaccount` = ?)";
		try {

			PreparedStatement stmt = JDBCUtils.getConnection().prepareStatement(sqlInsert);
			System.out.println("Xin mời bạn nhập id account cần xóa");
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
