package architecture;

import java.util.ArrayList;

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
	
	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return super.getType();
	}

}
