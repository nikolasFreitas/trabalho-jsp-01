package models;

import models.enums.TypeOfUser;

public abstract class User {
	private String nome;
	private String eMail;
	private static int id = 0;
	private TypeOfUser typeOfUser;
	
	public User() {
		id++;
	}
	
	public User(int id) {
		User.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return nome;
	}
	public void setName(String nome) {
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
