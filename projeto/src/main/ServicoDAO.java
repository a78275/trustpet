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

public class ServicoDAO {
	public static Servico loadServicoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return loadServicoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico getServicoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return getServicoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico loadServicoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return loadServicoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico getServicoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return getServicoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico loadServicoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Servico) session.load(main.Servico.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico getServicoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Servico) session.get(main.Servico.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico loadServicoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Servico) session.load(main.Servico.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico getServicoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Servico) session.get(main.Servico.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryServico(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return queryServico(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryServico(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return queryServico(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico[] listServicoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return listServicoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico[] listServicoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return listServicoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryServico(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Servico as Servico");
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
	
	public static List queryServico(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Servico as Servico");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Servico", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico[] listServicoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryServico(session, condition, orderBy);
			return (Servico[]) list.toArray(new Servico[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico[] listServicoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryServico(session, condition, orderBy, lockMode);
			return (Servico[]) list.toArray(new Servico[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico loadServicoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return loadServicoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico loadServicoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return loadServicoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico loadServicoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Servico[] servicos = listServicoByQuery(session, condition, orderBy);
		if (servicos != null && servicos.length > 0)
			return servicos[0];
		else
			return null;
	}
	
	public static Servico loadServicoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Servico[] servicos = listServicoByQuery(session, condition, orderBy, lockMode);
		if (servicos != null && servicos.length > 0)
			return servicos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateServicoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return iterateServicoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateServicoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return iterateServicoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateServicoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Servico as Servico");
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
	
	public static java.util.Iterator iterateServicoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From main.Servico as Servico");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Servico", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico createServico() {
		return new main.Servico();
	}
	
	public static boolean save(main.Servico servico) throws PersistentException {
		try {
			TrustpetPersistentManager.instance().saveObject(servico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(main.Servico servico) throws PersistentException {
		try {
			TrustpetPersistentManager.instance().deleteObject(servico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(main.Servico servico) throws PersistentException {
		try {
			TrustpetPersistentManager.instance().getSession().refresh(servico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(main.Servico servico) throws PersistentException {
		try {
			TrustpetPersistentManager.instance().getSession().evict(servico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Servico loadServicoByCriteria(ServicoCriteria servicoCriteria) {
		Servico[] servicos = listServicoByCriteria(servicoCriteria);
		if(servicos == null || servicos.length == 0) {
			return null;
		}
		return servicos[0];
	}
	
	public static Servico[] listServicoByCriteria(ServicoCriteria servicoCriteria) {
		return servicoCriteria.listServico();
	}
}
