package architecture;

import java.util.ArrayList;

public interface Professor {

	String getFirst_name();

	void setFirst_name(String first_name);

	String getLast_name();

	void setLast_name(String last_name);

	String getPhone();

	void setPhone(String phone);

	String getEmail();

	void setEmail(String email);

	ArrayList<Course> getCourses();

	void setCourses(ArrayList<Course> courses);

	String getType();

	void setType(String type);

	String toString();

	void addCourse(Course aCourse);

	String getInfo();

}