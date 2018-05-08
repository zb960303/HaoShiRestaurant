package entity;

/**
 * Order entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer oid;
	private Table table;
	private Food food;
	private Integer fnum;
	private Float oprice;
	private Integer isBill;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(Table table, Food food, Integer fnum, Float oprice,
			Integer isBill) {
		this.table = table;
		this.food = food;
		this.fnum = fnum;
		this.oprice = oprice;
		this.isBill = isBill;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
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

	public Float getOprice() {
		return this.oprice;
	}

	public void setOprice(Float oprice) {
		this.oprice = oprice;
	}

	public Integer getIsBill() {
		return this.isBill;
	}

	public void setIsBill(Integer isBill) {
		this.isBill = isBill;
	}

}