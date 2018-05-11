package biz;

import java.util.List;

import entity.Food;

public interface FoodBiz {
	public List findFoodByCate(int cateId);
	public Food findFoodById(int id);
	public List findAllFood();
	public Float findPriceById(int id);
	
}
