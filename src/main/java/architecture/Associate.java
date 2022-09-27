package architecture;

import java.util.ArrayList;

public class Associate extends NormalProfessor implements Professor {
	private String type;
	
	public Associate(String first_name, String last_name, String phone) {
		super(first_name, last_name, phone);
		// TODO Auto-generated constructor stub
		this.type = "Αναπληρωτής Καθηγητής";
	}

	public Associate(String first_name, String last_name, String phone, String email) {
		super(first_name, last_name, phone, email);
		// TODO Auto-generated constructor stub
		this.type = "Αναπληρωτής Καθηγητής";
	}

	public Associate(String first_name, String last_name, String phone, String email, ArrayList<Course> courses) {
		super(first_name, last_name, phone, email, courses);
		// TODO Auto-generated constructor stub
		this.type = "Αναπληρωτής Καθηγητής";
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
