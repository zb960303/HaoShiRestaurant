package action;

import java.util.List;

import biz.FoodCateBiz;

import com.opensymphony.xwork2.ActionSupport;

public class FoodCateAction extends ActionSupport{
	FoodCateBiz foodcateBiz;
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
		return "showAllFoodCate";
	}
}
