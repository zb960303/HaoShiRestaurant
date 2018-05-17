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
		// TODO �Զ����ɵķ������
		return foodDao.findFoodByCateId(cateId);
	}



	@Override
	public Food findFoodById(int id) {
		// TODO �Զ����ɵķ������
		return foodDao.findById(id);
	}



	@Override
	public List findAllFood() {
		// TODO �Զ����ɵķ������
		return foodDao.findAll();
	}



	@Override
	public Float findPriceById(int id) {
		// TODO �Զ����ɵķ������
		Food food=findFoodById(id);
		return food.getFprice();
	}



	@Override
	public int DeleteFood(int id) {
		// TODO �Զ����ɵķ������
		Food food=findFoodById(id);
		return foodDao.delete(food);
	}



	@Override
	public int AddFood(Food food) {
		// TODO �Զ����ɵķ������
		
		return foodDao.save(food);
	}



	@Override
	public int FoodUpdate(Food food) {
		// TODO �Զ����ɵķ������
		return foodDao.merge(food);
	}



	

}
