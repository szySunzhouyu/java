package cn.edu.hbtcm.pre.ext;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.util.StringUtils;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

/**
 * ͨ����չAbstractFactoryBean����  DataStore��FactoryBean��
 * @author Administrator
 *
 */
public class DataStoreFactoryBean extends AbstractFactoryBean<Datastore> {

	// morphiaʵ��������ǵ���  
	private Morphia morphia;
	// mongoʵ��������ǵ���  
	private Mongo mongo;
	// ���ݿ��� 
	private String dbName;
	// �û�������Ϊ��  
	private String user;
	// ���룬��Ϊ��
	private String password;

	@Override
	public Class<?> getObjectType() {
		return Datastore.class;
	}

	@Override
	protected Datastore createInstance() throws Exception {
		if (StringUtils.hasText(user)) {
			return morphia.createDatastore(mongo, dbName, user, password.toCharArray());
		}
		return morphia.createDatastore(mongo, dbName);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		super.afterPropertiesSet();
		if (mongo == null) {
			throw new IllegalStateException("mongo is not set");
		}
		if (morphia == null) {
			throw new IllegalStateException("morphia is not set");
		}
	}

	public void setMorphia(Morphia morphia) {
		this.morphia = morphia;
	}

	public void setMongo(Mongo mongo) {
		this.mongo = mongo;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
