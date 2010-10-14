package it.ramiel.red5;

public class User {
	
	protected int ID;
	protected String firstName;
	protected String lastName;
	protected String connID;
	protected boolean isBroadcaster = false;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
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
	public String getConnID() {
		return connID;
	}
	public void setConnID(String connID) {
		this.connID = connID;
	}
	public Boolean isBroadcaster() {
		return isBroadcaster;
	}

}
