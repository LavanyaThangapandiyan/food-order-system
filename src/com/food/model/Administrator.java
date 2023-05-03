package com.food.model;

public class Administrator {
	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int menuId;
	public Administrator()
	{
		
	}
	public Administrator(int id,String firstName,String lastName,String userName,String password,int menuId)
	{
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=userName;
		this.password=password;
		this.menuId=menuId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName="
				+ userName + ", password=" + password + ", menuId=" + menuId + ", getId()=" + getId()
				+ ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getUserName()="
				+ getUserName() + ", getPassword()=" + getPassword() + ", getMenuId()=" + getMenuId() + "]";
	}
	

}
