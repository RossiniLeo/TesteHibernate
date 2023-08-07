
package service.impl;

import java.util.List;

import dao.impl.BaseDao;
import model.Usertable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.IUserService;
import dao.IBaseDao;

@Service
public class UserService implements IUserService {
	@Autowired
	private IBaseDao<Usertable, Integer> baseDao;

	public void setBaseDao(IBaseDao<Usertable, Integer> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Usertable> findAll() {
		return baseDao.findAll(Usertable.class);
	}

	@Override
	public Usertable findById(Integer id) {
		return baseDao.findById(Usertable.class, id);
	}

	@Override
	public void delete(int id) {
		Usertable usertable = findById(id);
		baseDao.delete(usertable);
	}

	@Override
	public void save(Usertable usertable) {
		baseDao.save(usertable);
	}

	@Override
	public void saveOrUpdate(Usertable usertable) {
		baseDao.saveOrUpdate(usertable);
	}

	@Override
	public Usertable check(String username, String password) {
		return baseDao.get("from Usertable where username=? and password=?",
				username, password);
	}

	@Override
	public void modifyPassword(int id, String password) {
		Usertable usertable = findById(id);
		usertable.setPassword(password);
		saveOrUpdate(usertable);
	}

	@Override
	public void modifyInformation(int id, String sex, String phonenum, String mail) {
		Usertable usertable = findById(id);
		usertable.setSex(sex);
		usertable.setMail(mail);
		saveOrUpdate(usertable);
	}

}
