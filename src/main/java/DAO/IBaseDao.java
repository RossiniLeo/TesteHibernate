
package dao;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 * @param <ID>
 */

@Component
public interface IBaseDao<T, ID extends Serializable> {

	/**
	 * @param clazz
	 * @return
	 */
	List<T> findAll(Class<T> clazz);

	/**
	 * @param clazz
	 * @param id
	 * @return
	 */
	T findById(Class<T> clazz, ID id);

	/**
	 * @param t
	 */
	void save(T t);

	/**
	 * @param t
	 */
	void delete(T t);

	/**
	 * @param t
	 */
	void saveOrUpdate(T t);

	/**
	 * @param hql
	 * @param values
	 * @return
	 */
	List<?> find(String hql, Object... values);

	T get(String hql, Object... values);
}