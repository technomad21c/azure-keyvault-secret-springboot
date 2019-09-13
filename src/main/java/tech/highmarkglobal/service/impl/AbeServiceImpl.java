package tech.highmarkglobal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.highmarkglobal.domain.MasterKey;
import tech.highmarkglobal.encryption.AzureKeyVault;
import tech.highmarkglobal.service.AbeService;

@Service
public class AbeServiceImpl implements AbeService {

	@Autowired
	AzureKeyVault azureKeyVault;
	
	@Override
	public boolean storeMasterKey(MasterKey mk) {
		return azureKeyVault.storeKey(mk.getBountyId(), mk.getTesterId(), mk.getMasterKey());
	}

	@Override
	public String getMasterKey(String bountyId, String testerId) {
		return azureKeyVault.getKey(bountyId, testerId);
	}

	@Override
	public String getmasterKey(String bountyId, String testerId, String contractId) { 
		return azureKeyVault.getKey(bountyId, testerId, contractId);
	}
}
