package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Food entity. @author MyEclipse Persistence Tools
 */

public class Food implements java.io.Serializable {

	// Fields

	private Integer fid;
	private Foodcate foodcate;
	private String fname;
	private String fprice;
	private String fdes;
	private Integer stock;
	private String img;
	private Set orders = new HashSet(0);
	private Set carts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Food() {
	}

	/** minimal constructor */
	public Food(Foodcate foodcate, String fname, String fprice, Integer stock,
			String img) {
		this.foodcate = foodcate;
		this.fname = fname;
		this.fprice = fprice;
		this.stock = stock;
		this.img = img;
	}

	/** full constructor */
	public Food(Foodcate foodcate, String fname, String fprice, String fdes,
			Integer stock, String img, Set orders, Set carts) {
		this.foodcate = foodcate;
		this.fname = fname;
		this.fprice = fprice;
		this.fdes = fdes;
		this.stock = stock;
		this.img = img;
		this.orders = orders;
		this.carts = carts;
	}

	// Property accessors

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Foodcate getFoodcate() {
		return this.foodcate;
	}

	public void setFoodcate(Foodcate foodcate) {
		this.foodcate = foodcate;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFprice() {
		return this.fprice;
	}

	public void setFprice(String fprice) {
		this.fprice = fprice;
	}

	public String getFdes() {
		return this.fdes;
	}

	public void setFdes(String fdes) {
		this.fdes = fdes;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
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