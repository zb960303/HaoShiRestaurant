package action;

import java.util.Iterator;
import java.util.List;

import biz.CartBiz;
import biz.FoodBiz;
import biz.FoodCateBiz;
import biz.OrderBiz;
import biz.TableBiz;

import com.opensymphony.xwork2.ActionSupport;

import entity.Cart;
import entity.Food;
import entity.Order;
import entity.Table;

public class CartAction extends ActionSupport{
	private int RID;
	private int TID;
	private int FID;
	private int NumFid;
	private List OrderList;
	private double OrderPrice;
	public List getOrderList() {
		return OrderList;
	}
	public void setOrderList(List orderList) {
		OrderList = orderList;
	}
	public double getOrderPrice() {
		return OrderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		OrderPrice = orderPrice;
	}
	public int getNumFid() {
		return NumFid;
	}
	public void setNumFid(int numFid) {
		NumFid = numFid;
	}
	private List list;
	private List Foodlist;
	private List CartList;
	private Double SumPrice;
	public Double getSumPrice() {
		return SumPrice;
	}
	public void setSumPrice(Double sumPrice) {
		SumPrice = sumPrice;
	}
	public List getCartList() {
		return CartList;
	}
	public void setCartList(List cartList) {
		CartList = cartList;
	}
	FoodCateBiz foodcateBiz;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public List getFoodlist() {
		return Foodlist;
	}
	public void setFoodlist(List foodFoodlist) {
		this.Foodlist = foodFoodlist;
	}
	public void setFoodcateBiz(FoodCateBiz foodcateBiz) {
		this.foodcateBiz = foodcateBiz;
	}
	public int getFID() {
		return FID;
	}
	public void setFID(int fID) {
		FID = fID;
	}
	CartBiz cartBiz;
	FoodBiz foodbiz;
	TableBiz tableBiz;
	OrderBiz orderBiz;
	
	public void setOrderBiz(OrderBiz orderBiz) {
		this.orderBiz = orderBiz;
	}
	public void setTableBiz(TableBiz tableBiz) {
		this.tableBiz = tableBiz;
	}
	public void setFoodbiz(FoodBiz foodbiz) {
		this.foodbiz = foodbiz;
	}
	public void setCartBiz(CartBiz cartBiz) {
		this.cartBiz = cartBiz;
	}
	public int getRID() {
		return RID;
	}
	public void setRID(int rID) {
		RID = rID;
	}
	public int getTID() {
		return TID;
	}
	public void setTID(int tID) {
		TID = tID;
	}
	
	public String showTID(){
		System.out.print(TID);
		return "ShowTID";
	} 
	
	
	public Food findFoodById(){
		Food food=foodbiz.findFoodById(FID);
		return food;
	}
	
	public Table findTableById(){
		Table table=new Table();
		table=tableBiz.findTableById(TID);
		return table;
		
	}
	
	public int IsExistFood(int FID,int TID){
		int isExist=cartBiz.IsExistFood(FID, TID);
		return isExist;
	}
	
	public String  NumDecrease(){
		Cart cart=cartBiz.findCartByFId_TID(NumFid, TID);
		int newNum;
		float price;
		newNum=cart.getFnum()-1;
		cart.setFnum(newNum);
		price=foodbiz.findPriceById(NumFid);
		cart.setFprice(price*newNum);
		cartBiz.updateCart(cart);	
		return findAllCartByTID();
	}
	
	public String  NumIncrease(){
		Cart cart=cartBiz.findCartByFId_TID(NumFid, TID);
		int newNum;
		float price;
		newNum=cart.getFnum()+1;
		cart.setFnum(newNum);
		price=foodbiz.findPriceById(NumFid);
		cart.setFprice(price*newNum);
		cartBiz.updateCart(cart);	
		return findAllCartByTID();
	}
	
	public String Pay(){
		List orderlist=orderBiz.ShowOrder(TID);
		Iterator it=orderlist.iterator();
		while (it.hasNext()){
			Order o=(Order)it.next();
			o.setIsBill(1);
			orderBiz.Pay(o);
		}
		return "PaySuccess";
	}
	
	
	
	public String AddtoCart(){
		Float price;
		int newNum;
		int IsSuccess;
		int IsExist=IsExistFood(FID,TID);
		if(IsExist==1){
			Cart cart=cartBiz.findCartByFId_TID(FID, TID);
			newNum=cart.getFnum()+1;
			cart.setFnum(newNum);
			price=foodbiz.findPriceById(FID);
			cart.setFprice(price*newNum);
			IsSuccess=cartBiz.updateCart(cart);	
			
		}else{
				Food food=findFoodById();
				Cart cart = new Cart();
				cart.setFnum(1);
				cart.setFood(food);
				cart.setFprice(food.getFprice());
				cart.setTable(findTableById());
				IsSuccess=cartBiz.AddtoCart(cart);
				
			}
			if(IsSuccess==1){
				try {
					list=foodcateBiz.findFoodCate();
					Foodlist=foodbiz.findAllFood();
					return "AddtoCart";
					//foodcate.showAllFoodCate();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				
			}
			return null;
	}
	
	public String findAllCartByTID(){
		CartList=cartBiz.findCartByTID(TID);
		SumPrice=cartBiz.SumPrice(TID);
		return "ShowCart";
	}
	
	public String AddtoOrder(){
		Iterator it=CartList.iterator();
		while (it.hasNext()){
			Order order=new Order();
			Cart c=(Cart)it.next();
			order.setTable(c.getTable());
			order.setFood(c.getFood());
			order.setFnum(c.getFnum());
			order.setOprice(c.getFprice());
			order.setIsBill(0);
			orderBiz.AddtoOrder(order);
		} 
		ShowOrder();
		cartBiz.DeleteCart(TID);
		return "ShowOrder";
	}
	
	public void ShowOrder(){
		OrderList=orderBiz.ShowOrder(TID);
		OrderPrice=orderBiz.OrderPrice(TID);
		
	}
}
