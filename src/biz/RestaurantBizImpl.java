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
		// TODO �Զ����ɵķ������
		return restaurantDao.findAll();
	}
}
