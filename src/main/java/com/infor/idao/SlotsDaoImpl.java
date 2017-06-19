package com.infor.idao;

import java.util.List;

import com.infor.dao.SlotsDao;
import com.infor.models.InforSlots;

public class SlotsDaoImpl extends HibernateDaoSupport implements SlotsDao{

	private final static String SELECT_ALL_SLOTS = "select * from tbl_inforparking ip inner join tbl_inforuser iu on ip.userid = iu.userid";
	private final static String SELECT_UNASSIGNED_SLOTS = "from InforParking ip where ip.userid=0";
	private final static String SELECT_ASSIGNED_SLOTS = "select * from tbl_inforparking ip inner join tbl_inforuser iu on ip.userid = iu.userid where ip.userid !=0";
	
	@Override
	public List<InforSlots> getUnassignedSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InforSlots> getAssignedSlots() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InforSlots> getAllSlots() {
		// TODO Auto-generated method stub
		return null;
	}

}
