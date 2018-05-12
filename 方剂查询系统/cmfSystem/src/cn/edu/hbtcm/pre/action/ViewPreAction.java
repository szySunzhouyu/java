package cn.edu.hbtcm.pre.action;




import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import cn.edu.hbtcm.pre.domain.Prescription;
import cn.edu.hbtcm.pre.service.PrescriptionService;
import cn.edu.hbtcm.pre.service.RelationService;
import cn.edu.hbtcm.pre.utils.Format;
import net.sf.json.JSONObject;



public class ViewPreAction extends ActionSupport
{
	
	//封装请求的数据
	private Prescription prescription;
	private String medname;
	private String use;

	//要返回的数据
	private List<Prescription> prescriptions;
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}
	
	
	public List<Prescription> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<Prescription> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public String getMedname() {
		return medname;
	}

	public void setMedname(String medname) {
		this.medname = medname;
	}

	

	public Prescription getPrescription() {
		return prescription;
	}

	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	} 
	public String execute() throws Exception{
			// 创建ActionContext实例
			ActionContext ctx = ActionContext.getContext();
			ApplicationContext  ctx1=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
			PrescriptionService  prescriptionService=(PrescriptionService)ctx1.getBean("prescriptionService");
			
			//按名称查找
			if (prescription.getName()!=null&&!prescription.getName().equals("")) {
				prescriptions = prescriptionService.findByNameBlur(prescription.getName());
				if(prescriptions.size()<=0){
					msg="没有查到数据，请检查您输入的查询条件";
				}
				return SUCCESS;
			}
			//按药物查找
			if (medname!=null&&!medname.equals("")) {
				prescriptions= prescriptionService.findbymedname(medname);
				if(prescriptions.size()<=0){
					msg="没有查到数据，请检查您输入的查询条件";
				}
				return SUCCESS;
			}
			//按功能查找
			if (prescription.getFunctions()!=null&&!prescription.getFunctions().equals("")) {
				prescriptions = prescriptionService.findByFunction(prescription.getFunctions());
				if(prescriptions.size()<=0){
					msg="没有查到数据，请检查您输入的查询条件";
				}
				return SUCCESS;
			}
			//按主治查找
			if (prescription.getMajorfunction()!=null&&!prescription.getMajorfunction().equals("")) {
				prescriptions = prescriptionService.findByMajorfunction(prescription.getMajorfunction());
				if(prescriptions.size()<=0){
					msg="没有查到数据，请检查您输入的查询条件";
				}
				return SUCCESS;
			}
			
			//按适用症状查找
			if (use!=null&&!use.equals("")) {
				prescriptions = prescriptionService.findByUse(use);
				if(prescriptions.size()<=0){
					msg="没有查到数据，请检查您输入的查询条件";
				}
				return SUCCESS;
			}
			
			
			//按摘要查找
			if (prescription.getAbstr()!=null&&!prescription.getAbstr().equals("")) {
				prescriptions= prescriptionService.findByAbstr(prescription.getAbstr());
				if(prescriptions.size()<=0){
					msg="没有查到数据，请检查您输入的查询条件";
				}
				return SUCCESS;
			}
			//都没有数据的话就是查询所有
			prescriptions= prescriptionService.findAll();
			System.out.println(prescriptions);
			return SUCCESS;
		}
	
}