package in.co.rays.inheri;

public class CreditCard extends Payment{
 private int id;
 private String cctype;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCctype() {
	return cctype;
}
public void setCctype(String cctype) {
	this.cctype = cctype;
}



}