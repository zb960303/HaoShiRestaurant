package biz;

import java.util.List;

import dao.UserroleDAO;

public class UserRoleBizImpl implements UserRoleBiz {
	UserroleDAO userroleDao;

	public void setUserroleDao(UserroleDAO userroleDao) {
		this.userroleDao = userroleDao;
	}

	@Override
	public List findUserRole() {
		// TODO 自动生成的方法存根
		return userroleDao.findAll();
	}

}
