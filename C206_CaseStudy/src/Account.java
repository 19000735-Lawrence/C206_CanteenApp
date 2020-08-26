public class Account {

public String userRole;
public String contactNumber;
public String studentID;
public String username;

public Account(String userRole,String contactNumber,String studentID,String username) {
	this.userRole=userRole;
	this.contactNumber=contactNumber;
	this.studentID=studentID;
	this.username=username;
}
public String getuserRole() {
	return userRole;
}
public String getcontactNumber() {
	return contactNumber;
}
public String getstudentID() {
	return studentID;
}
public String getusername() {
	return username;
}
public void setuserRole(String userRole) {
	this.userRole=userRole;
}
public void setcontactNumber(String contactNumber) {
	this.contactNumber=contactNumber;
}
public void setstudentID(String studentID) {
	this.studentID=studentID;
}
public void setusername(String username) {
	this.username=username;
}


