package biz;

import java.util.List;

import entity.Order;

public interface OrderBiz {
	public void AddtoOrder(Order order);
	public List ShowOrder(int id);
	public Double OrderPrice(int id);
	public void Pay(Order order);
	public Order findByTID(int id);
	public List findAll();
	public List IsBill();
	public List NotBill();
}
