/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Joana(Universidade do Minho)
 * License Type: Academic
 */
package main;

import org.hibernate.Query;
import org.orm.PersistentException;
import org.orm.PersistentSession;

import java.util.List;

public class PetsitterDAO {
	public static Petsitter loadPetsitterByORMID(String email) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadPetsitterByORMID(session, email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter getPetsitterByORMID(String email) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return getPetsitterByORMID(session, email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter loadPetsitterByORMID(String email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadPetsitterByORMID(session, email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter getPetsitterByORMID(String email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return getPetsitterByORMID(session, email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter loadPetsitterByORMID(PersistentSession session, String email) throws PersistentException {
		try {
			return (Petsitter) session.load(main.Petsitter.class, email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter getPetsitterByORMID(PersistentSession session, String email) throws PersistentException {
		try {
			return (Petsitter) session.get(main.Petsitter.class, email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter loadPetsitterByORMID(PersistentSession session, String email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Petsitter) session.load(main.Petsitter.class, email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter getPetsitterByORMID(PersistentSession session, String email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Petsitter) session.get(main.Petsitter.class, email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPetsitter(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return queryPetsitter(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPetsitter(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return queryPetsitter(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter[] listPetsitterByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return listPetsitterByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter[] listPetsitterByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return listPetsitterByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPetsitter(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Petsitter as Petsitter");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPetsitter(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Petsitter as Petsitter");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Petsitter", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter[] listPetsitterByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPetsitter(session, condition, orderBy);
			return (Petsitter[]) list.toArray(new Petsitter[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter[] listPetsitterByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPetsitter(session, condition, orderBy, lockMode);
			return (Petsitter[]) list.toArray(new Petsitter[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter loadPetsitterByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadPetsitterByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter loadPetsitterByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadPetsitterByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter loadPetsitterByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Petsitter[] petsitters = listPetsitterByQuery(session, condition, orderBy);
		if (petsitters != null && petsitters.length > 0)
			return petsitters[0];
		else
			return null;
	}
	
	public static Petsitter loadPetsitterByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Petsitter[] petsitters = listPetsitterByQuery(session, condition, orderBy, lockMode);
		if (petsitters != null && petsitters.length > 0)
			return petsitters[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePetsitterByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return iteratePetsitterByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePetsitterByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return iteratePetsitterByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePetsitterByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Petsitter as Petsitter");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePetsitterByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Petsitter as Petsitter");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Petsitter", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter createPetsitter() {
		return new main.Petsitter();
	}
	
	public static boolean save(main.Petsitter petsitter) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().saveObject(petsitter);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.Petsitter petsitter) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().deleteObject(petsitter);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.Petsitter petsitter) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().getSession().refresh(petsitter);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.Petsitter petsitter) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().getSession().evict(petsitter);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Petsitter loadPetsitterByCriteria(PetsitterCriteria petsitterCriteria) {
		Petsitter[] petsitters = listPetsitterByCriteria(petsitterCriteria);
		if(petsitters == null || petsitters.length == 0) {
			return null;
		}
		return petsitters[0];
	}
	
	public static Petsitter[] listPetsitterByCriteria(PetsitterCriteria petsitterCriteria) {
		return petsitterCriteria.listPetsitter();
	}
}
