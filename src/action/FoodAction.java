package action;

import java.util.List;

import biz.FoodBiz;

import com.opensymphony.xwork2.ActionSupport;

public class FoodAction extends ActionSupport{
	FoodBiz foodBiz;
	private List Foodlist;
	public List getFoodlist() {
		return Foodlist;
	}
	public void setFoodlist(List foodlist) {
		Foodlist = foodlist;
	}

	private int cateId;
	
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}

	public void setFoodBiz(FoodBiz foodBiz) {
		this.foodBiz = foodBiz;
	}
	
	public String findFoodByCateId(){
		Foodlist=foodBiz.findFoodByCate(cateId);
		
		return "showFood";
	}
}
