package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Table entity. @author MyEclipse Persistence Tools
 */

public class Table implements java.io.Serializable {

	// Fields

	private Integer tid;
	private Restaurant restaurant;
	private Integer tname;
	private Integer tdes;
	private Set orders = new HashSet(0);
	private Set carts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Table() {
	}

	/** minimal constructor */
	public Table(Restaurant restaurant, Integer tname, Integer tdes) {
		this.restaurant = restaurant;
		this.tname = tname;
		this.tdes = tdes;
	}

	/** full constructor */
	public Table(Restaurant restaurant, Integer tname, Integer tdes,
			Set orders, Set carts) {
		this.restaurant = restaurant;
		this.tname = tname;
		this.tdes = tdes;
		this.orders = orders;
		this.carts = carts;
	}

	// Property accessors

	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Integer getTname() {
		return this.tname;
	}

	public void setTname(Integer tname) {
		this.tname = tname;
	}

	public Integer getTdes() {
		return this.tdes;
	}

	public void setTdes(Integer tdes) {
		this.tdes = tdes;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

	public Set getCarts() {
		return this.carts;
	}

	public void setCarts(Set carts) {
		this.carts = carts;
	}

}