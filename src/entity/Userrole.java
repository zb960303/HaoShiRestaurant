package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Userrole entity. @author MyEclipse Persistence Tools
 */

public class Userrole implements java.io.Serializable {

	// Fields

	private Integer urid;
	private String urole;
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userrole() {
	}

	/** minimal constructor */
	public Userrole(String urole) {
		this.urole = urole;
	}

	/** full constructor */
	public Userrole(String urole, Set users) {
		this.urole = urole;
		this.users = users;
	}

	// Property accessors

	public Integer getUrid() {
		return this.urid;
	}

	public void setUrid(Integer urid) {
		this.urid = urid;
	}

	public String getUrole() {
		return this.urole;
	}

	public void setUrole(String urole) {
		this.urole = urole;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}