package architecture;

public class Course {
	private String name;
	private String code;
	private String type;
	private String description;
	
	private Department department;

	public Course(String name, String code, String type, String description, Department department) {
		super();
		this.name = name;
		this.code = code;
		this.type = type;
		this.description = description;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", code=" + code + ", type=" + type + ", description=" + description
				+ ", department=" + department.toString() + "]";
	}
	
}
