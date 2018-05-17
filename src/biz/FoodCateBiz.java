package biz;

import java.util.List;

import entity.Foodcate;


public interface FoodCateBiz {
	public List findFoodCate();
	public int AddFoodCate(Foodcate foodcate);
	public int DeleteFood(int id);
}
