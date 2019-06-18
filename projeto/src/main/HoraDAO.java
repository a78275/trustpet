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

public class HoraDAO {
	public static Hora loadHoraByORMID(int hora) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadHoraByORMID(session, hora);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora getHoraByORMID(int hora) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return getHoraByORMID(session, hora);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora loadHoraByORMID(int hora, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadHoraByORMID(session, hora, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora getHoraByORMID(int hora, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return getHoraByORMID(session, hora, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora loadHoraByORMID(PersistentSession session, int hora) throws PersistentException {
		try {
			return (Hora) session.load(main.Hora.class, new Integer(hora));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora getHoraByORMID(PersistentSession session, int hora) throws PersistentException {
		try {
			return (Hora) session.get(main.Hora.class, new Integer(hora));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora loadHoraByORMID(PersistentSession session, int hora, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Hora) session.load(main.Hora.class, new Integer(hora), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora getHoraByORMID(PersistentSession session, int hora, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Hora) session.get(main.Hora.class, new Integer(hora), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHora(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return queryHora(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHora(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return queryHora(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora[] listHoraByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return listHoraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora[] listHoraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return listHoraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHora(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Hora as Hora");
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
	
	public static List queryHora(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Hora as Hora");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Hora", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora[] listHoraByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryHora(session, condition, orderBy);
			return (Hora[]) list.toArray(new Hora[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora[] listHoraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryHora(session, condition, orderBy, lockMode);
			return (Hora[]) list.toArray(new Hora[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora loadHoraByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadHoraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora loadHoraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadHoraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora loadHoraByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Hora[] horas = listHoraByQuery(session, condition, orderBy);
		if (horas != null && horas.length > 0)
			return horas[0];
		else
			return null;
	}
	
	public static Hora loadHoraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Hora[] horas = listHoraByQuery(session, condition, orderBy, lockMode);
		if (horas != null && horas.length > 0)
			return horas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateHoraByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return iterateHoraByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHoraByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return iterateHoraByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHoraByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Hora as Hora");
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
	
	public static java.util.Iterator iterateHoraByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Hora as Hora");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Hora", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora createHora() {
		return new main.Hora();
	}
	
	public static boolean save(main.Hora hora) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().saveObject(hora);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.Hora hora) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().deleteObject(hora);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.Hora hora) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().getSession().refresh(hora);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.Hora hora) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().getSession().evict(hora);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Hora loadHoraByCriteria(HoraCriteria horaCriteria) {
		Hora[] horas = listHoraByCriteria(horaCriteria);
		if(horas == null || horas.length == 0) {
			return null;
		}
		return horas[0];
	}
	
	public static Hora[] listHoraByCriteria(HoraCriteria horaCriteria) {
		return horaCriteria.listHora();
	}
}
