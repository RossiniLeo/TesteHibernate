
package service;

import java.util.List;

import model.Posts;

public interface IPostService {
	List<Posts> findAll();

	Posts findById(Integer id);

	void save(Posts post);

	void delete(int id);

	void saveOrUpdate(Posts post);

	List<Posts> keySearch(String key);
}
