package action;

import java.util.List;

import biz.FoodBiz;
import biz.FoodCateBiz;

import com.opensymphony.xwork2.ActionSupport;

import entity.Foodcate;

public class FoodCateAction extends ActionSupport{
	FoodCateBiz foodcateBiz;
	FoodBiz foodBiz;
	List FoodList;
	private Foodcate foodcate;
	private List FoodCateList;
	private int id;

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List getFoodCateList() {
		return FoodCateList;
	}


	public void setFoodCateList(List foodCateList) {
		FoodCateList = foodCateList;
	}


	public Foodcate getFoodcate() {
		return foodcate;
	}


	public void setFoodcate(Foodcate foodcate) {
		this.foodcate = foodcate;
	}


	public List getFoodList() {
		return FoodList;
	}


	public void setFoodList(List foodList) {
		FoodList = foodList;
	}


	public void setFoodBiz(FoodBiz foodBiz) {
		this.foodBiz = foodBiz;
	}

	private List list;
	

	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}


	public void setFoodcateBiz(FoodCateBiz foodcateBiz) {
		this.foodcateBiz = foodcateBiz;
	}
	
	public String showAllFoodCate() throws Exception{
		list=foodcateBiz.findFoodCate();
		FoodList=foodBiz.findAllFood();
		return "showAllFoodCate";
	}
	
	public String AddFoodCate(){
		int res=foodcateBiz.AddFoodCate(foodcate);
		if(res==1){
			FoodCateList();
			return "AddFoodCate";
		}else{
			return "error";
		}
		
	}
	
	public String FoodCateList(){
		FoodCateList=foodcateBiz.findFoodCate();
		return "FoodCateList";
	}
	
	public String DeleteFoodCate(){
		int res=foodcateBiz.DeleteFood(id);
		if(res==1){
			FoodCateList();
			return "DeleteFoodCate";
		}else{
			return "error";
		}
	}
}
