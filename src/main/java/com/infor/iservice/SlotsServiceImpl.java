package com.infor.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infor.dao.SlotsDao;
import com.infor.dto.SlotsDTO;
import com.infor.models.InforSlots;
import com.infor.service.SlotsService;

@Service
public class SlotsServiceImpl implements SlotsService{
	private static final String NOT_OCCUPIED = "select distinct iu.userid,iu.firstname,iu.lastname,iu.contactnumber,iu.emailaddress,iu.inforaddress,iu.position,ip.parkingid,ip.isparkingtandem from tbl_inforparking ip inner join tbl_inforuser iu on ip.userid = iu.userid inner join tbl_infortransaction tif on iu.userid = tif.userid where tif.parkingid=:parkingid and tif.timeout != '-'";
	private static final String OCCUPIED = "select distinct iu.userid,iu.firstname,iu.lastname,iu.contactnumber,iu.emailaddress,iu.inforaddress,iu.position,ip.parkingid,ip.isparkingtandem from tbl_inforparking ip inner join tbl_inforuser iu on ip.userid = iu.userid inner join tbl_infortransaction tif on iu.userid = tif.userid where tif.parkingid=:parkingid and tif.timeout = '-'";	
	@Autowired
	SlotsDao slotsDao;

	@Override
	public List<InforSlots> getUnassignedSlots() {
		// TODO Auto-generated method stub
		return slotsDao.getUnassignedSlots();
	}

	@Override
	public List<InforSlots> getAssignedSlots() {
		// TODO Auto-generated method stub
		return slotsDao.getAssignedSlots();
	}

	@Override
	public List<InforSlots> getAllSlots() {
		// TODO Auto-generated method stub
		return slotsDao.getAllSlots();
	}

	@Override
	public List<InforSlots> getAvailSlot() {
		// TODO Auto-generated method stub
		return slotsDao.getAvailSlot();
	}

	@Override
	public List<InforSlots> getUnAvailSlot() {
		// TODO Auto-generated method stub
		return slotsDao.getUnAvailSlot();
	}

	@Override
	public List<InforSlots> getAllSlotsConditional(SlotsDTO ip) {
		// TODO Auto-generated method stub
		if(ip.getOccupancy_flagger().equals("occupied")){
			return slotsDao.getAllSlotsConditional(ip.getParking(),OCCUPIED);
		}else{
			return slotsDao.getAllSlotsConditional(ip.getParking(),NOT_OCCUPIED);
		}	
	}

}
