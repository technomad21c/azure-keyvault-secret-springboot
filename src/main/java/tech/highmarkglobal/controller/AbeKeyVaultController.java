package tech.highmarkglobal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tech.highmarkglobal.domain.MasterKey;
import tech.highmarkglobal.encryption.AbeEncryption;
import tech.highmarkglobal.service.AbeService;

@RestController
@RequestMapping("/api/abe")
public class AbeKeyVaultController {
	@Autowired
	AbeService abeservice;

	
	@ApiOperation(value = "KEY VAULT TEST", httpMethod = "POST", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request"),
			@ApiResponse(code = 500, message = "key vault failed"),
			@ApiResponse(code = 200, message = "key vault success") })

	@RequestMapping(value = "/keyvault/store", method = RequestMethod.POST)
	public ResponseEntity<?> storeKey(@RequestBody MasterKey mk) {
		return new ResponseEntity<> (abeservice.storeMasterKey(mk), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "KEY VAULT TEST", httpMethod = "GET", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request"),
			@ApiResponse(code = 500, message = "key vault failed"),
			@ApiResponse(code = 200, message = "key vault success") })

	@RequestMapping(value = "/keyvault/get/{bountyId}/{testerId}", method = RequestMethod.GET)
	public ResponseEntity<?> getKey(@PathVariable String bountyId, @PathVariable String testerId ) {
		return new ResponseEntity<> (abeservice.getMasterKey(bountyId, testerId), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "CP-ABE ENCRYPTION TEST", httpMethod = "POST", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request"),
			@ApiResponse(code = 500, message = "key vault failed"),
			@ApiResponse(code = 200, message = "key vault success") })

	@RequestMapping(value = "/cpabe/encrypt", method = RequestMethod.POST)
	public ResponseEntity<?> encryptData(@RequestBody AbeEncryption abeEnc) throws Exception {
		/*
		 * if new bounty then initialize bswabe(setup pub/msk, generate prv, store the keys in DB
		 * then invoke encryptData method
		 */
		
		return new ResponseEntity<> (abeservice.encryptData(abeEnc), HttpStatus.OK);
	}	
	
	
	@ApiOperation(value = "CP-ABE DECRYPTION TEST", httpMethod = "GET", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request"),
			@ApiResponse(code = 500, message = "key vault failed"),
			@ApiResponse(code = 200, message = "key vault success") })

	@RequestMapping(value = "/cpabe/decrypt", method = RequestMethod.POST)
	public ResponseEntity<?> decryptData(@RequestBody AbeEncryption abeEnc) throws Exception {
		return new ResponseEntity<> (abeservice.decryptData(abeEnc), HttpStatus.OK);
	}
	
}
