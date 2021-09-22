package in.co.rays.association;

import org.hibernate.loader.custom.Return;

public class Employee {
 private int EmployeeId ;
 private String Name ;
 private Address address ;
public Employee() {

}
public int getEmployeeId() {
	return EmployeeId;
}
public void setEmployeeId(int employeeId) {
	EmployeeId = employeeId;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}

 
 
	 
}
