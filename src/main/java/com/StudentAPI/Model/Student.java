package com.StudentAPI.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Std_API")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int RollNo;
	private String Name;
	private String address;
	private String Phone_No;
	public int getRollNo() {
		return RollNo;
	}
	public void setRollNo(int rollNo) {
		RollNo = rollNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_No() {
		return Phone_No;
	}
	public void setPhone_No(String phone_No) {
		Phone_No = phone_No;
	}
	@Override
	public String toString() {
		return "Student [RollNo=" + RollNo + ", Name=" + Name + ", address=" + address + ", Phone_No=" + Phone_No + "]";
	}
	public Student(int rollNo, String name, String address, String phone_No) {
		super();
		RollNo = rollNo;
		Name = name;
		this.address = address;
		Phone_No = phone_No;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
