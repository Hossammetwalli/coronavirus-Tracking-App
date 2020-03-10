package com.hossam.virustracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hossam.virustracker.model.DeathRecorder;
import com.hossam.virustracker.model.Location;
import com.hossam.virustracker.model.RecoveryRecorder;
import com.hossam.virustracker.services.VirusDataService;

@Controller
public class HomeController {
		
		@Autowired
		private VirusDataService virusDataService;
		
		@GetMapping("/")
		public String home(Model model) {
				
				List<Location> allLocations = virusDataService.getAllLocations();
							
				int totalCases = allLocations.stream().mapToInt(state -> state.getTotalCases()).sum();
				int todayNewCases=allLocations.stream().mapToInt(state -> state.getTodayNewCases()).sum();
				model.addAttribute("locations", allLocations);
				model.addAttribute("totalCases", totalCases);
				model.addAttribute("todayNewCases", todayNewCases);
				
				
				
				List<DeathRecorder> allDeathLocations = virusDataService.getAllDeathCases();
				int totalDeathCases = allDeathLocations.stream().mapToInt(state -> state.getTotalDeathCases()).sum();
				int todayDeathCases=allDeathLocations.stream().mapToInt(state -> state.getTodayDeathCases()).sum();
				model.addAttribute("totalDeathCases", totalDeathCases);
				model.addAttribute("todayDeathCases", todayDeathCases);
				
				
				List<RecoveryRecorder> allRecoveryLocations = virusDataService.getAllRecoveryCases();
				int totalRecoveryCases = allRecoveryLocations.stream().mapToInt(state -> state.getTotalRecoveryCases()).sum();
				int todayRecoveryCases=allRecoveryLocations.stream().mapToInt(state -> state.getTodayRecoveryCases()).sum();
				model.addAttribute("totalRecoveryCases", totalRecoveryCases);
				model.addAttribute("todayRecoveryCases", todayRecoveryCases);
				
					
				
				return "home";
				
		}
		
	
		
		
}
