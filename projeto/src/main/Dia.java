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

public class Dia {
	public Dia() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Dia))
			return false;
		Dia dia = (Dia)aObj;
		if ((getDia() != null && !getDia().equals(dia.getDia())) || (getDia() == null && dia.getDia() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getDia() == null ? 0 : getDia().hashCode());
		return hashcode;
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_DIA_HORAS) {
			return ORM_horas;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private String dia;
	
	private java.util.Set ORM_horas = new java.util.HashSet();
	
	public void setDia(String value) {
		this.dia = value;
	}
	
	public String getDia() {
		return dia;
	}
	
	public String getORMID() {
		return getDia();
	}
	
	private void setORM_Horas(java.util.Set value) {
		this.ORM_horas = value;
	}
	
	private java.util.Set getORM_Horas() {
		return ORM_horas;
	}
	
	public final main.HoraSetCollection horas = new main.HoraSetCollection(this, _ormAdapter, ORMConstants.KEY_DIA_HORAS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getDia());
	}
	
}
