package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.UserMgmtServiceImpl;
 @RestController
public class ForgotPwdRestController {
	@Autowired
	private UserMgmtServiceImpl ser;

	@GetMapping("/forgot/{email}")
	public String forgotPwd(@PathVariable String email) {
		String forgotPwd = ser.forgotPwd(email);
		return forgotPwd;

	}

}