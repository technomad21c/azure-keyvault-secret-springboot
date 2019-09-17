package tech.highmarkglobal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.junwei.bswabe.Bswabe;
import co.junwei.bswabe.BswabeCph;
import co.junwei.bswabe.BswabeCphKey;
import co.junwei.bswabe.BswabeElementBoolean;
import co.junwei.bswabe.BswabePrv;
import co.junwei.bswabe.BswabePub;
import co.junwei.bswabe.SerializeUtils;
import co.junwei.cpabe.AESCoder;

import tech.highmarkglobal.domain.MasterKey;
import tech.highmarkglobal.encryption.AbeEncryption;
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
	
	@Override
	public String encryptData(AbeEncryption abeEnc) throws Exception {		
		BswabePub pub = SerializeUtils.unserializeBswabePub(abeEnc.getPubByte());		
		String policy = abeEnc.getPolicy();
		
		BswabeCphKey crypt = Bswabe.enc(pub, policy);		
		
		byte[] cipherData = AESCoder.encrypt(crypt.key.toBytes(), abeEnc.getData().getBytes());
		
		return getString(cipherData);
	}

	@Override
	public String decryptData(AbeEncryption abeEnc) throws Exception {
		BswabePub pub = SerializeUtils.unserializeBswabePub(abeEnc.getPubByte());
		BswabePrv prv = SerializeUtils.unserializeBswabePrv(pub, abeEnc.getPrvByte());		
		BswabeCph cph = SerializeUtils.bswabeCphUnserialize(pub, abeEnc.getCphByte());
		
		BswabeElementBoolean decrypt = Bswabe.dec(pub, prv, cph);
		byte[] decryptData = AESCoder.decrypt(decrypt.e.toBytes(),  getBytes(abeEnc.getData())); 
		
		return new String(decryptData);
	}
	
	public static byte[] getBytes(String str)
    {
		char[] chars = str.toCharArray();
        byte[] bytes = new byte[chars.length * 2];
        for (int i = 0; i < chars.length; i++)
        {
            bytes[i * 2] = (byte) (chars[i] >> 8);
            bytes[i * 2 + 1] = (byte) chars[i];
        }

        return bytes;
    }

    public static String getString(byte[] bytes)
    {
//        char[] chars = new char[bytes.length / 2];
        char[] chars2 = new char[bytes.length / 2];
        for (int i = 0; i < chars2.length; i++)
            chars2[i] = (char) ((bytes[i * 2] << 8) + (bytes[i * 2 + 1] & 0xFF));

        return new String(chars2);
    }
}
