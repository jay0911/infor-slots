package com.infor.endpoint;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infor.dto.SlotsDTO;
import com.infor.models.InforParking;
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
	
	@GetMapping("/getUnAvailSlot")
	public SlotsDTO getUnAvailSlot() {
		// TODO Auto-generated method stub
		SlotsDTO dto = InstantationUtil.createSlotsDTOInstance();
		dto.setInforSlots(slotService.getUnAvailSlot());
		return dto;
	}
	
	@GetMapping("/getAvailSlot")
	public SlotsDTO getAvailSlot() {
		// TODO Auto-generated method stub
		SlotsDTO dto = InstantationUtil.createSlotsDTOInstance();
		dto.setInforSlots(slotService.getAvailSlot());
		return dto;
	}
	
	@PostMapping("/getAllSlotsConditional")
	public SlotsDTO getAllSlotsConditional(@RequestBody InforParking ip){
		SlotsDTO dto = InstantationUtil.createSlotsDTOInstance();
		dto.setInforSlots(slotService.getAllSlotsConditional(ip));
		return dto;
	}
}
