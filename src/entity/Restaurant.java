package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Restaurant entity. @author MyEclipse Persistence Tools
 */

public class Restaurant implements java.io.Serializable {

	// Fields

	private Integer rid;
	private Integer pid;
	private String rname;
	private String radress;
	private String rphone;
	private Set tables = new HashSet(0);
	private Set users = new HashSet(0);

	// Constructors

	/** default constructor */
	public Restaurant() {
	}

	/** minimal constructor */
	public Restaurant(Integer pid, String rname) {
		this.pid = pid;
		this.rname = rname;
	}

	/** full constructor */
	public Restaurant(Integer pid, String rname, String radress, String rphone,
			Set tables, Set users) {
		this.pid = pid;
		this.rname = rname;
		this.radress = radress;
		this.rphone = rphone;
		this.tables = tables;
		this.users = users;
	}

	// Property accessors

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRadress() {
		return this.radress;
	}

	public void setRadress(String radress) {
		this.radress = radress;
	}

	public String getRphone() {
		return this.rphone;
	}

	public void setRphone(String rphone) {
		this.rphone = rphone;
	}

	public Set getTables() {
		return this.tables;
	}

	public void setTables(Set tables) {
		this.tables = tables;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

}