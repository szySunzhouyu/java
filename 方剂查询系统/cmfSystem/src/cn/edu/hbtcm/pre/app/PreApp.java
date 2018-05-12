package cn.edu.hbtcm.pre.app;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import cn.edu.hbtcm.pre.domain.Admin;
import cn.edu.hbtcm.pre.domain.Medicine;
import cn.edu.hbtcm.pre.domain.Pre;
import cn.edu.hbtcm.pre.domain.Prescription;
import cn.edu.hbtcm.pre.domain.Rel;
import cn.edu.hbtcm.pre.service.AdminService;
import cn.edu.hbtcm.pre.service.MedicineService;
import cn.edu.hbtcm.pre.service.PrescriptionService;
import cn.edu.hbtcm.pre.service.RelationService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * ≤‚ ‘¿‡
 * @author Administrator
 *
 */
public class PreApp {
	
//	//≤‚ ‘save∫ÕfindAll
//	public static void main(String[] args) {
//		
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Prescription prescription=new Prescription();
//		prescription.setName("aaaa");
//		prescription.setPre("∫Ï‘Ê");
//		prescription.setFunction("≤π—™");
//		prescriptionService.save(prescription);
//		
//		List<Prescription> asList = prescriptionService.findAll();
//		for (Prescription prescription2 : asList) {
//			System.out.println(prescription2.toString());
//		}
//		System.out.println(prescriptionService.count());
//	}
//	//≤‚ ‘findbyquery∫Õdelete
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
//	//≤‚ ‘∑÷∏Ó
//	@Test
//	public void fun2() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Query<Prescription> query = prescriptionService.createQuery().field("name").equal("∞¢Ω∫±Óº◊Ã¿");
//		List<Prescription> asList2 = prescriptionService.findByQuery(query);
//		for (Prescription prescription2 : asList2) {
//			System.out.println(prescription2.toString());
//			String[] split = prescription2.getPre().split("£¨");
//			System.out.println(split[0]);
//		}
//	}
//	//≤‚ ‘ƒ£∫˝≤È—Ø
//	@Test
//	public void fun3() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Pattern pattern = Pattern.compile(".*" +"∞¢Ω∫"+ ".*",Pattern.CASE_INSENSITIVE);
//		Query<Prescription> query = prescriptionService.createQuery();
//		List<Prescription> asList = query.filter("pre", pattern).asList();
//		for (Prescription prescription2 : asList) {
//			System.out.println(prescription2.toString());
//		}
//	}
//	//≤‚ ‘∂‡∏ˆ÷µƒ£∫˝≤È—Ø
//	@Test
//	public void fun4() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		String category="∞¢Ω∫£¨–”» ";
//		String[] categorys = category.split("£¨");
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
	//≤‚ ‘prescriptionService
	@Test
	public void fun5() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		Prescription prescription=new Prescription();
//		Map<String,String> map1 = new HashMap<String,String>();
//		map1.put("medname", "…Ω“©");
//		map1.put("dose", "1g");
//		Map<String,String> map2 = new HashMap<String,String>();
//		map2.put("medname", "∫Ï‘Ê");
//		map2.put("dose", "2g");
//		prescription.getPre().add(map1);
//		prescription.getPre().add(map2);
//		String[] use={"∑Œ—◊","÷ß∆¯π‹—◊"};
//		prescription.setUse(use);
//		prescriptionService.save_(prescription);
//		String name="∞¢Ω∫";
//		String pre="∞¢Ω∫£¨–”» ";
//		String function="«Ô‘Ô£¨∏…ø»";
		String abstr="Õ‚∏–∑Á∫Æ";
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

	//≤‚ ‘adminService
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
//	//≤‚ ‘∏¸–¬,objectIdœ‡Õ¨ ±æÕ «∏¸–¬
//	@Test
//	public void fun8() {
//		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext-resource.xml");
//		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
//		ObjectId id=new ObjectId("5731a54197416fd833f51b01");
//		Prescription oldpre=prescriptionService.findByOid(id);
//		
//		Prescription newpre=new Prescription();
//		newpre.setName("∞¢Ω∫±Óº◊Ã¿aaa");
//		System.out.println(prescriptionService.update(oldpre, newpre));
//		
//	}
	//≤‚ ‘
	@Test
	public void fun8() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		Prescription prescription = prescriptionService.findByName("Œ⁄√∑ÕË");
		//System.out.println(prescription.getPre().length);
		System.out.println(prescriptionService.findmedname("Œ⁄√∑ÕË", 1));
	}
	//≤‚ ‘json
	@Test
	public void fun10() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		Prescription prescription = prescriptionService.findByName("¬Èª∆Ã¿");
		System.out.println(prescription);
		JSONObject json = JSONObject.fromObject(prescription);//Ω´java∂‘œÛ◊™ªªŒ™json∂‘œÛ
		
		System.out.println(json);
	}
	//≤‚ ‘save pre
	@Test
	public void fun11() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		Prescription prescription = new Prescription();
		Pre pre1=new Pre();
		pre1.setMedname("π÷¶");
		pre1.setDose("6g");
		Pre pre2=new Pre();
		pre2.setMedname("–”» ");
		pre2.setDose("6g");
		List<Pre> pres=new ArrayList<Pre>();
		pres.add(pre1);
		pres.add(pre2);
		prescription.setPre(pres);
		prescriptionService.save_(prescription);
	}
	//≤‚ ‘≤È—Ø pre
	@Test
	public void fun12() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		String medname="π÷¶";
		List<Prescription> findbymedname = prescriptionService.findbymedname(medname);
		for (Prescription prescription : findbymedname) {
			System.out.println(prescription);
		}
	}
	//≤‚ ‘≤È—Ø medname
	@Test
	public void fun13() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		PrescriptionService  prescriptionService=(PrescriptionService)ctx.getBean("prescriptionService");
		String name="Œ⁄√∑ÕË";
		System.out.println(prescriptionService.findmedname(name, 1));
	}
	//≤‚ ‘≤È—Ø save
	@Test
	public void fun14() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MedicineService  medicineService=(MedicineService)ctx.getBean("medicineService");
		Medicine medicine=new Medicine();
		medicine.setId(123);
		medicineService.saveEntity(medicine);
	}
	@Test
	public void fun15() {
		ApplicationContext  ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		RelationService  relationService=(RelationService)ctx.getBean("relationService");
		
		List<Rel> findonerelation = relationService.findonerelation("Œ⁄√∑");
		for (Rel rel : findonerelation) {
			System.out.println(rel);
		}
	}
}
