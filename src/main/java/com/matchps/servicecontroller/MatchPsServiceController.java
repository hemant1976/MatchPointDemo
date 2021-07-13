package com.matchps.servicecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.matchps.model.BankRecord;
import com.matchps.service.MatchPsService;

@RestController
public class MatchPsServiceController {
	
	@Autowired
	private MatchPsService matchPsService;
	
	@PostMapping(value = "/createRecord")	
	public ResponseEntity<Object> createBankRecord(@RequestBody BankRecord bankRecord) {
		bankRecord = matchPsService.createRecord(bankRecord);		
		return new ResponseEntity<>("Record created successfully." + bankRecord.getId(),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/fetchRecords")	
	public String fetchRecords() {
		Gson gson = new Gson();  
		String jsonString = gson.toJson(matchPsService.fetchRecords()); 		
		return jsonString;
	}

}
