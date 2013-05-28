package br.com.kwikemart.utils;

import javax.transaction.Synchronization;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class DummyTransaction implements Transaction {

    public void begin() throws HibernateException {
        // TODO Auto-generated method stub

    }

    public void commit() throws HibernateException {
        // TODO Auto-generated method stub

    }

    public boolean isActive() throws HibernateException {
        // TODO Auto-generated method stub
        return false;
    }

    public void registerSynchronization(Synchronization arg0) throws HibernateException {
        // TODO Auto-generated method stub

    }

    public void rollback() throws HibernateException {
        // TODO Auto-generated method stub

    }

    public void setTimeout(int arg0) {
        // TODO Auto-generated method stub

    }

    public boolean wasCommitted() throws HibernateException {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean wasRolledBack() throws HibernateException {
        // TODO Auto-generated method stub
        return false;
    }

}
