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

public class Horario {
	public Horario() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_HORARIO_DIAS) {
			return ORM_dias;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private java.util.Set ORM_dias = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	private void setORM_Dias(java.util.Set value) {
		this.ORM_dias = value;
	}
	
	private java.util.Set getORM_Dias() {
		return ORM_dias;
	}
	
	public final trustpet.DiaSetCollection dias = new trustpet.DiaSetCollection(this, _ormAdapter, ORMConstants.KEY_HORARIO_DIAS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
