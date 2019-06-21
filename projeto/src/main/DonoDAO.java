/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: bernardo(Universidade do Minho)
 * License Type: Academic
 */
package main;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class DonoDAO {
	public static Dono loadDonoByORMID(String email) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return loadDonoByORMID(session, email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono getDonoByORMID(String email) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return getDonoByORMID(session, email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono loadDonoByORMID(String email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return loadDonoByORMID(session, email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono getDonoByORMID(String email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return getDonoByORMID(session, email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono loadDonoByORMID(PersistentSession session, String email) throws PersistentException {
		try {
			return (Dono) session.load(main.Dono.class, email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono getDonoByORMID(PersistentSession session, String email) throws PersistentException {
		try {
			return (Dono) session.get(main.Dono.class, email);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono loadDonoByORMID(PersistentSession session, String email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Dono) session.load(main.Dono.class, email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono getDonoByORMID(PersistentSession session, String email, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Dono) session.get(main.Dono.class, email, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDono(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return queryDono(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDono(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return queryDono(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono[] listDonoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return listDonoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono[] listDonoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return listDonoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDono(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Dono as Dono");
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
	
	public static List queryDono(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Dono as Dono");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Dono", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono[] listDonoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDono(session, condition, orderBy);
			return (Dono[]) list.toArray(new Dono[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono[] listDonoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDono(session, condition, orderBy, lockMode);
			return (Dono[]) list.toArray(new Dono[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono loadDonoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return loadDonoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono loadDonoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return loadDonoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono loadDonoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Dono[] donos = listDonoByQuery(session, condition, orderBy);
		if (donos != null && donos.length > 0)
			return donos[0];
		else
			return null;
	}
	
	public static Dono loadDonoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Dono[] donos = listDonoByQuery(session, condition, orderBy, lockMode);
		if (donos != null && donos.length > 0)
			return donos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDonoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return iterateDonoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDonoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return iterateDonoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDonoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Dono as Dono");
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
	
	public static java.util.Iterator iterateDonoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Dono as Dono");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Dono", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono createDono() {
		return new main.Dono();
	}
	
	public static boolean save(main.Dono dono) throws PersistentException {
		try {
			TrustpetPersistentManager.instance().saveObject(dono);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.Dono dono) throws PersistentException {
		try {
			TrustpetPersistentManager.instance().deleteObject(dono);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.Dono dono) throws PersistentException {
		try {
			TrustpetPersistentManager.instance().getSession().refresh(dono);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.Dono dono) throws PersistentException {
		try {
			TrustpetPersistentManager.instance().getSession().evict(dono);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dono loadDonoByCriteria(DonoCriteria donoCriteria) {
		Dono[] donos = listDonoByCriteria(donoCriteria);
		if(donos == null || donos.length == 0) {
			return null;
		}
		return donos[0];
	}
	
	public static Dono[] listDonoByCriteria(DonoCriteria donoCriteria) {
		return donoCriteria.listDono();
	}
}
