package cn.edu.hbtcm.pre.common.dao;

import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.DAO;
import com.google.code.morphia.query.Query;
import com.google.code.morphia.query.UpdateOperations;

import cn.edu.hbtcm.pre.domain.Prescription;


public interface BaseDao<T, K> extends DAO<T, K>{
	//�������н������
	public long count();
	//���ݲ�ѯ���Է��ؽ������
	public long count(Query<T> q);
	//���ݹؼ��ֺ�ֵ���ҷ��ؽ������
	public long	count(String key, Object value) ;
 
	//ɾ��ʵ��
	public  void delete_(T entity) ;	
	//���ݼ�ֵ��ɾ��ʵ��
	public  void deleteById_(K id);
	//����query�����ɾ��ʵ��
	public  void deleteByQuery_(Query<T> q) ;

	//����query������жϸ�ʵ���Ƿ����
	public  boolean	exists(Query<T> q);
	//���ݼ���ֵ���жϸ�ʵ���Ƿ����
	public 	boolean exists(String key, Object value) ;
	//�������н����
	public  List<T>	findAll() ;
	//���ݲ�ѯ��䷵�ؽ����
	public  List<T>	findByQuery(Query<T> q) ;
	
	//���ݲ�ѯ���ֵ���ؽ����
	public  T findOne(Query<T> q);
	//���ݲ����ֵ���ؽ����
	public 	T findOne(String key, Object value) ;

	//����ʵ��
	public  int save_(T entity) ;
	//��ȡdatastoreʵ��
	public Datastore getDatastore();
  
	//����idֵ����ʵ��
	public T get(K id) ;
	//Ϊ��dao�ĸ�ʵ�����ʹ���һ��query
	public Query<T>	 createQuery();
	//����query���Ͳ������µ�һ��ʵ��
	public void updateFirst_(Query<T> q, UpdateOperations<T> ops);
		
	//����query���Ͳ�����������ʵ��
	public void update_(Query<T> q, UpdateOperations<T> ops);

}
