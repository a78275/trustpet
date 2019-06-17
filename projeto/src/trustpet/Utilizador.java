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

public class Utilizador {
	public Utilizador() {
	}
	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof Utilizador))
			return false;
		Utilizador utilizador = (Utilizador)aObj;
		if ((getEmail() != null && !getEmail().equals(utilizador.getEmail())) || (getEmail() == null && utilizador.getEmail() != null))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		hashcode = hashcode + (getEmail() == null ? 0 : getEmail().hashCode());
		return hashcode;
	}
	
	private String email;
	
	private String password;
	
	private String nome;
	
	private String avatar;
	
	private String data_nasc;
	
	private String contacto;
	
	private boolean jardim;
	
	private String morada;
	
	private boolean ativo;
	
	private String concelho;
	
	private String distrito;
	
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getORMID() {
		return getEmail();
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setNome(String value) {
		this.nome = value;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setAvatar(String value) {
		this.avatar = value;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public void setData_nasc(String value) {
		this.data_nasc = value;
	}
	
	public String getData_nasc() {
		return data_nasc;
	}
	
	public void setContacto(String value) {
		this.contacto = value;
	}
	
	public String getContacto() {
		return contacto;
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
	
	public void setAtivo(boolean value) {
		this.ativo = value;
	}
	
	public boolean getAtivo() {
		return ativo;
	}
	
	public void setConcelho(String value) {
		this.concelho = value;
	}
	
	public String getConcelho() {
		return concelho;
	}
	
	public void setDistrito(String value) {
		this.distrito = value;
	}
	
	public String getDistrito() {
		return distrito;
	}
	
	public String toString() {
		return String.valueOf(getEmail());
	}
	
}
