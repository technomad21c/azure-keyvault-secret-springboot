package tech.highmarkglobal.service;

import tech.highmarkglobal.domain.MasterKey;
import tech.highmarkglobal.encryption.AbeEncryption;

public interface AbeService {	
	public boolean storeMasterKey(MasterKey mk);
	public String getMasterKey(String bountyId, String testerId);
	public String getmasterKey(String bountyId, String testerId, String contractId);
	public String encryptData(AbeEncryption abeEnc) throws Exception;
	public String decryptData(AbeEncryption abeEnc) throws Exception;
}
