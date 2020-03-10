package com.hossam.virustracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.hossam.virustracker.model.RecoveryRecorder;
import com.hossam.virustracker.services.VirusDataService;

@Controller
public class RecoveryCasesController {
		
		@Autowired
		private VirusDataService virusDataService;
		
		@GetMapping("/recoveryrecord")
		public String recoveryRecord(Model model) {
				
							
				List<RecoveryRecorder> allRecoveryLocations = virusDataService.getAllRecoveryCases();
				int totalRecoveryCases = allRecoveryLocations.stream().mapToInt(state -> state.getTotalRecoveryCases()).sum();
				int todayRecoveryCases=allRecoveryLocations.stream().mapToInt(state -> state.getTodayRecoveryCases()).sum();
				model.addAttribute("recoveryLocations", allRecoveryLocations);
				model.addAttribute("totalRecoveryCases", totalRecoveryCases);
				model.addAttribute("todayRecoveryCases", todayRecoveryCases);
				
					
				
				
				
				return "recoveryrecord";
				
		}
		
	
		
		
}
