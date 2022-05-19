package in.ashokit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "User_Account_Enitity")

public class UserAccountEnitity {
	@javax.persistence.Id
	private Integer Id;
	@Column(name = "FIRST_NAME")
	
	private String firstName;
	@Column(name = "LAST_NAME")
	
	private String lastName;
	@Column(name = "PWD")
	private String pazzword;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "acc_status")
	private String accStatus;
	
	
	@Column(name = "PHNO")
	private Long Phno;

	@Column(name = "DATE")
	private Date date;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "STATE")
	private String state;
	
	@Column(name = "CITY")
	private String city;

}
