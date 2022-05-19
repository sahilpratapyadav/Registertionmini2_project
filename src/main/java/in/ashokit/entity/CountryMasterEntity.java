package in.ashokit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="COUNTRY_MASTER")
@Data
public class CountryMasterEntity {
	@Id
	@Column(name="COUNTRY_ID")
	private Integer countryId;
	
	@Column(name="COUNTRY_NAME")
	private String countryCode;
	

}
/*//SQL QUERIES TO INSERT DATA INTO STATE_MASTER   STATE_MASTER
Insert Into STATES_MASTER (STATE_ID, COUNTRY_ID, STATE_NAME) Values(1,1,'Andhra Pradesh');
Insert Into STATES_MASTER (STATE_ID, COUNTRY_ID, STATE_NAME) Values(2,1,'Karnataka');
Insert Into STATES_MASTER (STATE_ID, COUNTRY_ID, STATE_NAME) Values(3,2,'New Jersy');
insert into STATES_MASTER (STATE_ID, COUNTRY_ID, STATE_NAME) values(4,2,'Ohio');

//SQL QUERIES TO INSERT DATA INTO CITY_MASTER    CITY_MASTER_ENTITY
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(1,'Vizag',1);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(2,'Guntur',1);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(3,'Banglore',2);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(4,'Mysore',2);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(5,'Maywood',3);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(6,'Westwood',3);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(7,'Oakwood',4);
Insert Into CITIES_MASTER (CITY_ID, CITY_NAME, STATE_ID) Values(8,'Cuyahoga County',4);*/