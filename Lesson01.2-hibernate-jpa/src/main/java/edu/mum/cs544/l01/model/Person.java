package edu.mum.cs544.l01.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//use annotation instead of Person.hbm.xml 
@Entity
public class Person {

	//this is the primary key and will be generated automatically
	@Id
	@GeneratedValue
	private int id;
    private String firstname;
    private String lastname;

    public Person() {
    }

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
    
}
