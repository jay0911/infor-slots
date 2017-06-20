package com.infor.service;

import java.util.List;

import com.infor.models.InforSlots;

public interface SlotsService {
	public List<InforSlots> getUnassignedSlots();
	public List<InforSlots> getAssignedSlots();
	
	/*
	 * get all slots via result of @getUnassignedSlots and @getAssignedSlots
	 */
	public List<InforSlots> getAllSlots();
}
