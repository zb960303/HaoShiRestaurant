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
		// TODO �Զ����ɵķ������
		 orderDao.save(order);;
	}
	@Override
	public List ShowOrder(int id) {
		// TODO �Զ����ɵķ������
		return orderDao.findByTID(id);
	}
	@Override
	public Double OrderPrice(int id) {
		// TODO �Զ����ɵķ������
		return orderDao.SumPrice(id);
	}
	@Override
	public void Pay(Order order) {
		// TODO �Զ����ɵķ������
		orderDao.merge(order);
	}
	@Override
	public Order findByTID(int id) {
		// TODO �Զ����ɵķ������
		return null;
	}
	@Override
	public List findAll() {
		// TODO �Զ����ɵķ������
		return orderDao.findAll();
	}
	@Override
	public List IsBill() {
		// TODO �Զ����ɵķ������
		return orderDao.findByIsBill(1);
	}
	@Override
	public List NotBill() {
		// TODO �Զ����ɵķ������
		return orderDao.findByIsBill(0);
	}

}
