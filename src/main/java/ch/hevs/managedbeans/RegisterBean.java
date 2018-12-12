package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Sport;
import ch.hevs.businessobject.Position;
import ch.hevs.registryservice.Olympics;

/**
 * TransferBean.java
 * 
 */

public class RegisterBean
{
    private List<Position> positions;
    private List<String> clientNames;
    private List<String> sourceAccountDescriptions;
    private List<String> destinationAccountDescriptions;
    private String sourceAccountDescription;
    private String destinationAccountDescription;
    private String sourceClientName;
    private String destinationClientName;
    private String transactionResult;
    private int transactionAmount;
    private Olympics olympics;
    
    @PostConstruct
    public void initialize() throws NamingException {
    	
    	// use JNDI to inject reference to bank EJB
    	InitialContext ctx = new InitialContext();
		olympics = (Olympics) ctx.lookup("java:global/TP13-WEB-SECURE-E-0.0.1-SNAPSHOT/BankBean!ch.hevs.bankservice.Bank");    	
			
    	// get clients
		List<Position> clientList = olympics.getClients();
		this.clientNames = new ArrayList<String>();
		for (Position position : clientList) {
			this.clientNames.add(position.getLastname());
		}
		
		// initialize account descriptions
		this.sourceAccountDescriptions = new ArrayList<String>();
		this.destinationAccountDescriptions = new ArrayList<String>();
		List<Sport> accounts = olympics.getAccountListFromClientLastname(clientList.get(0).getLastname());
		this.sourceAccountDescriptions.add(accounts.get(0).getDescription());
		this.destinationAccountDescriptions.add(accounts.get(0).getDescription());
    }
    
    // transactionAmount
    public int getTransactionAmount () {
    	return transactionAmount;
    }
    public void setTransactionAmount (final int transactionAmount) {
    	this.transactionAmount=transactionAmount;
    }
    
    // sourceClientName
    public String getSourceClientName () {
    	return sourceClientName;
    }
    public void setSourceClientName (final String sourceClientName) {
    	this.sourceClientName=sourceClientName;
    }
    
    // sourceAccountDescriptions
    public List<String> getSourceAccountDescriptions () {
    	return sourceAccountDescriptions;
    }
    
    // destinationAccountDescriptions
    public List<String> getDestinationAccountDescriptions () {
    	return destinationAccountDescriptions;
    }
    
    // destinationClientName
    public String getDestinationClientName () {
    	return destinationClientName;
    }
    public void setDestinationClientName (final String destinationClientName) {
    	this.destinationClientName=destinationClientName;
    }
    
    // transactionResult
    public String getTransactionResult () {
    	return transactionResult;
    }
	public void setTransactionResult(String transactionResult) {
		this.transactionResult = transactionResult;
	}
    
	// sourceAccountDescription
    public String getSourceAccountDescription() {
		return sourceAccountDescription;
	}
	public void setSourceAccountDescription(String sourceAccountDescription) {
		this.sourceAccountDescription = sourceAccountDescription;
	}

	// destinationAccountDescription
	public String getDestinationAccountDescription() {
		return destinationAccountDescription;
	}
	public void setDestinationAccountDescription(
			String destinationAccountDescription) {
		this.destinationAccountDescription = destinationAccountDescription;
	}

	public void updateSourceAccounts(ValueChangeEvent event) {
    	this.sourceClientName = (String)event.getNewValue();
    	
	    List<Sport> accounts = olympics.getAccountListFromClientLastname(this.sourceClientName);
	    this.sourceAccountDescriptions = new ArrayList<String>();
		for (Sport account : accounts) {
			this.sourceAccountDescriptions.add(account.getDescription());
		}
    }
	public void updateDestinationAccounts(ValueChangeEvent event) {
    	this.destinationClientName = (String)event.getNewValue();
			
	    List<Sport> accounts = olympics.getAccountListFromClientLastname(this.destinationClientName);
	    this.destinationAccountDescriptions = new ArrayList<String>();
		for (Sport account : accounts) {
			this.destinationAccountDescriptions.add(account.getDescription());
		}
    }

    public List<Position> getClients() {
		return positions;
    }
    
    public List<String> getClientNames() {
    	return clientNames;
    }
    
    
    public String performTransfer() {
    	
    	try {
			if (sourceClientName.equals(destinationClientName) && sourceAccountDescription.equals(destinationAccountDescription)) {
				
				this.transactionResult="Error: accounts are identical!";
			} 
			else {
				
				Sport compteSrc = olympics.getAccount(sourceAccountDescription, sourceClientName);
				Sport compteDest = olympics.getAccount(destinationAccountDescription, destinationClientName);
	
				// Transfer
				this.transactionResult=olympics.transfer(compteSrc, compteDest, transactionAmount);
			}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}

		return "showTransferResult"; //  the String value returned represents the outcome used by the navigation handler to determine what page to display next.
	} 
}