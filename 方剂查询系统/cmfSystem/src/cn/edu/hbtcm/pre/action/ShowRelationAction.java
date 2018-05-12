package cn.edu.hbtcm.pre.action;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.hbtcm.pre.domain.MatrixRelation;
import cn.edu.hbtcm.pre.domain.Prescription;
import cn.edu.hbtcm.pre.domain.Rel;
import cn.edu.hbtcm.pre.service.MatrixRelationService;
import cn.edu.hbtcm.pre.service.PrescriptionService;
import cn.edu.hbtcm.pre.service.RelationService;
import cn.edu.hbtcm.pre.service.impl.RelationServiceImpl;
import cn.edu.hbtcm.pre.utils.Format;
import net.sf.json.JSONObject;




public class ShowRelationAction extends ActionSupport
{

	
	//��װ���������
	private String medname;

	//���ص�����
	List<Rel> rels;
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Rel> getRels() {
		return rels;
	}
	public void setRels(List<Rel> rels) {
		this.rels = rels;
	}
	public String getMedname() {
		return medname;
	}


//	public RelationService getRelationService() {
//		return relationService;
//	}
//	public void setRelationService(RelationService relationService) {
//		this.relationService = relationService;
//	}
	public void setMedname(String medname) {
		this.medname = medname;
	}

	public String execute() throws Exception{
			// ����ActionContextʵ��
			ActionContext ctx = ActionContext.getContext();
			//��ҩ������
			System.out.println(medname);
			ApplicationContext  ctx1=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
			RelationService  relationService=(RelationService)ctx1.getBean("relationService");
			rels=relationService.findonerelation(medname);
			if(rels.size()<=0){
				msg="û�в鵽���ݣ�����������Ĳ�ѯ����";
			}
			System.out.println(rels);
			
			return SUCCESS;
			
			
		}
	
}