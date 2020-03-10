package com.hossam.virustracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hossam.virustracker.model.DeathRecorder;

import com.hossam.virustracker.services.VirusDataService;

@Controller
public class DeathCasesController {
		
		@Autowired
		private VirusDataService virusDataService;
		
		@GetMapping("/deathrecord")
		public String deathRecord(Model model) {
				
							
				List<DeathRecorder> allDeathLocations = virusDataService.getAllDeathCases();
				int totalDeathCases = allDeathLocations.stream().mapToInt(state -> state.getTotalDeathCases()).sum();
				int todayDeathCases=allDeathLocations.stream().mapToInt(state -> state.getTodayDeathCases()).sum();
				model.addAttribute("deathLocations", allDeathLocations);
				model.addAttribute("totalDeathCases", totalDeathCases);
				model.addAttribute("todayDeathCases", todayDeathCases);
				
					
				
				
				
				return "deathrecord";
				
		}
		
	
		
		
}
