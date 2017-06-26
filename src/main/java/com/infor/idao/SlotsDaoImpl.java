package com.infor.idao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.infor.dao.SlotsDao;
import com.infor.models.InforParking;
import com.infor.models.InforSlots;
import com.infor.models.InforUser;
import com.infor.utils.ConverterUtils;

@Repository
@Transactional
public class SlotsDaoImpl extends HibernateDaoSupport implements SlotsDao{

	private final static String SELECT_ALL_SLOTS = "select iu.userid,iu.firstname,iu.lastname,iu.contactnumber,iu.emailaddress,iu.inforaddress,iu.position,ip.parkingid,ip.isparkingtandem from tbl_inforparking ip left join tbl_inforuser iu on ip.userid = iu.userid";
	private final static String SELECT_UNASSIGNED_SLOTS = "select iu.userid,iu.firstname,iu.lastname,iu.contactnumber,iu.emailaddress,iu.inforaddress,iu.position,ip.parkingid,ip.isparkingtandem from tbl_inforparking ip left join tbl_inforuser iu on ip.userid = iu.userid where ip.userid=0";
	private final static String SELECT_ASSIGNED_SLOTS = "select iu.userid,iu.firstname,iu.lastname,iu.contactnumber,iu.emailaddress,iu.inforaddress,iu.position,ip.parkingid,ip.isparkingtandem from tbl_inforparking ip inner join tbl_inforuser iu on ip.userid = iu.userid where ip.userid !=0";
	
	@Override
	public List<InforSlots> getUnassignedSlots() {
		// TODO Auto-generated method stub
		return commonSelectSlotsNative(SELECT_UNASSIGNED_SLOTS);
	}

	@Override
	public List<InforSlots> getAssignedSlots() {
		// TODO Auto-generated method stub
		return commonSelectSlotsNative(SELECT_ASSIGNED_SLOTS);
	}

	@Override
	public List<InforSlots> getAllSlots() {
		// TODO Auto-generated method stub
		return commonSelectSlotsNative(SELECT_ALL_SLOTS);
	}
	
	@SuppressWarnings("unchecked")
	private List<InforSlots> commonSelectSlotsNative(String query){
		List<InforSlots> is = new ArrayList<InforSlots>();
		List<Object[]> plainObj = customNativeSelectQuery(query).list();	
		for(Object[] obj: plainObj){
			InforUser inforUser = new InforUser();
			InforParking inforParking = new InforParking();
			InforSlots inforSlots = new InforSlots();
			inforUser.setUserid(ConverterUtils.convertToInteger(obj[0]));
			inforUser.setFirstname(ConverterUtils.convertToString(obj[1]));
			inforUser.setLastname(ConverterUtils.convertToString(obj[2]));
			inforUser.setContactnumber(ConverterUtils.convertToString(obj[3]));
			inforUser.setEmailaddress(ConverterUtils.convertToString(obj[4]));
			inforUser.setInforaddress(ConverterUtils.convertToString(obj[5]));
			inforUser.setPosition(ConverterUtils.convertToString(obj[6]));
			
			inforParking.setUserid(ConverterUtils.convertToInteger(obj[0]));
			inforParking.setParkingid(ConverterUtils.convertToString(obj[7]));
			inforParking.setIsparkingtandem(ConverterUtils.convertToString(obj[8]));

			inforSlots.setInforParking(inforParking);
			inforSlots.setInforUser(inforUser);
			is.add(inforSlots);
		}	
		return is;
	}

}
