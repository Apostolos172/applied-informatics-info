package architecture;

import java.util.ArrayList;

public class Professor {
	private String first_name;
	private String last_name;
	private String phone;
	private String email;
	
	private ArrayList<Course> courses;
	
	public Professor(String first_name, String last_name, String phone) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.courses = new ArrayList<Course>();
	}

	public Professor(String first_name, String last_name, String phone, String email, ArrayList<Course> courses) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.email = email;
		this.courses = courses;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	@Override
	public String toString() {
		return "Professor [first_name=" + first_name + ", last_name=" + last_name + ", phone=" + phone + ", email="
				+ email + ", courses=" + courses + "]";
	}

	public void addCourse(Course aCourse) {
		this.courses.add(aCourse);
	}
	
	public String getInfo() {
		return "professor";
	}
	
}
