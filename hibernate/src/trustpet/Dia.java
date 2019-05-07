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

public class Dia {
	public Dia() {
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
	
	private int id;
	
	private String dia;
	
	private java.util.Set ORM_horas = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDia(String value) {
		this.dia = value;
	}
	
	public String getDia() {
		return dia;
	}
	
	private void setORM_Horas(java.util.Set value) {
		this.ORM_horas = value;
	}
	
	private java.util.Set getORM_Horas() {
		return ORM_horas;
	}
	
	public final trustpet.HoraSetCollection horas = new trustpet.HoraSetCollection(this, _ormAdapter, ORMConstants.KEY_DIA_HORAS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
