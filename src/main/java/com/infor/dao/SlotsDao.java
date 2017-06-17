package com.infor.dao;

import java.util.List;

import com.infor.models.InforSlots;

public interface SlotsDao {
	public List<InforSlots> getUnassignedSlots();
	public List<InforSlots> getAssignedSlots();
	
	/*
	 * get all slots via result of @getUnassignedSlots and @getAssignedSlots
	 */
	public List<InforSlots> getAllSlots();
}
