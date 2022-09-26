package mvcModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import architecture.Assistant;
import architecture.Associate;
import architecture.Dean;
import architecture.NormalProfessor;
import architecture.Professor;
import util.Useful;

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
			
			String sql = "SELECT * "
					+ "FROM professor "
					+ "ORDER BY cat DESC, last_name ASC; ";
			stmt = myConn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String cat = rs.getString("cat");
				
				Professor tempProf = Useful.getAppropriateProfessorObj(cat, firstName, lastName, phone, email);
				professors.add(tempProf);
				// System.out.println(tempProf.toString());
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

	public void addProfessor(Professor newProfessor) {
		// TODO Auto-generated method stub
		
		Connection myConn = null;
		PreparedStatement stmt = null;
		
		try {
			myConn = this.datasource.getConnection();
			
			String sql = "insert into professor (first_name, last_name, email, phone, cat) " + 
					"values (?, ?, ?, ?, ?)";
			
			stmt = myConn.prepareStatement(sql);
			stmt.setString(1, newProfessor.getFirst_name());
			stmt.setString(2, newProfessor.getLast_name());
			stmt.setString(3, newProfessor.getEmail());
			stmt.setString(4, newProfessor.getPhone());
			stmt.setString(5, Useful.getProfessorTypeAlias(newProfessor.getType()));
			System.out.println(Useful.getProfessorTypeAlias(newProfessor.getType()));
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(myConn, stmt, null);
		}
		
	}

	private void close(Connection myConn, PreparedStatement stmt, ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			if(myConn!=null)
				myConn.close();
			if(stmt!=null)
				stmt.close();
			if(rs!=null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeProfessor(String emailOfProfessorForRemoving) {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement stmt = null;
		
		try {
			myConn = datasource.getConnection();
			// DELETE FROM table_name WHERE condition; 
			String sql = "DELETE FROM professor WHERE professor.email=?; ";
			stmt = myConn.prepareStatement(sql);
			stmt.setString(1, emailOfProfessorForRemoving);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(myConn, stmt, null);
		}
		
	}

	public NormalProfessor loadProfessor(String profEmail) {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		NormalProfessor prof = null;
		//System.out.println(profEmail);
		
		try {
			myConn = this.datasource.getConnection();
			String sql = "SELECT * FROM professor WHERE professor.email=?; ";
			stmt = myConn.prepareStatement(sql);
			stmt.setString(1, profEmail);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				prof = new NormalProfessor(rs.getString("first_name"), rs.getString("last_name"), 
						rs.getString("phone"), rs.getString("email"));
				//System.out.println("here" + prof.toString());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close(myConn, stmt, rs);
		}
		return prof;
	}

	public void updateProfessor(NormalProfessor prof, String previousEmail) {
		// TODO Auto-generated method stub
		Connection myConn = null;
		PreparedStatement stmt = null;
		
		try {
			myConn = this.datasource.getConnection();
			String sql = "UPDATE professor SET "
					+ "first_name = ?, last_name = ?, email = ?, phone = ? "
					+ "WHERE professor.email = ?";
			stmt = myConn.prepareStatement(sql);
			stmt.setString(1, prof.getFirst_name());
			stmt.setString(2, prof.getLast_name());
			stmt.setString(3, prof.getEmail());
			stmt.setString(4, prof.getPhone());
			stmt.setString(5, previousEmail);
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close(myConn, stmt, null);
		}
		
	}
	
}
