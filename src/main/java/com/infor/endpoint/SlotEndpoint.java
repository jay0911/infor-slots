package com.infor.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infor.dto.SlotsDTO;
import com.infor.service.SlotsService;
import com.infor.utils.InstantationUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value="slot monitoring service", description="This is the endpoint for getting the information of available slots and monitoring of slots in the parking")
public class SlotEndpoint {
	@Autowired
	private SlotsService slotService;
	
	@ApiOperation(value = "get all unassigned parking slots")
	@GetMapping("/getUnassignedSlots")
	public SlotsDTO getUnassignedSlots(){
		SlotsDTO dto = InstantationUtil.createSlotsDTOInstance();
		dto.setInforSlots(slotService.getUnassignedSlots());
		return dto;
	}
	
	@ApiOperation(value = "get all assigned parking slots")
	@GetMapping("/getAssignedSlots")
	public SlotsDTO getAssignedSlots(){
		SlotsDTO dto = InstantationUtil.createSlotsDTOInstance();
		dto.setInforSlots(slotService.getAssignedSlots());
		return dto;
	}
	
	/*
	 * get all slots via result of @getUnassignedSlots and @getAssignedSlots
	 */
	@ApiOperation(value = "get all assigned and unassigned parking slots")
	@GetMapping("/getAllSlots")
	public SlotsDTO getAllSlots(){
		SlotsDTO dto = InstantationUtil.createSlotsDTOInstance();
		dto.setInforSlots(slotService.getAllSlots());
		return dto;
	}
	
	@ApiOperation(value = "get all assigned parking slot with the owner occupying it real time")
	@GetMapping("/getUnAvailSlot")
	public SlotsDTO getUnAvailSlot() {
		// TODO Auto-generated method stub
		SlotsDTO dto = InstantationUtil.createSlotsDTOInstance();
		dto.setInforSlots(slotService.getUnAvailSlot());
		return dto;
	}
	
	@ApiOperation(value = "get all assigned parking slot with the owner NOT occupying it real time")
	@GetMapping("/getAvailSlot")
	public SlotsDTO getAvailSlot() {
		// TODO Auto-generated method stub
		SlotsDTO dto = InstantationUtil.createSlotsDTOInstance();
		dto.setInforSlots(slotService.getAvailSlot());
		return dto;
	}
	
	@ApiOperation(value = "get who is the user of the parkingslot when /getAvailSlot and /getUnAvailSlot is selected.",
			notes = "slots dto has a flagger weather occupied or not occupied query will be called")
	@PostMapping("/getAllSlotsConditional")
	public SlotsDTO getAllSlotsConditional(@RequestBody SlotsDTO requestdto){
		SlotsDTO dto = InstantationUtil.createSlotsDTOInstance();
		dto.setInforSlots(slotService.getAllSlotsConditional(requestdto));
		return dto;
	}
}
