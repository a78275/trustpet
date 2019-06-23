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
package main;

public class Servico {
	public Servico() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_SERVICO_TIPOANIMAIS) {
			return ORM_tipoAnimais;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private String designacao;
	
	private java.util.Set ORM_tipoAnimais = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setDesignacao(String value) {
		this.designacao = value;
	}
	
	public String getDesignacao() {
		return designacao;
	}
	
	private void setORM_TipoAnimais(java.util.Set value) {
		this.ORM_tipoAnimais = value;
	}
	
	private java.util.Set getORM_TipoAnimais() {
		return ORM_tipoAnimais;
	}
	
	public final main.TipoAnimalSetCollection tipoAnimais = new main.TipoAnimalSetCollection(this, _ormAdapter, ORMConstants.KEY_SERVICO_TIPOANIMAIS, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
