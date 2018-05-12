package cn.edu.hbtcm.pre.action;




import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.hbtcm.pre.domain.MatrixRelation;
import cn.edu.hbtcm.pre.domain.Prescription;
import cn.edu.hbtcm.pre.service.MatrixRelationService;
import cn.edu.hbtcm.pre.service.PrescriptionService;
import cn.edu.hbtcm.pre.utils.Format;
import net.sf.json.JSONObject;




public class MatrixRelationAction extends ActionSupport
{
	
	//��װ���������
	private MatrixRelation matrixRelation;

	//Ҫ���ص�����
	List<MatrixRelation> matrixRelations;
	private String msg;
	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public List<MatrixRelation> getMatrixRelations() {
		return matrixRelations;
	}


	public void setMatrixRelations(List<MatrixRelation> matrixRelations) {
		this.matrixRelations = matrixRelations;
	}


	public MatrixRelation getMatrixRelation() {
		return matrixRelation;
	}


	public void setMatrixRelation(MatrixRelation matrixRelation) {
		this.matrixRelation = matrixRelation;
	}


	public String execute() throws Exception{
			// ����ActionContextʵ��
			ActionContext ctx = ActionContext.getContext();
			ApplicationContext  ctx1=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
			MatrixRelationService  matrixRelationService=(MatrixRelationService)ctx1.getBean("matrixRelationService");
			//��source target����
			if (matrixRelation.getSource()!=null&&!matrixRelation.getSource().equals("")&&matrixRelation.getTarget()!=null&&!matrixRelation.getTarget().equals("")) {
				matrixRelations = matrixRelationService.findbySourceandTarget(matrixRelation.getSource(), matrixRelation.getTarget());
				if (matrixRelations.size()<=0) {
					matrixRelations = matrixRelationService.findbySourceandTarget(matrixRelation.getTarget(),matrixRelation.getSource());
				}
				
				if(matrixRelations.size()<=0){
					msg="û�в鵽���ݣ�����������Ĳ�ѯ����";
				}
				return SUCCESS;
			}
			
			//��û�����ݵĻ����ǲ�ѯ����
			matrixRelations = matrixRelationService.findAll();
			return SUCCESS;
		}
	
}