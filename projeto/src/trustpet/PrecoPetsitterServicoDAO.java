/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: claudia(Universidade do Minho)
 * License Type: Academic
 */
package trustpet;

import org.orm.*;
import org.hibernate.Query;

import java.util.List;

public class PrecoPetsitterServicoDAO {
	public static PrecoPetsitterServico loadPrecoPetsitterServicoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return loadPrecoPetsitterServicoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico getPrecoPetsitterServicoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return getPrecoPetsitterServicoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico loadPrecoPetsitterServicoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return loadPrecoPetsitterServicoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico getPrecoPetsitterServicoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return getPrecoPetsitterServicoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico loadPrecoPetsitterServicoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (PrecoPetsitterServico) session.load(trustpet.PrecoPetsitterServico.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico getPrecoPetsitterServicoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (PrecoPetsitterServico) session.get(trustpet.PrecoPetsitterServico.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico loadPrecoPetsitterServicoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (PrecoPetsitterServico) session.load(trustpet.PrecoPetsitterServico.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico getPrecoPetsitterServicoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (PrecoPetsitterServico) session.get(trustpet.PrecoPetsitterServico.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPrecoPetsitterServico(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return queryPrecoPetsitterServico(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPrecoPetsitterServico(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return queryPrecoPetsitterServico(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico[] listPrecoPetsitterServicoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return listPrecoPetsitterServicoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico[] listPrecoPetsitterServicoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return listPrecoPetsitterServicoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPrecoPetsitterServico(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.PrecoPetsitterServico as PrecoPetsitterServico");
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
	
	public static List queryPrecoPetsitterServico(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.PrecoPetsitterServico as PrecoPetsitterServico");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("PrecoPetsitterServico", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico[] listPrecoPetsitterServicoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPrecoPetsitterServico(session, condition, orderBy);
			return (PrecoPetsitterServico[]) list.toArray(new PrecoPetsitterServico[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico[] listPrecoPetsitterServicoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPrecoPetsitterServico(session, condition, orderBy, lockMode);
			return (PrecoPetsitterServico[]) list.toArray(new PrecoPetsitterServico[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico loadPrecoPetsitterServicoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return loadPrecoPetsitterServicoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico loadPrecoPetsitterServicoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return loadPrecoPetsitterServicoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico loadPrecoPetsitterServicoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		PrecoPetsitterServico[] precoPetsitterServicos = listPrecoPetsitterServicoByQuery(session, condition, orderBy);
		if (precoPetsitterServicos != null && precoPetsitterServicos.length > 0)
			return precoPetsitterServicos[0];
		else
			return null;
	}
	
	public static PrecoPetsitterServico loadPrecoPetsitterServicoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		PrecoPetsitterServico[] precoPetsitterServicos = listPrecoPetsitterServicoByQuery(session, condition, orderBy, lockMode);
		if (precoPetsitterServicos != null && precoPetsitterServicos.length > 0)
			return precoPetsitterServicos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePrecoPetsitterServicoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return iteratePrecoPetsitterServicoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePrecoPetsitterServicoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustpetPersistentManager.instance().getSession();
			return iteratePrecoPetsitterServicoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePrecoPetsitterServicoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.PrecoPetsitterServico as PrecoPetsitterServico");
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
	
	public static java.util.Iterator iteratePrecoPetsitterServicoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.PrecoPetsitterServico as PrecoPetsitterServico");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("PrecoPetsitterServico", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico createPrecoPetsitterServico() {
		return new trustpet.PrecoPetsitterServico();
	}
	
	public static boolean save(trustpet.PrecoPetsitterServico precoPetsitterServico) throws PersistentException {
		try {
			TrustpetPersistentManager.instance().saveObject(precoPetsitterServico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(trustpet.PrecoPetsitterServico precoPetsitterServico) throws PersistentException {
		try {
			TrustpetPersistentManager.instance().deleteObject(precoPetsitterServico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(trustpet.PrecoPetsitterServico precoPetsitterServico) throws PersistentException {
		try {
			TrustpetPersistentManager.instance().getSession().refresh(precoPetsitterServico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(trustpet.PrecoPetsitterServico precoPetsitterServico) throws PersistentException {
		try {
			TrustpetPersistentManager.instance().getSession().evict(precoPetsitterServico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static PrecoPetsitterServico loadPrecoPetsitterServicoByCriteria(PrecoPetsitterServicoCriteria precoPetsitterServicoCriteria) {
		PrecoPetsitterServico[] precoPetsitterServicos = listPrecoPetsitterServicoByCriteria(precoPetsitterServicoCriteria);
		if(precoPetsitterServicos == null || precoPetsitterServicos.length == 0) {
			return null;
		}
		return precoPetsitterServicos[0];
	}
	
	public static PrecoPetsitterServico[] listPrecoPetsitterServicoByCriteria(PrecoPetsitterServicoCriteria precoPetsitterServicoCriteria) {
		return precoPetsitterServicoCriteria.listPrecoPetsitterServico();
	}
}
