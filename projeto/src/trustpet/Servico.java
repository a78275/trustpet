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

public class Servico {
	public Servico() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_SERVICO_PRECO_SERVICO) {
			return ORM_preco_servico;
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
	
	private java.util.Set ORM_preco_servico = new java.util.HashSet();
	
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
	
	private void setORM_Preco_servico(java.util.Set value) {
		this.ORM_preco_servico = value;
	}
	
	private java.util.Set getORM_Preco_servico() {
		return ORM_preco_servico;
	}
	
	public final trustpet.Preco_Petsitter_ServicoSetCollection preco_servico = new trustpet.Preco_Petsitter_ServicoSetCollection(this, _ormAdapter, ORMConstants.KEY_SERVICO_PRECO_SERVICO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
