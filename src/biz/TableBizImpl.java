package biz;

import dao.TableDAO;
import entity.Table;

public class TableBizImpl implements TableBiz{
	TableDAO tableDao;
	
	public void setTableDao(TableDAO tableDao) {
		this.tableDao = tableDao;
	}

	@Override
	public Table findTableById(int id) {
		// TODO �Զ����ɵķ������
		System.out.print("123");
		if(tableDao.findById(id)==null){
			System.out.print("null");
			return null;
		}else{
		return tableDao.findById(id);}
	}

}
