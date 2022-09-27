package architecture;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Assistant extends NormalProfessor implements Professor {
	private String type;

	public Assistant(String first_name, String last_name, String phone) {
		super(first_name, last_name, phone);
		// TODO Auto-generated constructor stub
		this.type = "Επίκουρος καθηγητής";
	}

	public Assistant(String first_name, String last_name, String phone, String email) {
		super(first_name, last_name, phone, email);
		this.type = "Επίκουρος καθηγητής";
	}

	public Assistant(String first_name, String last_name, String phone, String email, ArrayList<Course> courses) {
		super(first_name, last_name, phone, email, courses);
		// TODO Auto-generated constructor stub
		this.type = "Επίκουρος καθηγητής";
	}

	public Assistant(String firstName, String lastName, String phone2, String email2, HttpServletRequest request) {
		super(firstName, lastName, phone2, email2, request);
		// TODO Auto-generated constructor stub
		this.type = "Επίκουρος καθηγητής";

	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.type;
	}

	@Override
	public String toString() {
		return "Professor [first_name=" + super.getFirst_name() + ", last_name=" + super.getLast_name() + ", phone=" + super.getPhone() + ", email="
				+ super.getEmail() + ", courses=" + super.getCourses() + ", type=" + this.type + "]";
	}
	
	

}
