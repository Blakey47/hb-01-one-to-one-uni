package com.darraghblake.hibernate.practice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	// annotate the class as and entity and map to db table
	
	// define the fields
	
	// annotate the fields with db column names
	
	// create constructors
	
	// generate getter/setter methods
	
	// generate toString() method
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="website")
	private String website;
	
	@Column(name="hobby")
	private String hobby;

	public InstructorDetail() {
		
	}

	public InstructorDetail(String website, String hobby) {
		super();
		this.website = website;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", website=" + website + ", hobby=" + hobby + "]";
	}
	
	
}
