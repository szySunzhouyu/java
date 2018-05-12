package cn.edu.hbtcm.pre.app;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.hbtcm.pre.dao.MatrixRelationDao;
import cn.edu.hbtcm.pre.dao.MedicineDao;
import cn.edu.hbtcm.pre.dao.PrescriptionDao;
import cn.edu.hbtcm.pre.dao.RelationDao;
import cn.edu.hbtcm.pre.dao.impl.PrescriptionDaoImpl;
import cn.edu.hbtcm.pre.domain.Admin;
import cn.edu.hbtcm.pre.domain.MatrixRelation;
import cn.edu.hbtcm.pre.domain.Medicine;
import cn.edu.hbtcm.pre.domain.Pre;
import cn.edu.hbtcm.pre.domain.Prescription;
import cn.edu.hbtcm.pre.domain.Rel;
import cn.edu.hbtcm.pre.domain.Relation;
import cn.edu.hbtcm.pre.service.AdminService;
import cn.edu.hbtcm.pre.service.MatrixRelationService;
import cn.edu.hbtcm.pre.service.MedicineService;
import cn.edu.hbtcm.pre.service.PrescriptionService;
import cn.edu.hbtcm.pre.service.RelationService;
import cn.edu.hbtcm.pre.service.RelationshipService;
import cn.edu.hbtcm.pre.service.impl.PrescriptionServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * ������
 * @author Administrator
 *
 */
public class PreApp1 {
	
//	//����save��findAll
//	public static void main(String[] args) {
//		
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Prescription prescription=new Prescription();
//		prescription.setName("aaaa");
//		prescription.setPre("����");
//		prescription.setFunction("��Ѫ");
//		prescriptionService.save(prescription);
//		
//		List<Prescription> asList = prescriptionService.findAll();
//		for (Prescription prescription2 : asList) {
//			System.out.println(prescription2.toString());
//		}
//		System.out.println(prescriptionService.count());
//	}
//	//����findbyquery��delete
//	@Test
//	public void fun1() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Query<Prescription> query = prescriptionService.createQuery().field("name").equal("aaaa");
//		List<Prescription> asList2 = prescriptionService.findByQuery(query);
//		for (Prescription prescription2 : asList2) {
//			prescriptionService.delete(prescription2);
//		}
//	}
//	//���Էָ�
//	@Test
//	public void fun2() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Query<Prescription> query = prescriptionService.createQuery().field("name").equal("���������");
//		List<Prescription> asList2 = prescriptionService.findByQuery(query);
//		for (Prescription prescription2 : asList2) {
//			System.out.println(prescription2.toString());
//			String[] split = prescription2.getPre().split("��");
//			System.out.println(split[0]);
//		}
//	}
//	//����ģ����ѯ
//	@Test
//	public void fun3() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Pattern pattern = Pattern.compile(".*" +"����"+ ".*",Pattern.CASE_INSENSITIVE);
//		Query<Prescription> query = prescriptionService.createQuery();
//		List<Prescription> asList = query.filter("pre", pattern).asList();
//		for (Prescription prescription2 : asList) {
//			System.out.println(prescription2.toString());
//		}
//	}
//	//���Զ��ֵģ����ѯ
//	@Test
//	public void fun4() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		String category="����������";
//		String[] categorys = category.split("��");
//		List<Pattern> patterns = new ArrayList<>();
//		for (String treeIndex : categorys) {
//			Pattern pattern = Pattern.compile(".*" + treeIndex + ".*", Pattern.CASE_INSENSITIVE);
//			patterns.add(pattern);
//		}
//
//		Query<Prescription> query = prescriptionService.createQuery();
//		List<Prescription> asList = query.filter("pre all", patterns).asList();
//		for (Prescription prescription2 : asList) {
//			System.out.println(prescription2.toString());
//		}
//	}
	//����prescriptionService
	@Test
	public void fun5() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Prescription prescription=new Prescription();
//		Map<String,String> map1 = new HashMap<String,String>();
//		map1.put("medname", "ɽҩ");
//		map1.put("dose", "1g");
//		Map<String,String> map2 = new HashMap<String,String>();
//		map2.put("medname", "����");
//		map2.put("dose", "2g");
//		prescription.getPre().add(map1);
//		prescription.getPre().add(map2);
//		String[] use={"����","֧������"};
//		prescription.setUse(use);
//		prescriptionService.save_(prescription);
//		String name="����";
//		String pre="����������";
//		String function="����ɿ�";
		String abstr="��з纮";
//		List<Prescription> findByName = prescriptionService.findByName(name);
//		for (Prescription prescription : findByName) {
//			System.out.println(prescription);
//		}
//		List<Prescription> findByFunction = prescriptionService.findByFunction(function);
//		for (Prescription prescription : findByFunction) {
//			System.out.println(prescription);
//		}
		List<Prescription> findByAbstrc = prescriptionService.findByAbstr(abstr);
		for (Prescription prescription : findByAbstrc) {
			System.out.println(prescription);
		}
	}

	//����adminService
	@Test
	public void fun17() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		AdminService  adminService=(AdminService)ctx.getBean("adminService");
		Admin admin=new Admin(null, "admin11", "123aa", "admin@qq.com");
		adminService.addAdmin(admin);
		String username="admin";
		Admin admin2 = adminService.findByName(username);
		System.out.println(admin2);
	}
