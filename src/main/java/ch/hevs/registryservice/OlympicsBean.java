package ch.hevs.registryservice;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ch.hevs.businessobject.Position;
import ch.hevs.businessobject.Sport;

@Stateful
@RolesAllowed(value = { "client", "banker" })
public class OlympicsBean implements Olympics {
	
	@PersistenceContext(name = "BankPU", type = PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	@Resource
	private SessionContext ctx;
	
	public String transfer(Sport srcAccount, Sport destAccount, int amount) {

		em.persist(srcAccount);
		em.persist(destAccount);
		srcAccount.debit(amount);
		destAccount.credit(amount);
				
		String transactionResult="Success!";
		if ((amount > 100) && !ctx.isCallerInRole("banker")) { // verify that the caller has the correct role if the amount is above 100CHF
			transactionResult="Error: " + ctx.getCallerPrincipal().getName() + " is not allowed to transfer more than 100 CHF.";
			
			System.out.println(transactionResult);
			ctx.setRollbackOnly(); // rollback if the caller is not a banker
		}
	
		return transactionResult;
	}

	public Sport getAccount(String accountDescription, String lastnameOwner) {
		Query query = em.createQuery("FROM Account a WHERE a.description=:description AND a.owner.lastname=:lastname");
		query.setParameter("description", accountDescription);
		query.setParameter("lastname", lastnameOwner);
		
		return (Sport) query.getSingleResult();
	}
	
	public List<Sport> getAccountListFromClientLastname(String lastname) {
		return (List<Sport>) em.createQuery("SELECT c.accounts FROM Client c where c.lastname=:lastname").setParameter("lastname", lastname).getResultList();
	}

	public List<Position> getClients() {
		return em.createQuery("FROM Client").getResultList();
	}
	
	public Position getClient(long clientid) {
		return (Position) em.createQuery("FROM Client c where c.id=:id").setParameter("id", clientid).getSingleResult();
	}
}
