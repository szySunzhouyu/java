package cn.edu.hbtcm.pre.ext;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.google.code.morphia.Morphia;

/**
 * ͨ���̳�  AbstractFactoryBean<Morphia> �������� Morphia�Ĺ���bean
 * @author Administrator
 *
 */
public class MorphiaFactoryBean extends AbstractFactoryBean<Morphia> {

	//Ҫɨ�貢ӳ��İ�
	private String[] mapPackages;
	//Ҫӳ����� 
	private String[] mapClasses;
	//ɨ���ʱ���Ƿ���Բ�ӳ����� ���ﰴ��Morphia��ԭʼ���壬Ĭ����Ϊfalse 
	private boolean ignoreInvalidClasses;

	@Override
	public Class<?> getObjectType() {
		return Morphia.class;
	}

	@Override
	protected Morphia createInstance() throws Exception {
		Morphia m = new Morphia();
		if (mapPackages != null) {
			for (String packageName : mapPackages) {
				m.mapPackage(packageName, ignoreInvalidClasses);
			}
		}
		if (mapClasses != null) {
			for (String entityClass : mapClasses) {
				m.map(Class.forName(entityClass));
			}
		}
		return m;
	}

	public void setMapPackages(String[] mapPackages) {
		this.mapPackages = mapPackages;
	}

	public void setMapClasses(String[] mapClasses) {
		this.mapClasses = mapClasses;
	}

	public void setIgnoreInvalidClasses(boolean ignoreInvalidClasses) {
		this.ignoreInvalidClasses = ignoreInvalidClasses;
	}


}
