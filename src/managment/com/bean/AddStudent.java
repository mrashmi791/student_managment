package managment.com.bean;

public class AddStudent {
	
	protected int id;
	protected String name;
	
	protected int marks;
	protected String email;
	protected String dob;
	protected String gender;
	protected String course;
	
	
	
	public AddStudent() {
		super();
	}
	public AddStudent(int id, String name, int marks, String email, String dob, String gender, String course) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.course = course;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "AddStudent [id=" + id + ", name=" + name + ", marks=" + marks + ", email=" + email + ", dob=" + dob
				+ ", Gender=" + gender + ", course=" + course + "]";
	}

	public AddStudent(String name, int marks, String email, String dob, String gender, String course) {
		super();
		this.name = name;
		this.marks = marks;
		this.email = email;
		this.dob = dob;
		this.gender = gender;
		this.course = course;
	}
	
	
	
	

}
