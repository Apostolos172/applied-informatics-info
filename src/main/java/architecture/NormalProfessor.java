package architecture;

import java.io.File;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import util.Useful;

public class NormalProfessor implements Professor {
	private String first_name;
	private String last_name;
	private String phone;
	private String email;
	private String type;
	private String alias;
	private String photoName;
	
	private ArrayList<Course> courses;
	
	public NormalProfessor(String first_name, String last_name, String phone) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.courses = new ArrayList<Course>();
		this.type = "Καθηγητής";
		this.setAlias();
		this.setPhotoName();
	}
	
	public NormalProfessor(String first_name, String last_name, String phone, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.type = "Καθηγητής";
		this.setAlias();
		this.setPhotoName();

	}

	public NormalProfessor(String first_name, String last_name, String phone, String email, ArrayList<Course> courses) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.courses = courses;
		this.type = "Καθηγητής";
		this.setAlias();
		this.setPhotoName();

	}

	public NormalProfessor(String firstName, String lastName, String phone2, String email2,
			HttpServletRequest request) {
		super();
		this.first_name = firstName;
		this.last_name = lastName;
		this.phone = phone2;
		this.email = email2;
		this.type = "Καθηγητής";
		this.setAlias();
		this.setPhotoName(request);	
		
	}

	private void setPhotoName(HttpServletRequest request) {
		StringBuilder suffix = new StringBuilder("");
		boolean exists = Useful.photoFileExists(this.alias, request, suffix);
		if(!exists) {
			this.photoName = "personphoto.jpg";
		} else {
			this.photoName = this.alias + suffix;
		}		
	}

	@Override
	public String getFirst_name() {
		return first_name;
	}

	@Override
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	@Override
	public String getLast_name() {
		return last_name;
	}

	@Override
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String getEmail() {
		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public ArrayList<Course> getCourses() {
		return courses;
	}

	@Override
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Professor [first_name=" + first_name + ", last_name=" + last_name + ", phone=" + phone + ", email="
				+ email + ", courses=" + courses + ", type=" + this.type + "]";
	}

	@Override
	public void addCourse(Course aCourse) {
		this.courses.add(aCourse);
	}
	
	@Override
	public String getInfo() {
		return this.type;
	}
	
	public void setAlias() {
		this.alias = this.email.substring(0,this.email.indexOf("@"));
	}

	public String getAlias() {
		return alias;
	}
	
	public void setPhotoName() {
		this.photoName = "personphoto";
	}

	public String getPhotoName() {
		return photoName;
	}
	
	
	
}
