package ch.hevs.businessobject;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Athlete")
public class Athlete {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name="lname")
	private String lastname;
	@Column(name="fname")
	private String firstname;
	@Column(name="country")
	private String country;
	@Column(name="year")
	private int year;

	
	@ManyToMany(mappedBy="athletes") 
	private Set<Sport> sports;
	
	
	
	
	
	
	public Athlete() {
		
	}
	
	public Set<Sport> getSports(){
		return this.sports;
	}
	
	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}

	
	
	public Athlete(long id, String lastname, String firstname, String country, int year) {
		super();
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.country = country;
		this.year = year;
		
		
	}
	// id
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	// firstname
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	// lastname
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getYear() {
		return year;
	}
	
	
	
	@Override
	public String toString() {
		String result = id + "-" + lastname + "-" + firstname;
		return result;
	}
}
