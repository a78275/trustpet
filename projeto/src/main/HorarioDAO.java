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

public class HorarioDAO {
	public static Horario loadHorarioByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadHorarioByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario getHorarioByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return getHorarioByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario loadHorarioByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadHorarioByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario getHorarioByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return getHorarioByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario loadHorarioByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Horario) session.load(main.Horario.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario getHorarioByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Horario) session.get(main.Horario.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario loadHorarioByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Horario) session.load(main.Horario.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario getHorarioByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Horario) session.get(main.Horario.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHorario(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return queryHorario(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHorario(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return queryHorario(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario[] listHorarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return listHorarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario[] listHorarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return listHorarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryHorario(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Horario as Horario");
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
	
	public static List queryHorario(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Horario as Horario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Horario", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario[] listHorarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryHorario(session, condition, orderBy);
			return (Horario[]) list.toArray(new Horario[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario[] listHorarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryHorario(session, condition, orderBy, lockMode);
			return (Horario[]) list.toArray(new Horario[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario loadHorarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadHorarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario loadHorarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadHorarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario loadHorarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Horario[] horarios = listHorarioByQuery(session, condition, orderBy);
		if (horarios != null && horarios.length > 0)
			return horarios[0];
		else
			return null;
	}
	
	public static Horario loadHorarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Horario[] horarios = listHorarioByQuery(session, condition, orderBy, lockMode);
		if (horarios != null && horarios.length > 0)
			return horarios[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateHorarioByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return iterateHorarioByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHorarioByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return iterateHorarioByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateHorarioByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Horario as Horario");
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
	
	public static java.util.Iterator iterateHorarioByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Horario as Horario");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Horario", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario createHorario() {
		return new main.Horario();
	}
	
	public static boolean save(main.Horario horario) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().saveObject(horario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.Horario horario) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().deleteObject(horario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.Horario horario) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().getSession().refresh(horario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.Horario horario) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().getSession().evict(horario);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Horario loadHorarioByCriteria(HorarioCriteria horarioCriteria) {
		Horario[] horarios = listHorarioByCriteria(horarioCriteria);
		if(horarios == null || horarios.length == 0) {
			return null;
		}
		return horarios[0];
	}
	
	public static Horario[] listHorarioByCriteria(HorarioCriteria horarioCriteria) {
		return horarioCriteria.listHorario();
	}
}
