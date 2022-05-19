package in.ashokit.binding;

import java.util.Date;

import javax.persistence.Column;

import lombok.Data;
@Data
public class UserRegForm {
	
	
	private Integer Id;
	
	private String firstName;
	
	private String lastName;
	private String email;   //findByEmailIdAndPassword
	
	private Long Phno;

	
	private Date date;
	
	private String gender;
	
	private String country;
	
	private String state;
	
	private String city;
	

}
