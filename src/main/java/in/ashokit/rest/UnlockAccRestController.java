package in.ashokit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.UnlockAccForm;
import in.ashokit.service.UserMgmtServiceImpl;
@RestController
public class UnlockAccRestController {
	private UserMgmtServiceImpl ser;
     @PostMapping("unlockacc")
	public String UnlockAcc(@RequestBody UnlockAccForm unlockaccform) {

    	 String accUnlock = ser.accUnlock(unlockaccform);
		return accUnlock;

	}

}
