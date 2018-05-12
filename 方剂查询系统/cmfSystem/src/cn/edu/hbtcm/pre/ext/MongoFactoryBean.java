package cn.edu.hbtcm.pre.ext;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ServerAddress;

/**
 * 通过扩展AbstractFactoryBean创建  Mongo的FactoryBean类
 * @author Administrator
 *
 */
public class MongoFactoryBean extends AbstractFactoryBean<Mongo> {

	// 表示服务器列表(主从复制或者分片)的List集合
	private List<ServerAddress> replicaSetSeeds = new ArrayList<ServerAddress>();
	// mongoDB配置对象 使用默认配置  
	private MongoOptions mongoOptions;

	@Override
	public Class<?> getObjectType() {
		return Mongo.class;
	}

	@Override
	protected Mongo createInstance() throws Exception {
		if (replicaSetSeeds.size() > 0) {
			if (mongoOptions != null) {
				return new Mongo(replicaSetSeeds, mongoOptions);
			}
			return new Mongo(replicaSetSeeds);
		}
		return new Mongo();
	}

	public void setMultiAddress(String[] serverAddresses) {
		replSeeds(serverAddresses);
	}

	/** 
     * 根据服务器字符串列表，解析出服务器对象列表 
     */  
	private void replSeeds(String... serverAddresses) {
		try {
			replicaSetSeeds.clear();
			for (String addr : serverAddresses) {
				String[] a = addr.split(":");
				String host = a[0];
				if (a.length > 2) {
					throw new IllegalArgumentException("Invalid Server Address : " + addr);
				}else if(a.length == 2) {
					replicaSetSeeds.add(new ServerAddress(host, Integer.parseInt(a[1])));
				}else{
					replicaSetSeeds.add(new ServerAddress(host));
				}
			}
		} catch (Exception e) {
			throw new BeanCreationException("Error while creating replicaSetAddresses",e);
		}
	}

	public void setAddress(String serverAddress) {
		replSeeds(serverAddress);
	}

}
