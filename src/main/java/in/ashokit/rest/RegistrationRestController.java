package in.ashokit.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.UserRegForm;
import in.ashokit.service.UserMgmtServiceImpl;


@RestController
public class RegistrationRestController {
	@Autowired
	private UserMgmtServiceImpl service;
	
	@GetMapping("/email/{emaild}")
	public String emailCheck(@PathVariable String emailId) {
		return service.emailCheck(emailId);
	}
	
	@GetMapping("/getcoutries")
	public Map<Integer,String> getCountries(){
		return service.getCountry();
	}
	
	
	@GetMapping("/getstetes/{countryId}")
	public Map<Integer,String> getStates(@PathVariable Integer countryId){
		return service.getState(countryId);
		 
	}
	
	@GetMapping("/getcities/{statedId}")
	public Map<Integer,String> getCities(@PathVariable Integer statedId){
		return service.getCity(statedId);
	}
	
	
	@PostMapping("/registration")
	public String regitstration(@RequestBody UserRegForm user) {
		String signUp = service.signUp(user);
		
		return signUp;
	}

}
