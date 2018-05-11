package action;

import java.util.List;

import biz.CartBiz;
import biz.FoodBiz;
import biz.FoodCateBiz;
import biz.TableBiz;

import com.opensymphony.xwork2.ActionSupport;

import entity.Cart;
import entity.Food;
import entity.Table;

public class CartAction extends ActionSupport{
	private int RID;
	private int TID;
	private int FID;
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
					//foodcate.showAllFoodCate();
				} catch (Exception e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				return "AddSuccess";
			}else{
				return "error";
			}
	}
	
	public String findAllCartByTID(){
		CartList=cartBiz.findCartByTID(TID);
		SumPrice=cartBiz.SumPrice(TID);
		return "ShowCart";
	}
}
