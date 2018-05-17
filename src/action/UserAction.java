package action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import biz.OrderBiz;
import biz.RestaurantBiz;
import biz.UserBiz;
import biz.UserRoleBiz;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;

public class UserAction extends ActionSupport implements RequestAware,SessionAware{
	User user;
	UserBiz userBiz;
	UserRoleBiz userroleBiz;
	RestaurantBiz restaurantBiz;
	List OrderList;
	OrderBiz orderBiz;
	public void setOrderBiz(OrderBiz orderBiz) {
		this.orderBiz = orderBiz;
	}

	public List getOrderList() {
		return OrderList;
	}

	public void setOrderList(List orderList) {
		OrderList = orderList;
	}

	public void setRestaurantBiz(RestaurantBiz restaurantBiz) {
		this.restaurantBiz = restaurantBiz;
	}

	public void setUserroleBiz(UserRoleBiz userroleBiz) {
		this.userroleBiz = userroleBiz;
	}
	private List UserList;
	private List UserRR;
	private List RoleList;
	private List RestList;
	
	public List getRestList() {
		return RestList;
	}

	public void setRestList(List restList) {
		RestList = restList;
	}

	public List getRoleList() {
		return RoleList;
	}

	public void setRoleList(List roleList) {
		RoleList = roleList;
	}

	public List getUserRR() {
		return UserRR;
	}

	public void setUserRR(List userRR) {
		UserRR = userRR;
	}
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List getUserList() {
		return UserList;
	}

	public void setUserList(List userList) {
		UserList = userList;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	Map<String, Object> session;
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}
	
	
	
	public String UserLogin(){
		List rtn=userBiz.UserLogin(user);
		if(rtn==null){
			Object o="此用户名不存在，请确认后再输入！";
			session.put("message", o);
			return "Login";
		}
		else {
			session.put("user", rtn.get(0));
			//User u=(User)rtn.get(0);
			if(user.getUserrole().getUrid()==1||user.getUserrole().getUrid()==2){
				return "LoginSuccess";
			}else if(user.getUserrole().getUrid()==3||user.getUserrole().getUrid()==4){
				OrderList=orderBiz.IsBill();
				return "UserLoginSuccess";
				}
			else{
				return "error";
				}
			}
				 
			
	}

	public String UserList(){
		UserList=userBiz.UserList();
		findRole();
		findRest();
		return "UserList";
	}
	
	public String findByid(){
		User user=userBiz.findByid(id);
		findRest();
		return "findByid";
	}
	
	public String findRole(){
		RoleList=userroleBiz.findUserRole();
		return "ToLogin";
	}
	
	
	public void findRest(){
		RestList=restaurantBiz.findRest();
		if(RestList.size()<1){
			System.out.println("nullList");
		}else
			System.out.println("List"+RestList.size());
	}
	
	public String findRR(){
		UserRR=userBiz.UserList();
		return "UserRR";
	}
	
	public String DeleteUser(){
		int res=userBiz.DeleteUser(id);
		if(res==1){
			System.out.print("delete");
			UserList();
			return "DeleteSuccess";
			
		}else 
			return "bad";
	}
	
	public String UpdateUser(){
		int res=userBiz.UpdateUser(user);
		if(res==1){
			UserList();
			return "UpdateSuccess";
			
		}else 
			return "bad";
	}
	
	
	public String AddUser(){
		int res=userBiz.AddUser(user);
		if(res==1){
			UserList();
			return "AddUser";
		}else
			return "error";
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO 自动生成的方法存根
		
	}
}
