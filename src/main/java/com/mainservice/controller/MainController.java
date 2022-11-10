package com.mainservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mainservice.models.MutualFund;
import com.mainservice.models.Portfolio;
import com.mainservice.models.User;
import com.mainservice.models.UserOutput;

@RestController
@RequestMapping("/MainAppService")
public class MainController {
	
	@Autowired
	private RestTemplate rsTemp;
	
	@RequestMapping("/{userId}")
	public UserOutput getUserById(@PathVariable("userId") int userId) {
		
		User usr = rsTemp.getForObject("http://userinfoservice/UserInfoService/"+userId, User.class);
		Portfolio pf = rsTemp.getForObject("http://portfolioservice/PortFolioService/"+usr.getPfId(), Portfolio.class);
		List<MutualFund> usermfList = new ArrayList<MutualFund>(); 
		List<String> mfIdList = pf.getHoldingList();
		for(String mfId : mfIdList) {
			MutualFund mf = rsTemp.getForObject("http://mutualfundservice/MutualFundService/"+mfId, MutualFund.class);
			usermfList.add(mf);
		}
		
		return (new UserOutput(usr,pf,usermfList));
	}
}
