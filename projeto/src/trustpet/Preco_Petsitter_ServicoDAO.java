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

public class Preco_Petsitter_ServicoDAO {
	public static Preco_Petsitter_Servico loadPreco_Petsitter_ServicoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return loadPreco_Petsitter_ServicoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico getPreco_Petsitter_ServicoByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return getPreco_Petsitter_ServicoByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico loadPreco_Petsitter_ServicoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return loadPreco_Petsitter_ServicoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico getPreco_Petsitter_ServicoByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return getPreco_Petsitter_ServicoByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico loadPreco_Petsitter_ServicoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Preco_Petsitter_Servico) session.load(trustpet.Preco_Petsitter_Servico.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico getPreco_Petsitter_ServicoByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (Preco_Petsitter_Servico) session.get(trustpet.Preco_Petsitter_Servico.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico loadPreco_Petsitter_ServicoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Preco_Petsitter_Servico) session.load(trustpet.Preco_Petsitter_Servico.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico getPreco_Petsitter_ServicoByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Preco_Petsitter_Servico) session.get(trustpet.Preco_Petsitter_Servico.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPreco_Petsitter_Servico(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return queryPreco_Petsitter_Servico(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPreco_Petsitter_Servico(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return queryPreco_Petsitter_Servico(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico[] listPreco_Petsitter_ServicoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return listPreco_Petsitter_ServicoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico[] listPreco_Petsitter_ServicoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return listPreco_Petsitter_ServicoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPreco_Petsitter_Servico(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.Preco_Petsitter_Servico as Preco_Petsitter_Servico");
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
	
	public static List queryPreco_Petsitter_Servico(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.Preco_Petsitter_Servico as Preco_Petsitter_Servico");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Preco_Petsitter_Servico", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico[] listPreco_Petsitter_ServicoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPreco_Petsitter_Servico(session, condition, orderBy);
			return (Preco_Petsitter_Servico[]) list.toArray(new Preco_Petsitter_Servico[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico[] listPreco_Petsitter_ServicoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPreco_Petsitter_Servico(session, condition, orderBy, lockMode);
			return (Preco_Petsitter_Servico[]) list.toArray(new Preco_Petsitter_Servico[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico loadPreco_Petsitter_ServicoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return loadPreco_Petsitter_ServicoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico loadPreco_Petsitter_ServicoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return loadPreco_Petsitter_ServicoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico loadPreco_Petsitter_ServicoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Preco_Petsitter_Servico[] preco_Petsitter_Servicos = listPreco_Petsitter_ServicoByQuery(session, condition, orderBy);
		if (preco_Petsitter_Servicos != null && preco_Petsitter_Servicos.length > 0)
			return preco_Petsitter_Servicos[0];
		else
			return null;
	}
	
	public static Preco_Petsitter_Servico loadPreco_Petsitter_ServicoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Preco_Petsitter_Servico[] preco_Petsitter_Servicos = listPreco_Petsitter_ServicoByQuery(session, condition, orderBy, lockMode);
		if (preco_Petsitter_Servicos != null && preco_Petsitter_Servicos.length > 0)
			return preco_Petsitter_Servicos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePreco_Petsitter_ServicoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return iteratePreco_Petsitter_ServicoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePreco_Petsitter_ServicoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ClassPersistentManager.instance().getSession();
			return iteratePreco_Petsitter_ServicoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePreco_Petsitter_ServicoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.Preco_Petsitter_Servico as Preco_Petsitter_Servico");
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
	
	public static java.util.Iterator iteratePreco_Petsitter_ServicoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.Preco_Petsitter_Servico as Preco_Petsitter_Servico");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Preco_Petsitter_Servico", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico createPreco_Petsitter_Servico() {
		return new trustpet.Preco_Petsitter_Servico();
	}
	
	public static boolean save(trustpet.Preco_Petsitter_Servico preco_Petsitter_Servico) throws PersistentException {
		try {
			ClassPersistentManager.instance().saveObject(preco_Petsitter_Servico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(trustpet.Preco_Petsitter_Servico preco_Petsitter_Servico) throws PersistentException {
		try {
			ClassPersistentManager.instance().deleteObject(preco_Petsitter_Servico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(trustpet.Preco_Petsitter_Servico preco_Petsitter_Servico) throws PersistentException {
		try {
			ClassPersistentManager.instance().getSession().refresh(preco_Petsitter_Servico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(trustpet.Preco_Petsitter_Servico preco_Petsitter_Servico) throws PersistentException {
		try {
			ClassPersistentManager.instance().getSession().evict(preco_Petsitter_Servico);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Preco_Petsitter_Servico loadPreco_Petsitter_ServicoByCriteria(Preco_Petsitter_ServicoCriteria preco_Petsitter_ServicoCriteria) {
		Preco_Petsitter_Servico[] preco_Petsitter_Servicos = listPreco_Petsitter_ServicoByCriteria(preco_Petsitter_ServicoCriteria);
		if(preco_Petsitter_Servicos == null || preco_Petsitter_Servicos.length == 0) {
			return null;
		}
		return preco_Petsitter_Servicos[0];
	}
	
	public static Preco_Petsitter_Servico[] listPreco_Petsitter_ServicoByCriteria(Preco_Petsitter_ServicoCriteria preco_Petsitter_ServicoCriteria) {
		return preco_Petsitter_ServicoCriteria.listPreco_Petsitter_Servico();
	}
}
