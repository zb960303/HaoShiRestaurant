package biz;

import java.util.List;

import dao.RestaurantDAO;

public class RestaurantBizImpl implements RestaurantBiz{
	RestaurantDAO restaurantDao;

	public void setRestaurantDao(RestaurantDAO restaurantDao) {
		this.restaurantDao = restaurantDao;
	}

	@Override
	public List findRest() {
		// TODO 自动生成的方法存根
		return restaurantDao.findAll();
	}
}
