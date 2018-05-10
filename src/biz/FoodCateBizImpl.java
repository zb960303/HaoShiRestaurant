package biz;

import java.util.List;

import dao.FoodcateDAO;

public class FoodCateBizImpl implements FoodCateBiz{
	
	FoodcateDAO foodcateDao;
	
	public void setFoodcateDao(FoodcateDAO foodcateDao) {
		this.foodcateDao = foodcateDao;
	}

	@Override
	public List findFoodCate() {
		// TODO 自动生成的方法存根
		return foodcateDao.findAll();
	}

}
