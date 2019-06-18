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

import java.util.List;

public class TipoAnimalDAO {
	public static TipoAnimal loadTipoAnimalByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadTipoAnimalByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal getTipoAnimalByORMID(int id) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return getTipoAnimalByORMID(session, id);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal loadTipoAnimalByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadTipoAnimalByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal getTipoAnimalByORMID(int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return getTipoAnimalByORMID(session, id, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal loadTipoAnimalByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (TipoAnimal) session.load(trustpet.TipoAnimal.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal getTipoAnimalByORMID(PersistentSession session, int id) throws PersistentException {
		try {
			return (TipoAnimal) session.get(trustpet.TipoAnimal.class, new Integer(id));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal loadTipoAnimalByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (TipoAnimal) session.load(trustpet.TipoAnimal.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal getTipoAnimalByORMID(PersistentSession session, int id, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (TipoAnimal) session.get(trustpet.TipoAnimal.class, new Integer(id), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTipoAnimal(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return queryTipoAnimal(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTipoAnimal(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return queryTipoAnimal(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal[] listTipoAnimalByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return listTipoAnimalByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal[] listTipoAnimalByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return listTipoAnimalByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryTipoAnimal(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.TipoAnimal as TipoAnimal");
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
	
	public static List queryTipoAnimal(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.TipoAnimal as TipoAnimal");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TipoAnimal", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal[] listTipoAnimalByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryTipoAnimal(session, condition, orderBy);
			return (TipoAnimal[]) list.toArray(new TipoAnimal[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal[] listTipoAnimalByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryTipoAnimal(session, condition, orderBy, lockMode);
			return (TipoAnimal[]) list.toArray(new TipoAnimal[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal loadTipoAnimalByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadTipoAnimalByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal loadTipoAnimalByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return loadTipoAnimalByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal loadTipoAnimalByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		TipoAnimal[] tipoAnimals = listTipoAnimalByQuery(session, condition, orderBy);
		if (tipoAnimals != null && tipoAnimals.length > 0)
			return tipoAnimals[0];
		else
			return null;
	}
	
	public static TipoAnimal loadTipoAnimalByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		TipoAnimal[] tipoAnimals = listTipoAnimalByQuery(session, condition, orderBy, lockMode);
		if (tipoAnimals != null && tipoAnimals.length > 0)
			return tipoAnimals[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateTipoAnimalByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return iterateTipoAnimalByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTipoAnimalByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = TrustPetPersistentManager.instance().getSession();
			return iterateTipoAnimalByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateTipoAnimalByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.TipoAnimal as TipoAnimal");
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
	
	public static java.util.Iterator iterateTipoAnimalByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From trustpet.TipoAnimal as TipoAnimal");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("TipoAnimal", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal createTipoAnimal() {
		return new trustpet.TipoAnimal();
	}
	
	public static boolean save(trustpet.TipoAnimal tipoAnimal) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().saveObject(tipoAnimal);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(trustpet.TipoAnimal tipoAnimal) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().deleteObject(tipoAnimal);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(trustpet.TipoAnimal tipoAnimal) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().getSession().refresh(tipoAnimal);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(trustpet.TipoAnimal tipoAnimal) throws PersistentException {
		try {
			TrustPetPersistentManager.instance().getSession().evict(tipoAnimal);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static TipoAnimal loadTipoAnimalByCriteria(TipoAnimalCriteria tipoAnimalCriteria) {
		TipoAnimal[] tipoAnimals = listTipoAnimalByCriteria(tipoAnimalCriteria);
		if(tipoAnimals == null || tipoAnimals.length == 0) {
			return null;
		}
		return tipoAnimals[0];
	}
	
	public static TipoAnimal[] listTipoAnimalByCriteria(TipoAnimalCriteria tipoAnimalCriteria) {
		return tipoAnimalCriteria.listTipoAnimal();
	}
}
