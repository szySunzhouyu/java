package cn.edu.hbtcm.pre.service.impl;

import java.util.List;

import cn.edu.hbtcm.pre.dao.MedicineDao;
import cn.edu.hbtcm.pre.dao.PrescriptionDao;
import cn.edu.hbtcm.pre.domain.Medicine;
import cn.edu.hbtcm.pre.domain.Prescription;
import cn.edu.hbtcm.pre.service.MedicineService;
import cn.edu.hbtcm.pre.service.PrescriptionService;

public class MedicineServiceImpl implements MedicineService {

	private MedicineDao medicineDao;
	
    public MedicineDao getMedicineDao() {
		return medicineDao;
	}

	public void setMedicineDao(MedicineDao medicineDao) {
		this.medicineDao = medicineDao;
	}
	
	@Override
	public int findIdbymedname(String medname) {
		// TODO Auto-generated method stub
		return medicineDao.findIdbymedname(medname);
	}
	public String findmednamebyId(int id) {
		// TODO Auto-generated method stub
		return medicineDao.findmednamebyId(id);
	}
	@Override
	public int saveEntity(Medicine medicine) {
		// TODO Auto-generated method stub
		return medicineDao.save_(medicine);
	}

	@Override
	public boolean exsitmed(String medname) {
		// TODO Auto-generated method stub
		return medicineDao.existsmed(medname);
	}
	

}
