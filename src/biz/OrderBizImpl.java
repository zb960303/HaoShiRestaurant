package biz;

import java.util.List;

import dao.OrderDAO;
import entity.Order;

public class OrderBizImpl implements OrderBiz{
	OrderDAO orderDao;
	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}
	@Override
	public void AddtoOrder(Order order) {
		// TODO 自动生成的方法存根
		 orderDao.save(order);;
	}
	@Override
	public List ShowOrder(int id) {
		// TODO 自动生成的方法存根
		return orderDao.findByTID(id);
	}
	@Override
	public Double OrderPrice(int id) {
		// TODO 自动生成的方法存根
		return orderDao.SumPrice(id);
	}
	@Override
	public void Pay(Order order) {
		// TODO 自动生成的方法存根
		orderDao.merge(order);
	}
	@Override
	public Order findByTID(int id) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public List findAll() {
		// TODO 自动生成的方法存根
		return orderDao.findAll();
	}
	@Override
	public List IsBill() {
		// TODO 自动生成的方法存根
		return orderDao.findByIsBill(1);
	}
	@Override
	public List NotBill() {
		// TODO 自动生成的方法存根
		return orderDao.findByIsBill(0);
	}

}
