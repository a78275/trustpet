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

public class Petsitter {
	public Petsitter() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PETSITTER_SERVICOS) {
			return ORM_servicos;
		}
		else if (key == ORMConstants.KEY_PETSITTER_ANIMAIS) {
			return ORM_animais;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	private int id;
	
	private trustpet.Horario horario;
	
	private String photo;
	
	private boolean ativo;
	
	private String nome;
	
	private String email;
	
	private String data_nascimento;
	
	private String contacto;
	
	private String residencia;
	
	private boolean jardim;
	
	private String morada;
	
	private String password;
	
	private String descricao;
	
	private java.util.Set ORM_servicos = new java.util.HashSet();
	
	private java.util.Set ORM_animais = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setPhoto(String value) {
		this.photo = value;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setAtivo(boolean value) {
		this.ativo = value;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setData_nascimento(String value) {
		this.data_nascimento = value;
	}
	
	public String getData_nascimento() {
		return data_nascimento;
	}
	
	public void setContacto(String value) {
		this.contacto = value;
	}
	
	public String getContacto() {
		return contacto;
	}
	
	public void setResidencia(String value) {
		this.residencia = value;
	}
	
	public String getResidencia() {
		return residencia;
	}
	
	public void setJardim(boolean value) {
		this.jardim = value;
	}
	
	public boolean getJardim() {
		return jardim;
	}
	
	public void setMorada(String value) {
		this.morada = value;
	}
	
	public String getMorada() {
		return morada;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setDescricao(String value) {
		this.descricao = value;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	private void setORM_Servicos(java.util.Set value) {
		this.ORM_servicos = value;
	}
	
	private java.util.Set getORM_Servicos() {
		return ORM_servicos;
	}
	
	public final trustpet.ServicoSetCollection servicos = new trustpet.ServicoSetCollection(this, _ormAdapter, ORMConstants.KEY_PETSITTER_SERVICOS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
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
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
