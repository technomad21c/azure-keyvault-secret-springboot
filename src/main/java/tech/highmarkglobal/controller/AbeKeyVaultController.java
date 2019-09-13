package tech.highmarkglobal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tech.highmarkglobal.domain.MasterKey;
import tech.highmarkglobal.service.AbeService;

@RestController
@RequestMapping("/api/abekeyvault")
public class AbeKeyVaultController {
	@Autowired
	AbeService abeservice;

	@ApiOperation(value = "KEY VAULT TEST", httpMethod = "POST", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request"),
			@ApiResponse(code = 500, message = "key vault failed"),
			@ApiResponse(code = 200, message = "key vault success") })

	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public ResponseEntity<?> storeKey(@RequestBody MasterKey mk) {
		return new ResponseEntity<> (abeservice.storeMasterKey(mk), HttpStatus.OK);
	}
	
	@ApiOperation(value = "KEY VAULT TEST", httpMethod = "POST", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Invalid request"),
			@ApiResponse(code = 500, message = "key vault failed"),
			@ApiResponse(code = 200, message = "key vault success") })

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	public ResponseEntity<?> getKey(@RequestBody MasterKey mk) {
		return new ResponseEntity<> (abeservice.getMasterKey(mk), HttpStatus.OK);
	}
}
