package server;

public class User {
	private int userID;
	private String DOB;
	private String firstName;
	private String lastName;
	private String email;
	private String gender;
	private boolean root;
	private int userStatus;
	
	public User(int userID, String dOB, String firstName, String lastName, String email, String gender, boolean root,
			int userStatus) {
		super();
		this.userID = userID;
		DOB = dOB;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.root = root;
		this.userStatus = userStatus;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean isRoot() {
		return root;
	}
	public void setRoot(boolean root) {
		this.root = root;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
}
