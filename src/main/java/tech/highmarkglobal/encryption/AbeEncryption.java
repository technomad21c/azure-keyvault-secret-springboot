package tech.highmarkglobal.encryption;

public class AbeEncryption {
	private byte[] pubByte;
	private byte[] mskByte;
	private byte[] prvByte;
	private byte[] cphByte;
	private String policy;
	private String data;
	
	public byte[] getPubByte() {
		return pubByte;
	}
	public void setPubByte(byte[] pubByte) {
		this.pubByte = pubByte;
	}
	public byte[] getMskByte() {
		return mskByte;
	}
	public void setMskByte(byte[] mskByte) {
		this.mskByte = mskByte;
	}
	public byte[] getCphByte() {
		return cphByte;
	}
	public void setCphByte(byte[] cphByte) {
		this.cphByte = cphByte;
	}
	public byte[] getPrvByte() {
		return prvByte;
	}
	public void setPrvByte(byte[] prvByte) {
		this.prvByte = prvByte;
	}
	public String getPolicy() {
		return policy;
	}
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
}
