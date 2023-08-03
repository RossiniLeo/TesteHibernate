
package service.impl;

import java.util.List;

import model.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import service.ICommentService;
import dao.IBaseDao;

@Service
class CommentService implements ICommentService {
	@Autowired
	private IBaseDao<Comments, Integer> baseDao;

	public void setBaseDao(IBaseDao<Comments, Integer> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void delete(int id) {
		Comments comment = baseDao.findById(Comments.class, id);
		baseDao.delete(comment);
	}

	@Override
	public void save(Comments comment) {
		baseDao.save(comment);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comments> findPostInAll(int postid) {
		return (List<Comments>) baseDao.find(
				"from Comments c where c.post.id=? order by c.date desc",
				postid);
	}

}
