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
 * 测试类
 * @author Administrator
 *
 */
public class PreApp1 {
	
//	//测试save和findAll
//	public static void main(String[] args) {
//		
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Prescription prescription=new Prescription();
//		prescription.setName("aaaa");
//		prescription.setPre("红枣");
//		prescription.setFunction("补血");
//		prescriptionService.save(prescription);
//		
//		List<Prescription> asList = prescriptionService.findAll();
//		for (Prescription prescription2 : asList) {
//			System.out.println(prescription2.toString());
//		}
//		System.out.println(prescriptionService.count());
//	}
//	//测试findbyquery和delete
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
//	//测试分割
//	@Test
//	public void fun2() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Query<Prescription> query = prescriptionService.createQuery().field("name").equal("阿胶鳖甲汤");
//		List<Prescription> asList2 = prescriptionService.findByQuery(query);
//		for (Prescription prescription2 : asList2) {
//			System.out.println(prescription2.toString());
//			String[] split = prescription2.getPre().split("，");
//			System.out.println(split[0]);
//		}
//	}
//	//测试模糊查询
//	@Test
//	public void fun3() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Pattern pattern = Pattern.compile(".*" +"阿胶"+ ".*",Pattern.CASE_INSENSITIVE);
//		Query<Prescription> query = prescriptionService.createQuery();
//		List<Prescription> asList = query.filter("pre", pattern).asList();
//		for (Prescription prescription2 : asList) {
//			System.out.println(prescription2.toString());
//		}
//	}
//	//测试多个值模糊查询
//	@Test
//	public void fun4() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		String category="阿胶，杏仁";
//		String[] categorys = category.split("，");
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
	//测试prescriptionService
	@Test
	public void fun5() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Prescription prescription=new Prescription();
//		Map<String,String> map1 = new HashMap<String,String>();
//		map1.put("medname", "山药");
//		map1.put("dose", "1g");
//		Map<String,String> map2 = new HashMap<String,String>();
//		map2.put("medname", "红枣");
//		map2.put("dose", "2g");
//		prescription.getPre().add(map1);
//		prescription.getPre().add(map2);
//		String[] use={"肺炎","支气管炎"};
//		prescription.setUse(use);
//		prescriptionService.save_(prescription);
//		String name="阿胶";
//		String pre="阿胶，杏仁";
//		String function="秋燥，干咳";
		String abstr="外感风寒";
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

	//测试adminService
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
//	//测试更新,objectId相同时就是更新
//	@Test
//	public void fun8() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		ObjectId id=new ObjectId("5731a54197416fd833f51b01");
//		Prescription oldpre=prescriptionService.findByOid(id);
//		
//		Prescription newpre=new Prescription();
//		newpre.setName("阿胶鳖甲汤aaa");
//		System.out.println(prescriptionService.update(oldpre, newpre));
//		
//	}
	//测试
	@Test
	public void fun8() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		Prescription prescription = prescriptionService.findByName("乌梅丸");
		//System.out.println(prescription.getPre().length);
		System.out.println(prescriptionService.findmedname("乌梅丸", 1));
	}
	//测试json
	@Test
	public void fun10() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		Prescription prescription = prescriptionService.findByName("麻黄汤");
		System.out.println(prescription);
		JSONObject json = JSONObject.fromObject(prescription);//将java对象转换为json对象
		
		System.out.println(json);
	}
	//测试save pre
	@Test
	public void fun11() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		Prescription prescription = new Prescription();
		Pre pre1=new Pre();
		pre1.setMedname("桂枝");
		pre1.setDose("6g");
		Pre pre2=new Pre();
		pre2.setMedname("杏仁");
		pre2.setDose("6g");
		List<Pre> pres=new ArrayList<Pre>();
		pres.add(pre1);
		pres.add(pre2);
		prescription.setPre(pres);
		prescriptionService.save_(prescription);
	}
	//测试查询 pre
	@Test
	public void fun12() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		String medname="桂枝";
		List<Prescription> findbymedname = prescriptionService.findbymedname(medname);
		for (Prescription prescription : findbymedname) {
			System.out.println(prescription);
		}
	}
	//测试查询 medname
	@Test
	public void fun13() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		String name="乌梅丸";
		System.out.println(prescriptionService.findmedname(name, 1));
	}
	//测试查询 save
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
		Prescription prescription = prescriptionService.findByName("肥儿丸");
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
		//String Medname="茯苓";
		
		
		for(int j=0;j<medall;j++)
		{
			String Medname=medicineService.findmednamebyId(j);
		
			//System.out.println(Medname);
		//用来存放方剂中取出的药名
		String medname;
		List<Prescription> prescription;
		//用来存放id的值
		
		//返回通过药名所找到的方剂集合
		prescription=prescriptionDao.findbymedname(Medname);
		//System.out.println(prescription);

		//System.out.println(x);
		//将查找出来的方剂遍历
		for(Prescription Prescription:prescription){
			//取每个方剂的所有药物
			for(int i=0;i<Prescription.getPre().size();i++){
				//取Prescription方剂中的第i味药
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
		boolean b = relationService.existsrelation("茯苓", "神曲");
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
		prename.add("大枣汤");
		prename.add("干姜汤");
		matrixRelation.setSource("大枣");
		matrixRelation.setTarget("干姜");
		matrixRelation.setPrename(prename);
		matrixRelationDao.insertMatrix(matrixRelation);
	}
	@Test
	public void insertPrename() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MatrixRelationService matrixRelationService=(MatrixRelationService)ctx.getBean("matrixRelationService");
        String prename="aaa";
        String source="乌梅";
        String target="干姜";
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
		
		
		//String Medname="茯苓";
		
		
		
		
		List<Prescription> prescriptions;
		prescriptions=prescriptionDao.findAll();
		//System.out.println(prescription);
		for(Prescription prescription:prescriptions){
			for(int i=0;i<prescription.getPre().size();i++){
				//取Prescription方剂中的第i味药
				String Medname=prescriptionDao.findmedname(prescription.getName(),i);
				//通过药名返回Id值
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
