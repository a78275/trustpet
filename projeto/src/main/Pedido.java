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

public class Pedido {
	public Pedido() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PEDIDO_ANIMALSERVICOS) {
			return ORM_animalServicos;
		}
		else if (key == ORMConstants.KEY_PEDIDO_SERVICOS) {
			return ORM_servicos;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private main.Petsitter petsitter;
	
	private main.Dono dono;
	
	private float preco;
	
	private boolean ativo;
	
	private String dataInicio;
	
	private String dataFim;
	
	private java.util.Set ORM_animalServicos = new java.util.HashSet();
	
	private java.util.Set ORM_servicos = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setPreco(float value) {
		this.preco = value;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setAtivo(boolean value) {
		this.ativo = value;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	public void setDataInicio(String value) {
		this.dataInicio = value;
	}
	
	public String getDataInicio() {
		return dataInicio;
	}
	
	public void setDataFim(String value) {
		this.dataFim = value;
	}
	
	public String getDataFim() {
		return dataFim;
	}
	
	public void setDono(main.Dono value) {
		this.dono = value;
	}
	
	public main.Dono getDono() {
		return dono;
	}
	
	public void setPetsitter(main.Petsitter value) {
		this.petsitter = value;
	}
	
	public main.Petsitter getPetsitter() {
		return petsitter;
	}
	
	private void setORM_AnimalServicos(java.util.Set value) {
		this.ORM_animalServicos = value;
	}
	
	private java.util.Set getORM_AnimalServicos() {
		return ORM_animalServicos;
	}
	
	public final main.AnimalServicoSetCollection animalServicos = new main.AnimalServicoSetCollection(this, _ormAdapter, ORMConstants.KEY_PEDIDO_ANIMALSERVICOS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Servicos(java.util.Set value) {
		this.ORM_servicos = value;
	}
	
	private java.util.Set getORM_Servicos() {
		return ORM_servicos;
	}
	
	public final main.PrecoPetsitterServicoSetCollection servicos = new main.PrecoPetsitterServicoSetCollection(this, _ormAdapter, ORMConstants.KEY_PEDIDO_SERVICOS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
