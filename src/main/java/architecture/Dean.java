package architecture;

import java.util.ArrayList;

public class Dean extends Professor {
	
	private String type;

	public Dean(String first_name, String last_name, String phone) {
		super(first_name, last_name, phone);
		// TODO Auto-generated constructor stub
		this.type = "Κοσμήτορας";
	}

	public Dean(String first_name, String last_name, String phone, String email, ArrayList<Course> courses) {
		super(first_name, last_name, phone, email, courses);
		// TODO Auto-generated constructor stub
		this.type = "Κοσμήτορας";
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return this.type;
	}
	
	

}
