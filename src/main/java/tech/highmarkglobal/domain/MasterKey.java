package tech.highmarkglobal.domain;

public class MasterKey {
	private String bountyId;
	private String testerId;
	private String contractId;
	private String MasterKey;
	
	public String getMasterKey() {
		return MasterKey;
	}
	public void setMasterKey(String masterKey) {
		MasterKey = masterKey;
	}
	public String getBountyId() {
		return bountyId;
	}
	public void setBountyId(String bountyId) {
		this.bountyId = bountyId;
	}
	public String getTesterId() {
		return testerId;
	}
	public void setTesterId(String testerId) {
		this.testerId = testerId;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	
	
}
