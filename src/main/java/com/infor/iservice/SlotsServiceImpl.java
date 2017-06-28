package com.infor.iservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infor.dao.SlotsDao;
import com.infor.models.InforSlots;
import com.infor.service.SlotsService;

@Service
public class SlotsServiceImpl implements SlotsService{
	
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

}
