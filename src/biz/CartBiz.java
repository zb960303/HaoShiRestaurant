package biz;

import java.util.List;

import entity.Cart;

public interface CartBiz {
	public int AddtoCart(Cart cart);
	public int IsExistFood(int FID,int TID);
	public Cart findCartByFId_TID(int FID,int TID);
	public int  updateCart(Cart cart);
	public List findCartByTID(int id);
	public Double SumPrice(int id);
	public void DeleteCart(int id);
}
