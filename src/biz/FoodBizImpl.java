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

}
