package ch.hevs.ClassificationService;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import ch.hevs.businessobject.Position;
import ch.hevs.businessobject.Athlete;
import ch.hevs.exception.OlympicsException;


@Stateful
public class ClassificationBean implements Classification {
	
	
}
