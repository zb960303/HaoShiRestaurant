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
		// TODO �Զ����ɵķ������
		return userroleDao.findAll();
	}

}
