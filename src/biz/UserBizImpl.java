package biz;

import java.util.List;

import dao.UserDAO;
import entity.User;

public class UserBizImpl implements UserBiz {
	UserDAO userDao;
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public List UserLogin(User user) {
		// TODO �Զ����ɵķ������
		List nullList=null;
		List list=userDao.findByExample(user);
		if(list.size()>0){
			return list;
		}
		return nullList;
	}

	@Override
	public List UserList() {
		// TODO �Զ����ɵķ������
		return userDao.findAll();
	}

	@Override
	public int DeleteUser(int id) {
		// TODO �Զ����ɵķ������
		User u=userDao.findById(id);
		return userDao.delete(u);
		
	}

	@Override
	public int AddUser(User user) {
		// TODO �Զ����ɵķ������
		
		return userDao.save(user);
	}

	@Override
	public int UpdateUser(User user) {
		// TODO �Զ����ɵķ������
		return userDao.merge(user);
	}

	@Override
	public User findByid(int id) {
		// TODO �Զ����ɵķ������
		return userDao.findById(id);
	}
	
}
