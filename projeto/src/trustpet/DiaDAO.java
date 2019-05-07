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
package trustpet;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class DiaDAO {
	public static Dia loadDiaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return loadDiaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia getDiaByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return getDiaByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia loadDiaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return loadDiaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia getDiaByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return getDiaByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia loadDiaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Dia) session.load(trustpet.Dia.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia getDiaByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Dia) session.get(trustpet.Dia.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia loadDiaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Dia) session.load(trustpet.Dia.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia getDiaByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Dia) session.get(trustpet.Dia.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDia(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return queryDia(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDia(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return queryDia(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia[] listDiaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return listDiaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia[] listDiaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return listDiaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryDia(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.Dia as Dia");
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
		StringBuffer sb = new StringBuffer("From trustpet.Dia as Dia");
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
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return loadDiaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Dia loadDiaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
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
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return iterateDiaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDiaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return iterateDiaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateDiaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.Dia as Dia");
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
		StringBuffer sb = new StringBuffer("From trustpet.Dia as Dia");
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
		return new trustpet.Dia();
	}
	
	public static boolean save(trustpet.Dia dia) throws PersistentException {
		try {
			ClassPersistentManager.instance().saveObject(dia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(trustpet.Dia dia) throws PersistentException {
		try {
			ClassPersistentManager.instance().deleteObject(dia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(trustpet.Dia dia) throws PersistentException {
		try {
			ClassPersistentManager.instance().getSession().refresh(dia);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(trustpet.Dia dia) throws PersistentException {
		try {
			ClassPersistentManager.instance().getSession().evict(dia);
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
