package br.com.kwikemart.utils;

import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;

/**
 * @author Caelum
 * @author Denis Santos 
 * 
 */
@Component
@RequestScoped
public class SessionCreator implements ComponentFactory<Session> {

    private final static Logger logger = Logger.getLogger(SessionCreator.class);
    
    private final SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public SessionCreator(SessionFactory factory) {
        this.factory = factory;
    }

    @PostConstruct
    public void create() {
        
        try {
            this.session = factory.openSession();
            checkConnection();
        } catch (Exception e) {
            logger.warn("SessionCreator.create(), hibernate connection isClosed = true => return DummySession()");
            this.session = new DummySession();
        }
    }

    /**
     * This method throws an exception when there is no connection 
     * 
     * @throws SQLException
     */
    @SuppressWarnings("deprecation")
	private void checkConnection() throws SQLException {
        session.connection().isClosed();
    }

    public Session getInstance() {
    	transaction = session.getTransaction();
    	transaction.begin();
        return session;
    }

    @PreDestroy
    public void destroy() {
    	try {
    		transaction.commit();
    	} catch (Exception e) {
    		logger.error("br.com.kwikemart.utils.SessionCreator => destroy(): commit fail.", e);
    		transaction.rollback();
    		logger.info("br.com.kwikemart.utils.SessionCreator => destroy(): rollback executed.");
    	} finally {
    		this.session.close();
    	}
    }
}