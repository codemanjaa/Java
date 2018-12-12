package ch.hevs.registryservice;

import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Athlet;
import ch.hevs.businessobject.Position;
import ch.hevs.businessobject.Sport;

@Local
public interface Olympics {
	
	public String register(Sport sport, Athlet athlet, Position position) throws Exception;

	public Sport getSport(String sportname);
	
	//list all sports, athlets, positions (create methods) with all possible signatures
	
	public Position getPosition(int positionNumber);
	
	public Athlet getAthlet(String athletName);
	
	public List<Sport> getSportList(String sportName);
	
	//public List<Sport> getSportList(String sportName, int idAthlet);
	
	//public List<Sport> getSportList(String sportName);

	//public List<Position> getClients();

	//public Position getClient(long clientid);
}
