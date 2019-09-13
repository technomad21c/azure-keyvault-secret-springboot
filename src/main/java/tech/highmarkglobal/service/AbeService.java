package tech.highmarkglobal.service;

import tech.highmarkglobal.domain.MasterKey;

public interface AbeService {	
	boolean storeMasterKey(MasterKey mk);
	public String getMasterKey(String bountyId, String testerId);
	public String getmasterKey(String bountyId, String testerId, String contractId);
}
