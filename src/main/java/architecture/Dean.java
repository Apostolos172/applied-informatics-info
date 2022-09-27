package architecture;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class Dean extends NormalProfessor {
	
	public Dean(String first_name, String last_name, String phone) {
		super(first_name, last_name, phone);
		// TODO Auto-generated constructor stub
		super.setType("Κοσμήτορας");
	}

	public Dean(String first_name, String last_name, String phone, String email, ArrayList<Course> courses) {
		super(first_name, last_name, phone, email, courses);
		// TODO Auto-generated constructor stub
		super.setType("Κοσμήτορας");
	}

	public Dean(String first_name, String last_name, String phone, String email) {
		super(first_name, last_name, phone, email);
		// TODO Auto-generated constructor stub
		super.setType("Κοσμήτορας");
	}

	public Dean(String firstName, String lastName, String phone2, String email2, HttpServletRequest request) {
		super(firstName, lastName, phone2, email2, request);
		// TODO Auto-generated constructor stub
		super.setType("Κοσμήτορας");
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return super.getType();
	}

}
