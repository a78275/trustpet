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

public class Petsitter extends trustpet.Utilizador {
	public Petsitter() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PETSITTER_ANIMAIS) {
			return ORM_animais;
		}
		else if (key == ORMConstants.KEY_PETSITTER_PRECO_SERVICO) {
			return ORM_preco_servico;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private trustpet.Horario horario;
	
	private java.util.Set ORM_animais = new java.util.HashSet();
	
	private java.util.Set ORM_preco_servico = new java.util.HashSet();
	
	private void setORM_Animais(java.util.Set value) {
		this.ORM_animais = value;
	}
	
	private java.util.Set getORM_Animais() {
		return ORM_animais;
	}
	
	public final trustpet.Tipo_AnimalSetCollection animais = new trustpet.Tipo_AnimalSetCollection(this, _ormAdapter, ORMConstants.KEY_PETSITTER_ANIMAIS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setHorario(trustpet.Horario value) {
		this.horario = value;
	}
	
	public trustpet.Horario getHorario() {
		return horario;
	}
	
	private void setORM_Preco_servico(java.util.Set value) {
		this.ORM_preco_servico = value;
	}
	
	private java.util.Set getORM_Preco_servico() {
		return ORM_preco_servico;
	}
	
	public final trustpet.Preco_Petsitter_ServicoSetCollection preco_servico = new trustpet.Preco_Petsitter_ServicoSetCollection(this, _ormAdapter, ORMConstants.KEY_PETSITTER_PRECO_SERVICO, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
