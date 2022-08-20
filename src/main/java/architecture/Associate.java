package architecture;

import java.util.ArrayList;

public class Associate extends Professor {
	private String type;
	
	public Associate(String first_name, String last_name, String phone) {
		super(first_name, last_name, phone);
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
	
	

}
