package in.ashokit.binding;

import lombok.Data;

@Data
public class UnlockAccForm {
	
	private String email;
	private  String  Password;
	private String newPWd;
	private String confirmNewPwd;
	
}
