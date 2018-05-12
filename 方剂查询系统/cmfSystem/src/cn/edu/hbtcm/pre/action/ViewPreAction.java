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
	
	//��װ���������
	private Prescription prescription;
	private String medname;
	private String use;

	//Ҫ���ص�����
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
			// ����ActionContextʵ��
			ActionContext ctx = ActionContext.getContext();
			ApplicationContext  ctx1=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
			PrescriptionService  prescriptionService=(PrescriptionService)ctx1.getBean("prescriptionService");
			
			//�����Ʋ���
			if (prescription.getName()!=null&&!prescription.getName().equals("")) {
				prescriptions = prescriptionService.findByNameBlur(prescription.getName());
				if(prescriptions.size()<=0){
					msg="û�в鵽���ݣ�����������Ĳ�ѯ����";
				}
				return SUCCESS;
			}
			//��ҩ�����
			if (medname!=null&&!medname.equals("")) {
				prescriptions= prescriptionService.findbymedname(medname);
				if(prescriptions.size()<=0){
					msg="û�в鵽���ݣ�����������Ĳ�ѯ����";
				}
				return SUCCESS;
			}
			//�����ܲ���
			if (prescription.getFunctions()!=null&&!prescription.getFunctions().equals("")) {
				prescriptions = prescriptionService.findByFunction(prescription.getFunctions());
				if(prescriptions.size()<=0){
					msg="û�в鵽���ݣ�����������Ĳ�ѯ����";
				}
				return SUCCESS;
			}
			//�����β���
			if (prescription.getMajorfunction()!=null&&!prescription.getMajorfunction().equals("")) {
				prescriptions = prescriptionService.findByMajorfunction(prescription.getMajorfunction());
				if(prescriptions.size()<=0){
					msg="û�в鵽���ݣ�����������Ĳ�ѯ����";
				}
				return SUCCESS;
			}
			
			//������֢״����
			if (use!=null&&!use.equals("")) {
				prescriptions = prescriptionService.findByUse(use);
				if(prescriptions.size()<=0){
					msg="û�в鵽���ݣ�����������Ĳ�ѯ����";
				}
				return SUCCESS;
			}
			
			
			//��ժҪ����
			if (prescription.getAbstr()!=null&&!prescription.getAbstr().equals("")) {
				prescriptions= prescriptionService.findByAbstr(prescription.getAbstr());
				if(prescriptions.size()<=0){
					msg="û�в鵽���ݣ�����������Ĳ�ѯ����";
				}
				return SUCCESS;
			}
			//��û�����ݵĻ����ǲ�ѯ����
			prescriptions= prescriptionService.findAll();
			System.out.println(prescriptions);
			return SUCCESS;
		}
	
}