//	//���Ը���,objectId��ͬʱ���Ǹ���
//	@Test
//	public void fun8() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		ObjectId id=new ObjectId("5731a54197416fd833f51b01");
//		Prescription oldpre=prescriptionService.findByOid(id);
//		
//		Prescription newpre=new Prescription();
//		newpre.setName("���������aaa");
//		System.out.println(prescriptionService.update(oldpre, newpre));
//		
//	}
	//����
	@Test
	public void fun8() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		Prescription prescription = prescriptionService.findByName("��÷��");
		//System.out.println(prescription.getPre().length);
		System.out.println(prescriptionService.findmedname("��÷��", 1));
	}
	//����json
	@Test
	public void fun10() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		Prescription prescription = prescriptionService.findByName("�����");
		System.out.println(prescription);
		JSONObject json = JSONObject.fromObject(prescription);//��java����ת��Ϊjson����
		
		System.out.println(json);
	}
	//����save pre
	@Test
	public void fun11() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		Prescription prescription = new Prescription();
		Pre pre1=new Pre();
		pre1.setMedname("��֦");
		pre1.setDose("6g");
		Pre pre2=new Pre();
		pre2.setMedname("����");
		pre2.setDose("6g");
		List<Pre> pres=new ArrayList<Pre>();
		pres.add(pre1);
		pres.add(pre2);
		prescription.setPre(pres);
		prescriptionService.save_(prescription);
	}
	//���Բ�ѯ pre
	@Test
	public void fun12() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		String medname="��֦";
		List<Prescription> findbymedname = prescriptionService.findbymedname(medname);
		for (Prescription prescription : findbymedname) {
			System.out.println(prescription);
		}
	}
	//���Բ�ѯ medname
	@Test
	public void fun13() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		String name="��÷��";
		System.out.println(prescriptionService.findmedname(name, 1));
	}
	//���Բ�ѯ save
	@Test
	public void fun14() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MedicineService  medicineService=(MedicineService)ctx.getBean("medicineService");
		Medicine medicine=new Medicine();
		medicine.setId(123);
		medicineService.saveEntity(medicine);
	}
	
	@Test
	public void findnameByPre() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		MatrixRelationService matrixRelationService=(MatrixRelationService)ctx.getBean("matrixRelationService");
		Prescription prescription = prescriptionService.findByName("�ʶ���");
		String s=matrixRelationService.findnameByPre(prescription);
		System.out.println(s);
		
	}
	
	@Test
	public void creatmedicinetable(){
		String medname;
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionDao prescriptionDao=(PrescriptionDao)ctx.getBean("prescriptionDao");
		MedicineService medicineService=(MedicineService)ctx.getBean("medicineService");
		List<Prescription> prescription=prescriptionDao.findAll();
		
		Medicine medicine=new Medicine();
		int count=0;
		for(Prescription Prescription:prescription){
		  for(int i=0;i<Prescription.getPre().size();i++){
			  medname=prescriptionDao.findmedname(Prescription.getName(), i);
			  //System.out.print(medname+" ");
			  if(!medicineService.exsitmed(medname)){
				  medicine.setId(count);
				  count+=1;
				  medicine.setMedname(medname);
				  medicineService.saveEntity(medicine);
				 // System.out.println(medname+" ");
			  }
		  }
		}
	}
	public static  int medall=93;
	public static void printMatrix(int b[][]){
		int count=0;
		for(int m=0;m<medall;m++)
			for(int n=0;n<medall;n++){
				if(count % medall==0)
					System.out.println();
				System.out.print(b[m][n]+" ");
				count+=1;
			}
	}
	@Test
	public void createrelation(){
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionDao prescriptionDao=(PrescriptionDao)ctx.getBean("prescriptionDao");
		RelationDao relDao=(RelationDao)ctx.getBean("relationDao");
		MedicineService medicineService=(MedicineService)ctx.getBean("medicineService");
		
		Relation relation=new Relation();
		List<Rel> rels=new ArrayList<Rel>();
		//String Medname="����";
		
		
		for(int j=0;j<medall;j++)
		{
			String Medname=medicineService.findmednamebyId(j);
		
			//System.out.println(Medname);
		//������ŷ�����ȡ����ҩ��
		String medname;
		List<Prescription> prescription;
		//�������id��ֵ
		
		//����ͨ��ҩ�����ҵ��ķ�������
		prescription=prescriptionDao.findbymedname(Medname);
		//System.out.println(prescription);

		//System.out.println(x);
		//�����ҳ����ķ�������
		for(Prescription Prescription:prescription){
			//ȡÿ������������ҩ��
			for(int i=0;i<Prescription.getPre().size();i++){
				//ȡPrescription�����еĵ�iζҩ
				medname=prescriptionDao.findmedname(Prescription.getName(),i);
				Rel rel=new Rel();
				//System.out.println(Medname+" "+medname);
				if(!Medname.equals(medname)){
					
					rel.setSource(Medname);
					rel.setTarget(medname);
					rels.add(rel);
					relation.setRel(rels);
				}

				
				
			}
		}
		//System.out.println(relation);
		relDao.insertrelation(relation);
		}
		//printMatrix(a);
		//System.out.println(relDao.findAll());
	}
	@Test
	public void existsrelation() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		RelationService  relationService=(RelationService)ctx.getBean("relationService");
		boolean b = relationService.existsrelation("����", "����");
		System.out.println(b);
	}
