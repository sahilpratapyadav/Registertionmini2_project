package in.ashokit.service;

import java.util.Map;

import in.ashokit.binding.LoginForm;

import in.ashokit.binding.UnlockAccForm;
import in.ashokit.binding.UserRegForm;

public interface UserMgmtService {
	
	//login fucntionality
	public String signIN(LoginForm user);
  
	
	//registration fctionality
	public String signUp(UserRegForm user);
//unlock account functionality
	public String accUnlock(UnlockAccForm user);
	
	
// forgot  password functionality
	String forgotPwd(String email);

    public 	Map<Integer, String> getCountry();

	public Map<Integer, String> getState(Integer countryId);

	public Map<Integer, String> getCity(Integer stateId);
	
	public String emailCheck(String email);


	
}
   