package biz;

import java.util.List;

import dao.FoodDAO;
import entity.Food;

public class FoodBizImpl implements FoodBiz {
	FoodDAO foodDao;
	
	

	public void setFoodDao(FoodDAO foodDao) {
		this.foodDao = foodDao;
	}



	@Override
	public List findFoodByCate(int cateId) {
		// TODO 自动生成的方法存根
		return foodDao.findFoodByCateId(cateId);
	}



	@Override
	public Food findFoodById(int id) {
		// TODO 自动生成的方法存根
		return foodDao.findById(id);
	}



	@Override
	public List findAllFood() {
		// TODO 自动生成的方法存根
		return foodDao.findAll();
	}



	@Override
	public Float findPriceById(int id) {
		// TODO 自动生成的方法存根
		Food food=findFoodById(id);
		return food.getFprice();
	}



	@Override
	public int DeleteFood(int id) {
		// TODO 自动生成的方法存根
		Food food=findFoodById(id);
		return foodDao.delete(food);
	}



	@Override
	public int AddFood(Food food) {
		// TODO 自动生成的方法存根
		
		return foodDao.save(food);
	}



	@Override
	public int FoodUpdate(Food food) {
		// TODO 自动生成的方法存根
		return foodDao.merge(food);
	}



	

}
