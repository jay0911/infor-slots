package com.infor.dao;

import java.util.List;

import com.infor.models.InforParking;
import com.infor.models.InforSlots;

public interface SlotsDao {
	public List<InforSlots> getUnassignedSlots();
	public List<InforSlots> getAssignedSlots();
	
	/*
	 * get all slots via result of @getUnassignedSlots and @getAssignedSlots
	 */
	public List<InforSlots> getAllSlots();
	
	public List<InforSlots> getAvailSlot();
	public List<InforSlots> getUnAvailSlot();
	
	public List<InforSlots> getAllSlotsConditional(InforParking ip);
}
