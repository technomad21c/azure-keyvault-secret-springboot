package tech.highmarkglobal.encryption;

import org.springframework.stereotype.Component;
import com.microsoft.azure.keyvault.KeyVaultClient;
import com.microsoft.azure.keyvault.models.SecretBundle;

@Component
public class AzureKeyVault {
	/* Key Vault Configuration */ 
	private String clientId  = "92fe3cae-c3fb-40c2-ac56-660b72bc023a";
	private String clientKey = "16b44822-6c0a-4077-9846-b7244dc7b7d8";
	private String KEYVAULT_URL = "https://axius-keyvault.vault.azure.net/";
	private KeyVaultClient client;
	
	public AzureKeyVault() {
		client = new KeyVaultClient(new ClientSecretKeyVaultCredential(clientId, clientKey));
	}
    
	public boolean storeKey(String bountyId, String testerId, String masterKey) {
		String masterKeyId = bountyId + testerId;    
        SecretBundle ret = client.setSecret(KEYVAULT_URL, masterKeyId, masterKey);
        if (ret != null)
        	return true;
        else
        	return false;
	}
	
    public String getKey(String bountyId, String testerId) {
    	String masterKeyId = bountyId + testerId;
    	SecretBundle retrievedMasterKey = client.getSecret(KEYVAULT_URL, masterKeyId);
    	return retrievedMasterKey.value();
    }
    
    public String getKey(String bountyId, String testerId, String contractId) {
    	String masterKeyId = bountyId + testerId + contractId;
    	SecretBundle retrievedMasterKey = client.getSecret(KEYVAULT_URL, masterKeyId);
    	return retrievedMasterKey.value();
    }
}
