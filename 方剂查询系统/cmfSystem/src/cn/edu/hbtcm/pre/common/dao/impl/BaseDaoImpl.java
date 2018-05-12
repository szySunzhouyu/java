package cn.edu.hbtcm.pre.common.dao.impl;

import java.util.List;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.dao.DAO;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

import cn.edu.hbtcm.pre.common.dao.BaseDao;
/**
 * 基本dao实现
 * 所有的dao都继承该dao
 * 注意：mysql中的表(table)对应在mongodb中叫集合(collection)
 * 	   mysql中的一条记录(record)对应在mongodb中叫实体(document)
 * @author Administrator
 *
 * @param <T>
 * @param <K>
 */
public class BaseDaoImpl<T, K> extends BasicDAO<T, K> implements BaseDao<T, K>
{
	protected BaseDaoImpl(Datastore ds)
	{
		super(ds);	
	}

	//返回所有结果条数
	public long count()
	{
		return super.count();
	}

	//根据查询语言返回结果条数
	public long count(Query<T> q)
	{
		return super.count(q);
	}

	//根据关键字和值查找返回结果条数
	public long count(String key, Object value)
	{
		return super.count(key, value);
	}

	//删除实体
	public void delete_(T entity)
	{
		super.delete(entity);
	}

	//根据键值来删除实体
	public void deleteById_(K id)
	{
		super.deleteById(id);
	}

	//根据query语句来删除实体
	public void deleteByQuery_(Query<T> q)
	{
		super.deleteByQuery(q);
	}

	//根据query语句来判断该实体是否存在
	public boolean exists(Query<T> q)
	{
		return super.exists(q);
	}

	//根据键和值来判断该实体是否存在
	public boolean exists(String key, Object value)
	{
		return super.exists(key, value);
	}

	//返回所有结果集
	public List<T> findAll()
	{
		return super.find().asList();
	}

	//根据查询语句返回结果集
	public List<T> findByQuery(Query<T> q)
	{
		return super.find(q).asList();
	}

	//根据查询语句值返回结果集
	public T findOne(Query<T> q)
	{
		return (T) super.findOne(q);
	}

	//根据查键和值返回结果集
	public T findOne(String key, Object value)
	{
		return (T) super.findOne(key, value);
	}

	//保存实体
	public int save_(T entity)
	{
		Key<T> key = super.save(entity);
		if (null!=key) {
			return 1;
		}
		return 0;
	}

	
	//获取datastore实例
	public Datastore getDatastore()
	{
		return super.getDatastore();
	}

	//根据id值加载实体
	public T get(K id)
	{
		return (T) super.get(id);
	}

	//为该dao的该实体类型创建一个query
	public Query<T> createQuery()
	{
		return super.createQuery();
	}

	public void updateFirst_(Query<T> q, UpdateOperations<T> ops) {
		// TODO Auto-generated method stub
		super.updateFirst(q, ops);
	}

	public void update_(Query<T> q, UpdateOperations<T> ops) {
		// TODO Auto-generated method stub
		super.update(q, ops);
	}

}