package com.proje.model;



public class Personel {
	private int personelID;
	private	String name;
	private	String lastName;
	private	String personelNumber;
	public Personel() {
		// TODO Auto-generated constructor stub
	}
	public Personel(int personelID, String name, String lastName, String personelNumber) {
		super();
		this.personelID = personelID;
		this.name = name;
		this.lastName = lastName;
		this.personelNumber = personelNumber;
	}
	public int getPersonelID() {
		return personelID;
	}
	public void setPersonelID(int personelID) {
		this.personelID = personelID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPersonelNumber() {
		return personelNumber;
	}
	public void setPersonelNumber(String personelNumber) {
		this.personelNumber = personelNumber;
	}
	@Override
	public String toString() {
		return "Pesonel [personelID=" + personelID + ", name=" + name + ", lastName=" + lastName + ", personelNumber="
				+ personelNumber + "]";
	}
	
}