//	@Test
//	public void  ma(){
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//		RelationshipService  relationshipService=(RelationshipService)ctx.getBean("relationshipService");
//		int[][]a=relationshipService.getMatrix();
//		relationshipService.printMatrix(a);
//	}
	@Test
	public void asd(){
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MatrixRelationDao matrixRelationDao=(MatrixRelationDao)ctx.getBean("matrixRelationDao");
		MatrixRelation matrixRelation=new MatrixRelation();
		List<String> prename =new ArrayList<String>();
		prename.add("������");
		prename.add("�ɽ���");
		matrixRelation.setSource("����");
		matrixRelation.setTarget("�ɽ�");
		matrixRelation.setPrename(prename);
		matrixRelationDao.insertMatrix(matrixRelation);
	}
	@Test
	public void insertPrename() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MatrixRelationService matrixRelationService=(MatrixRelationService)ctx.getBean("matrixRelationService");
        String prename="aaa";
        String source="��÷";
        String target="�ɽ�";
        matrixRelationService.insertPrename(source,target,prename);
		System.out.println(prename);
	}
	
	@Test
	public void Matrixshow1(){
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionDao prescriptionDao=(PrescriptionDao)ctx.getBean("prescriptionDao");
		RelationDao relDao=(RelationDao)ctx.getBean("relationDao");
		MedicineService medicineService=(MedicineService)ctx.getBean("medicineService");
		MatrixRelationDao matrixRelationDao=(MatrixRelationDao)ctx.getBean("matrixRelationDao");
		
		
		//String Medname="����";
		
		
		
		
		List<Prescription> prescriptions;
		prescriptions=prescriptionDao.findAll();
		//System.out.println(prescription);
		for(Prescription prescription:prescriptions){
			for(int i=0;i<prescription.getPre().size();i++){
				//ȡPrescription�����еĵ�iζҩ
				String Medname=prescriptionDao.findmedname(prescription.getName(),i);
				//ͨ��ҩ������Idֵ
				for(int m=i+1;m<prescription.getPre().size();m++){
					String medname = prescriptionDao.findmedname(prescription.getName(),m);
					MatrixRelation matrixRelation=new MatrixRelation();
					List<String> prename=new ArrayList<String>();
					//System.out.println(medname+" "+Medname);
					//System.out.println(matrixRelationDao.findbySourceandTarget(medname,Medname).isEmpty()+"   "+matrixRelationDao.findbySourceandTarget(Medname,medname).isEmpty());
					if(matrixRelationDao.findbySourceandTarget(medname,Medname).isEmpty()
							&& matrixRelationDao.findbySourceandTarget(Medname,medname).isEmpty()){
						//System.out.println("sadasdas");
						matrixRelation.setSource(Medname);
						matrixRelation.setTarget(medname);
						prename.add(prescription.getName());
						matrixRelation.setPrename(prename);
						matrixRelationDao.insertMatrix(matrixRelation);
					}
					else{
						if(matrixRelationDao.findbySourceandTarget(medname,Medname).isEmpty())
							matrixRelationDao.insertPrename(Medname, medname,prescription.getName());
						else
							matrixRelationDao.insertPrename(medname, Medname, prescription.getName());
					}
					//System.out.println(matrixRelation);
				}//m
			  }//i
			}//pre
		}
			

}
