package entity;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */

public class Cart implements java.io.Serializable {

	// Fields

	private Integer cid;
	private Table table;
	private Food food;
	private Integer fnum;
	private Float fprice;

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** full constructor */
	public Cart(Table table, Food food, Integer fnum, Float fprice) {
		this.table = table;
		this.food = food;
		this.fnum = fnum;
		this.fprice = fprice;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Table getTable() {
		return this.table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Integer getFnum() {
		return this.fnum;
	}

	public void setFnum(Integer fnum) {
		this.fnum = fnum;
	}

	public Float getFprice() {
		return this.fprice;
	}

	public void setFprice(Float fprice) {
		this.fprice = fprice;
	}

}