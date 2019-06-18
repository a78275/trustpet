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

public class DiaDAO {
	public static Dia loadDiaByORMID(String dia) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadDiaByORMID(session, dia);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia getDiaByORMID(String dia) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return getDiaByORMID(session, dia);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia loadDiaByORMID(String dia, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadDiaByORMID(session, dia, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia getDiaByORMID(String dia, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return getDiaByORMID(session, dia, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia loadDiaByORMID(PersistentSession session, String dia) throws PersistentException {
		try {
			return (Dia) session.load(main.Dia.class, dia);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia getDiaByORMID(PersistentSession session, String dia) throws PersistentException {
		try {
			return (Dia) session.get(main.Dia.class, dia);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia loadDiaByORMID(PersistentSession session, String dia, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Dia) session.load(main.Dia.class, dia, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia getDiaByORMID(PersistentSession session, String dia, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Dia) session.get(main.Dia.class, dia, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDia(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return queryDia(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDia(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return queryDia(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia[] listDiaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return listDiaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia[] listDiaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return listDiaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDia(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Dia as Dia");
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
	
	public static List queryDia(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Dia as Dia");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Dia", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia[] listDiaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryDia(session, condition, orderBy);
			return (Dia[]) list.toArray(new Dia[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia[] listDiaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryDia(session, condition, orderBy, lockMode);
			return (Dia[]) list.toArray(new Dia[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia loadDiaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadDiaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia loadDiaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadDiaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia loadDiaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Dia[] dias = listDiaByQuery(session, condition, orderBy);
		if (dias != null && dias.length > 0)
			return dias[0];
		else
			return null;
	}
	
	public static Dia loadDiaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Dia[] dias = listDiaByQuery(session, condition, orderBy, lockMode);
		if (dias != null && dias.length > 0)
			return dias[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateDiaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return iterateDiaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDiaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return iterateDiaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDiaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Dia as Dia");
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
	
	public static java.util.Iterator iterateDiaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Dia as Dia");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Dia", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia createDia() {
		return new main.Dia();
	}
	
	public static boolean save(main.Dia dia) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().saveObject(dia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.Dia dia) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().deleteObject(dia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.Dia dia) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().getSession().refresh(dia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.Dia dia) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().getSession().evict(dia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia loadDiaByCriteria(DiaCriteria diaCriteria) {
		Dia[] dias = listDiaByCriteria(diaCriteria);
		if(dias == null || dias.length == 0) {
			return null;
		}
		return dias[0];
	}
	
	public static Dia[] listDiaByCriteria(DiaCriteria diaCriteria) {
		return diaCriteria.listDia();
	}
}
