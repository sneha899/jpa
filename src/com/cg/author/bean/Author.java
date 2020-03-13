package com.cg.author.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="author_tbl")
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="aid")
	private int authorId;
	
	@Column(name="fname",length=15)
	private String firstName;
	
	@Column(name="mname",length=15)
	private String middlename;
	
	@Column(name="lname",length=15)
	private String lastName;
	
	@Column(name="phoneno")
   private long phoneNo;

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", middlename=" + middlename
				+ ", lastName=" + lastName + ", phoneNo=" + phoneNo + "]";
	}
	
}
