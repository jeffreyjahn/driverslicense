package com.jeffreyahn.driverslicense.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="licenses")
public class License {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Date expiration_date;
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    static Integer lastNumber=0;
    public License() {
        this.setNumber();
    }
    public License(Person person) {
        this.setNumber();
        this.person = person;
        
    }
    public License(String state, Person person) {
        this.setNumber();
        this.state = state;
        this.person = person;
    }
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber() {
		Integer last = License.getLastNumber();
		System.out.println(last);
		Integer current = last + 1;
		System.out.println(current);
		License.setLastNumber(current);
		String newNumber = Integer.toString(current);
		System.out.println(newNumber);
		while(newNumber.length()< 6) {
			System.out.println(newNumber);
			newNumber = "0".concat(newNumber);
		}
		this.number = newNumber;
	}
	public Date getExpiration_date() {
		return expiration_date;
	}
	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	private static Integer getLastNumber() {
		return lastNumber;
	}
	private static void setLastNumber(Integer lastNumber) {
		License.lastNumber = lastNumber;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	// ...
    // getters and setters removed for brevity
    // ...
	@PrePersist
    protected void onCreate(){
        this.setCreatedAt(new Date());
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}