package biz;

import java.util.List;

import dao.FoodcateDAO;
import entity.Foodcate;

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

	@Override
	public int AddFoodCate(Foodcate f) {
		// TODO 自动生成的方法存根
		return foodcateDao.save(f);
	}

	@Override
	public int DeleteFood(int id) {
		// TODO 自动生成的方法存根
		Foodcate f=foodcateDao.findById(id);
		return foodcateDao.delete(f);
	}

}
