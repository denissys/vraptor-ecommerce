package br.com.kwikemart.utils;

import java.io.Serializable;
import java.sql.Connection;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.EntityMode;
import org.hibernate.Filter;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.LobHelper;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.ReplicationMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TypeHelper;
import org.hibernate.UnknownProfileException;
import org.hibernate.jdbc.Work;
import org.hibernate.stat.SessionStatistics;

public class DummySession implements Session {

    private static final long serialVersionUID = 1L;

    public Transaction beginTransaction() throws HibernateException {
        return new DummyTransaction();
    }

    public LockRequest buildLockRequest(LockOptions arg0) {
        return null;
    }

    public void cancelQuery() throws HibernateException {
        
    }

    public void clear() {
        
    }

    public Connection close() throws HibernateException {
        return null;
    }

    public Connection connection() throws HibernateException {
        return null;
    }

    public boolean contains(Object arg0) {
        return false;
    }

    @SuppressWarnings("rawtypes")
	public Criteria createCriteria(Class arg0) {
        return null;
    }

    public Criteria createCriteria(String arg0) {
        return null;
    }

	@SuppressWarnings("rawtypes")
	public Criteria createCriteria(Class arg0, String arg1) {
        return null;
    }

    public Criteria createCriteria(String arg0, String arg1) {
        return null;
    }

    public Query createFilter(Object arg0, String arg1) throws HibernateException {
        return null;
    }

    public Query createQuery(String arg0) throws HibernateException {
        return null;
    }

    public SQLQuery createSQLQuery(String arg0) throws HibernateException {
        return null;
    }

    public void delete(Object arg0) throws HibernateException {
        
    }

    public void delete(String arg0, Object arg1) throws HibernateException {
        
    }

    public void disableFetchProfile(String arg0) throws UnknownProfileException {
        
    }

    public void disableFilter(String arg0) {
        
    }

    public Connection disconnect() throws HibernateException {
        return null;
    }

    public void doWork(Work arg0) throws HibernateException {
        
    }

    public void enableFetchProfile(String arg0) throws UnknownProfileException {
        
    }

    public Filter enableFilter(String arg0) {
        return null;
    }

    public void evict(Object arg0) throws HibernateException {
        
    }

    public void flush() throws HibernateException {
        
    }

	@SuppressWarnings("rawtypes")
    public Object get(Class arg0, Serializable arg1) throws HibernateException {
        return null;
    }

    public Object get(String arg0, Serializable arg1) throws HibernateException {
        return null;
    }

	@SuppressWarnings("rawtypes")
	public Object get(Class arg0, Serializable arg1, LockMode arg2)
			throws HibernateException {
        return null;
    }

	@SuppressWarnings("rawtypes")
	public Object get(Class arg0, Serializable arg1, LockOptions arg2)
			throws HibernateException {
        return null;
    }

    public Object get(String arg0, Serializable arg1, LockMode arg2) throws HibernateException {
        return null;
    }

    public Object get(String arg0, Serializable arg1, LockOptions arg2) throws HibernateException {
        return null;
    }

    public CacheMode getCacheMode() {
        return null;
    }

    public LockMode getCurrentLockMode(Object arg0) throws HibernateException {
        return null;
    }

    public Filter getEnabledFilter(String arg0) {
        return null;
    }

    public EntityMode getEntityMode() {
        return null;
    }

    public String getEntityName(Object arg0) throws HibernateException {
        return null;
    }

    public FlushMode getFlushMode() {
        return null;
    }

    public Serializable getIdentifier(Object arg0) throws HibernateException {
        return null;
    }

    public LobHelper getLobHelper() {
        return null;
    }

    public Query getNamedQuery(String arg0) throws HibernateException {
        return null;
    }

    public Session getSession(EntityMode arg0) {
        return null;
    }

    public SessionFactory getSessionFactory() {
        return null;
    }

    public SessionStatistics getStatistics() {
        return null;
    }

    public Transaction getTransaction() {
        return null;
    }

    public TypeHelper getTypeHelper() {
        return null;
    }

    public boolean isConnected() {
        return false;
    }

    public boolean isDefaultReadOnly() {
        return false;
    }

    public boolean isDirty() throws HibernateException {
        return false;
    }

    public boolean isFetchProfileEnabled(String arg0) throws UnknownProfileException {
        return false;
    }

    public boolean isOpen() {
        return false;
    }

    public boolean isReadOnly(Object arg0) {
        return false;
    }

	@SuppressWarnings("rawtypes")
    public Object load(Class arg0, Serializable arg1) throws HibernateException {
        return null;
    }

    public Object load(String arg0, Serializable arg1) throws HibernateException {
        return null;
    }

    public void load(Object arg0, Serializable arg1) throws HibernateException {
        
    }

	@SuppressWarnings("rawtypes")
    public Object load(Class arg0, Serializable arg1, LockMode arg2) throws HibernateException {
        return null;
    }

	@SuppressWarnings("rawtypes")
    public Object load(Class arg0, Serializable arg1, LockOptions arg2) throws HibernateException {
        return null;
    }

    public Object load(String arg0, Serializable arg1, LockMode arg2) throws HibernateException {
        return null;
    }

    public Object load(String arg0, Serializable arg1, LockOptions arg2) throws HibernateException {
        return null;
    }

    public void lock(Object arg0, LockMode arg1) throws HibernateException {
        
    }

    public void lock(String arg0, Object arg1, LockMode arg2) throws HibernateException {
        
    }

    public Object merge(Object arg0) throws HibernateException {
        return null;
    }

    public Object merge(String arg0, Object arg1) throws HibernateException {
        return null;
    }

    public void persist(Object arg0) throws HibernateException {
        
    }

    public void persist(String arg0, Object arg1) throws HibernateException {
        
    }

    public void reconnect() throws HibernateException {
        
    }

    public void reconnect(Connection arg0) throws HibernateException {
        
    }

    public void refresh(Object arg0) throws HibernateException {
        
    }

    public void refresh(Object arg0, LockMode arg1) throws HibernateException {
        
    }

    public void refresh(Object arg0, LockOptions arg1) throws HibernateException {
        
    }

    public void replicate(Object arg0, ReplicationMode arg1) throws HibernateException {
        
    }

    public void replicate(String arg0, Object arg1, ReplicationMode arg2) throws HibernateException {
        
    }

    public Serializable save(Object arg0) throws HibernateException {
        return null;
    }

    public Serializable save(String arg0, Object arg1) throws HibernateException {
        return null;
    }

    public void saveOrUpdate(Object arg0) throws HibernateException {
        
    }

    public void saveOrUpdate(String arg0, Object arg1) throws HibernateException {
        
    }

    public void setCacheMode(CacheMode arg0) {
        
    }

    public void setDefaultReadOnly(boolean arg0) {
        
    }

    public void setFlushMode(FlushMode arg0) {
        
    }

    public void setReadOnly(Object arg0, boolean arg1) {
        
    }

    public void update(Object arg0) throws HibernateException {
        
    }

    public void update(String arg0, Object arg1) throws HibernateException {
        
    }
    
}