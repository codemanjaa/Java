package ch.hevs.businessobject;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.PostPersist;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

@Entity
@Table(name="Sport")
public class Sport {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String name;
	private String description;
	
	@ManyToMany		
	private Set<Position> positions;
	
	@ManyToMany
	private Set<Athlete> athletes;
	
	
	
	
	
	public Set<Position> getPositions(){
		return positions;
	}
	
	public void setPositions(Set<Position> positions) {
		this.positions = positions;
	}
	
	
	
	public Set<Athlete> getAthletes(){
		return this.athletes;
	}
	
	
	public void setAthletes(Set<Athlete> athletes) {
		this.athletes = athletes;
	}
	 
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}