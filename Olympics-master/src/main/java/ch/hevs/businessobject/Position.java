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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

@Entity
@Table(name="Position")
public class Position implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private int positionNumber;
	
	@ManyToMany(mappedBy="positions")
	private Set<Sport> sports;
	
	public Set<Sport> getSports(){
		return sports;
	}
	
	public void setSports(Set<Sport> sports) {
		
		this.sports = sports;
	}
	

	
}