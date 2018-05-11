package biz;


import java.util.List;

import dao.CartDAO;
import entity.Cart;

public class CartBizImpl implements CartBiz {
	CartDAO cartDao;

	public void setCartDao(CartDAO cartDao) {
		this.cartDao = cartDao;
	}

	@Override
	public int AddtoCart(Cart cart) {
		// TODO 自动生成的方法存根
		int IsSuccess=cartDao.save(cart);
		if(IsSuccess==1){
			return 1;
		}else{
			return 0;
		}
	}

	@Override
	public int IsExistFood(int FID, int TID) {
		// TODO 自动生成的方法存根
		List list=cartDao.findByFID(FID,TID);
		System.out.println("list size"+list.size());
		if(list.size()>0){
			return 1;
		}else
		return 0;
	}

	@Override
	public Cart findCartByFId_TID(int FID, int TID) {
		// TODO 自动生成的方法存根
		return cartDao.findCartByFId_TID(FID, TID);
	}

	@Override
	public int updateCart(Cart cart) {
		// TODO 自动生成的方法存根
		return cartDao.merge(cart);
	}

	@Override
	public List findCartByTID(int id) {
		// TODO 自动生成的方法存根
		return cartDao.findByTID(id);
	}

	@Override
	public Double SumPrice(int id) {
		// TODO 自动生成的方法存根
		return cartDao.SumPrice(id);
	}
	
	
}
