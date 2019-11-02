package models;

import models.enums.TypeOfUser;

public abstract class User {
	private String nome;
	private String eMail;
	private TypeOfUser typeOfUser;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public TypeOfUser getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(TypeOfUser typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	
	
}
