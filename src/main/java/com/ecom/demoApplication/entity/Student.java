package com.ecom.demoApplication.entity;

public class Student {
	private String firstName;
	private String lastName;
	private Integer age;
	
	public Student()
	{
		
	}
	
	public Student(String firstName, String lastName, Integer age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
