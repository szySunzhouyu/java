package cn.edu.hbtcm.pre.common.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.DAO;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

import cn.edu.hbtcm.pre.domain.Prescription;


public interface BaseDao<T, K> extends DAO<T, K>{
	//返回所有结果条数
	public long count();
	//根据查询语言返回结果条数
	public long count(Query<T> q);
	//根据关键字和值查找返回结果条数
	public long	count(String key, Object value) ;
 
	//删除实体
	public  void delete_(T entity) ;	
	//根据键值来删除实体
	public  void deleteById_(K id);
	//根据query语句来删除实体
	public  void deleteByQuery_(Query<T> q) ;

	//根据query语句来判断该实体是否存在
	public  boolean	exists(Query<T> q);
	//根据键和值来判断该实体是否存在
	public 	boolean exists(String key, Object value) ;
	//返回所有结果集
	public  List<T>	findAll() ;
	//根据查询语句返回结果集
	public  List<T>	findByQuery(Query<T> q) ;
	
	//根据查询语句值返回结果集
	public  T findOne(Query<T> q);
	//根据查键和值返回结果集
	public 	T findOne(String key, Object value) ;

	//保存实体
	public  int save_(T entity) ;
	//获取datastore实例
	public Datastore getDatastore();
  
	//根据id值加载实体
	public T get(K id) ;
	//为该dao的该实体类型创建一个query
	public Query<T>	 createQuery();
	//根据query语句和操作更新第一个实体
	public void updateFirst_(Query<T> q, UpdateOperations<T> ops);
		
	//根据query语句和操作更新所有实体
	public void update_(Query<T> q, UpdateOperations<T> ops);

}
