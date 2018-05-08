package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Foodcate entity. @author MyEclipse Persistence Tools
 */

public class Foodcate implements java.io.Serializable {

	// Fields

	private Integer fcid;
	private String fcname;
	private Set foods = new HashSet(0);

	// Constructors

	/** default constructor */
	public Foodcate() {
	}

	/** minimal constructor */
	public Foodcate(String fcname) {
		this.fcname = fcname;
	}

	/** full constructor */
	public Foodcate(String fcname, Set foods) {
		this.fcname = fcname;
		this.foods = foods;
	}

	// Property accessors

	public Integer getFcid() {
		return this.fcid;
	}

	public void setFcid(Integer fcid) {
		this.fcid = fcid;
	}

	public String getFcname() {
		return this.fcname;
	}

	public void setFcname(String fcname) {
		this.fcname = fcname;
	}

	public Set getFoods() {
		return this.foods;
	}

	public void setFoods(Set foods) {
		this.foods = foods;
	}

}