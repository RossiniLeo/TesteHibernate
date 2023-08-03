
package service;

import java.util.List;

import model.Usertable;

public interface IUserService {
	List<Usertable> findAll();

	Usertable findById(Integer id);

	void delete(int id);

	void save(Usertable usertable);

	void saveOrUpdate(Usertable usertable);

	Usertable check(String username, String password);

	void modifyPassword(int id, String password);

	void modifyInformation(int id, String sex, String phonenum, String mail);

}
