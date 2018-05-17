package biz;

import java.util.List;

import entity.User;

public interface UserBiz {
	public List UserLogin(User user);
	public List UserList();
	public int DeleteUser(int id);
	public int AddUser(User user);
	public int UpdateUser(User user);
	public User findByid(int id);
}
