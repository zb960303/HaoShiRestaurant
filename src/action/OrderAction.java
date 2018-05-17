package action;

import java.util.List;

import biz.OrderBiz;

import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	OrderBiz orderBiz;
	private List OrderList;

	public List getOrderList() {
		return OrderList;
	}

	public void setOrderList(List orderList) {
		OrderList = orderList;
	}

	public void setOrderBiz(OrderBiz orderBiz) {
		this.orderBiz = orderBiz;
	}
	
	public String OrderList(){
		OrderList=orderBiz.findAll();
		return "OrderList";
	}
	
	public String IsBill(){
		OrderList=orderBiz.IsBill();
		return "IsBill";
	}
	
	public String NotBill(){
		OrderList=orderBiz.NotBill();
		return "NotBill";
	}
	
	
}
