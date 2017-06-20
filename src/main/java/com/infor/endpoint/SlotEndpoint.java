package com.infor.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infor.dto.SlotsDTO;
import com.infor.service.SlotsService;
import com.infor.utils.InstantationUtil;

@RestController
public class SlotEndpoint {
	@Autowired
	private SlotsService slotService;
	
	@GetMapping("/getUnassignedSlots")
	public SlotsDTO getUnassignedSlots(){
		SlotsDTO dto = InstantationUtil.createSlotsDTOInstance();
		dto.setInforSlots(slotService.getUnassignedSlots());
		return dto;
	}
	
	@GetMapping("/getAssignedSlots")
	public SlotsDTO getAssignedSlots(){
		SlotsDTO dto = InstantationUtil.createSlotsDTOInstance();
		dto.setInforSlots(slotService.getAssignedSlots());
		return dto;
	}
	
	/*
	 * get all slots via result of @getUnassignedSlots and @getAssignedSlots
	 */
	@GetMapping("/getAllSlots")
	public SlotsDTO getAllSlots(){
		SlotsDTO dto = InstantationUtil.createSlotsDTOInstance();
		dto.setInforSlots(slotService.getAllSlots());
		return dto;
	}
}
