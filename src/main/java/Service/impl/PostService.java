
package service.impl;

import java.util.List;

import model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.IPostService;
import dao.IBaseDao;

@Service
public class PostService implements IPostService {
	@Autowired
	IBaseDao<Posts, Integer> baseDao;

	public void setBaseDao(IBaseDao<Posts, Integer> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public List<Posts> findAll() {
		return baseDao.findAll(Posts.class);
	}

	@Override
	public Posts findById(Integer id) {
		return baseDao.findById(Posts.class, id);
	}

	@Override
	public void save(Posts post) {
		baseDao.save(post);
	}

	@Override
	public void delete(int id) {
		Posts post = findById(id);
		baseDao.delete(post);
	}

	@Override
	public void saveOrUpdate(Posts post) {
		baseDao.saveOrUpdate(post);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Posts> keySearch(String key) {
		String skey = "%" + key + "%";
		List<?> results = baseDao
				.find("SELECT posts FROM Posts posts WHERE posts.content LIKE ? or posts.title LIKE ?",
						skey, skey);
		return (List<Posts>) results;
	}

}
