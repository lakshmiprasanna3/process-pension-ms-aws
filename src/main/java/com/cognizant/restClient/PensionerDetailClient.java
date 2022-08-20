package com.cognizant.restClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.PensionerDetail;

@FeignClient(name = "pensioner-detail-microservice", url = "${PENSIONDETAILS_VAR:http://localhost:8005/pensiondetail}")
public interface PensionerDetailClient {
	
	@GetMapping("/pensionerDetailByAadhaar/{aadhaarNumber}")
	public PensionerDetail findByAadhaarNumber(@RequestHeader("Authorization") String token1,  @PathVariable String aadhaarNumber);

	@GetMapping("/allPensionersdetails")
	public List<PensionerDetail> getAllDetail();
	
}
