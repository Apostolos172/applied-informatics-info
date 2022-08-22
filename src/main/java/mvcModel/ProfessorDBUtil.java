package mvcModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import architecture.Professor;

public class ProfessorDBUtil {
	private DataSource datasource;

	public ProfessorDBUtil(DataSource datasource) {
		super();
		this.datasource = datasource;
	}
	
	public ArrayList<Professor> getProfessors() {
		ArrayList<Professor> professors = new ArrayList<Professor>();
		
		Connection myConn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			myConn = this.datasource.getConnection();
			
			String sql = "SELECT * from professor;";
			stmt = myConn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				
				Professor tempProf = new Professor(firstName, lastName, phone, email);
				
				professors.add(tempProf);
				System.out.println(tempProf.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				myConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return professors;
	}
	
}
