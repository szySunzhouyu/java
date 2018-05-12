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
 * ����daoʵ��
 * ���е�dao���̳и�dao
 * ע�⣺mysql�еı�(table)��Ӧ��mongodb�нм���(collection)
 * 	   mysql�е�һ����¼(record)��Ӧ��mongodb�н�ʵ��(document)
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

	//�������н������
	public long count()
	{
		return super.count();
	}

	//���ݲ�ѯ���Է��ؽ������
	public long count(Query<T> q)
	{
		return super.count(q);
	}

	//���ݹؼ��ֺ�ֵ���ҷ��ؽ������
	public long count(String key, Object value)
	{
		return super.count(key, value);
	}

	//ɾ��ʵ��
	public void delete_(T entity)
	{
		super.delete(entity);
	}

	//���ݼ�ֵ��ɾ��ʵ��
	public void deleteById_(K id)
	{
		super.deleteById(id);
	}

	//����query�����ɾ��ʵ��
	public void deleteByQuery_(Query<T> q)
	{
		super.deleteByQuery(q);
	}

	//����query������жϸ�ʵ���Ƿ����
	public boolean exists(Query<T> q)
	{
		return super.exists(q);
	}

	//���ݼ���ֵ���жϸ�ʵ���Ƿ����
	public boolean exists(String key, Object value)
	{
		return super.exists(key, value);
	}

	//�������н����
	public List<T> findAll()
	{
		return super.find().asList();
	}

	//���ݲ�ѯ��䷵�ؽ����
	public List<T> findByQuery(Query<T> q)
	{
		return super.find(q).asList();
	}

	//���ݲ�ѯ���ֵ���ؽ����
	public T findOne(Query<T> q)
	{
		return (T) super.findOne(q);
	}

	//���ݲ����ֵ���ؽ����
	public T findOne(String key, Object value)
	{
		return (T) super.findOne(key, value);
	}

	//����ʵ��
	public int save_(T entity)
	{
		Key<T> key = super.save(entity);
		if (null!=key) {
			return 1;
		}
		return 0;
	}

	
	//��ȡdatastoreʵ��
	public Datastore getDatastore()
	{
		return super.getDatastore();
	}

	//����idֵ����ʵ��
	public T get(K id)
	{
		return (T) super.get(id);
	}

	//Ϊ��dao�ĸ�ʵ�����ʹ���һ��query
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