package in.ashokit.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.cache.spi.support.CollectionReadOnlyAccess;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.UnlockAccForm;
import in.ashokit.binding.UserRegForm;
import in.ashokit.entity.CityMasterEntiy;
import in.ashokit.entity.CountryMasterEntity;
import in.ashokit.entity.StateMasterEntity;
import in.ashokit.entity.UserAccountEnitity;
import in.ashokit.randompwd.GenerateRandomString;
import in.ashokit.repository.CityMasterRepo;
import in.ashokit.repository.CountryMasterRepo;
import in.ashokit.repository.StateMasterRepo;
import in.ashokit.repository.UserAccountMasterRepo;
import in.ashokit.util.EmailUtils;

@Service
public class UserMgmtServiceImpl implements UserMgmtService {
	@Autowired
	private UserAccountMasterRepo repo;
	@Autowired
	private CountryMasterRepo cmrepo;
	@Autowired
	private StateMasterRepo stmrepo;
	@Autowired
	private CityMasterRepo ctrepo;
	@Autowired
	private EmailUtils emailutils;

	@Override
	public String signIN(LoginForm user) {
		// TODO Auto-generated method stub

		UserAccountEnitity entity = repo.findByEmailAndPazzword(user.getEmail(), user.getPassword());
		if (entity == null) {
			return "credential are  invalid";
		}

		if (entity != null && entity.getAccStatus().equals("locked")) {
			return "your account is locked";
		}
		return "sucess";
	}

	public String emailCheck(String email) {
		UserAccountEnitity entity = repo.findByEmail(email);
		if (entity==null) {
			return "uniq mail id";

		}
		return "deblicate email";
	}

	// generate paswd
	private static String generateRandomString() {

		String asciiUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String asciiLowerCase = asciiUpperCase.toLowerCase();
		String digits = "1234567890";
		String seedchars = asciiUpperCase + asciiLowerCase + digits;

		int length = 4;
		// String seedChars=
		StringBuilder sb = new StringBuilder();
		int i = 0;
		Random rand = new Random();
		while (i < length) {
			sb.append(seedchars.charAt(rand.nextInt(seedchars.length())));
			i++;
		}
		return sb.toString();
	}

	public String signUp(UserRegForm user) {
		UserRegForm obj = new UserRegForm();
		UserAccountEnitity entity = new UserAccountEnitity();
		BeanUtils.copyProperties(user, entity);

		entity.setPazzword(UserMgmtServiceImpl.generateRandomString());
		entity.setAccStatus("locked");

		UserAccountEnitity savedEnity = repo.save(entity);
		String email = user.getEmail();
		String subject = "User Registration AshokIT";
		String filename = "UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt";
		String body = readMailBodyContent(filename, entity);
		boolean isSent = emailutils.sendEmail(email, subject, body);

		if (savedEnity.getId()!=null && isSent) {
			return "success";
		}
		else {
			return "fail";
		}

		// repo.saveAll(user);

		// TODO :LOGIC TO SEND EMAIL

		
	}

	@Override
	public String accUnlock(UnlockAccForm unlockaccform) {
		// TODO Auto-generated method stub
		if (!(unlockaccform.getNewPWd().equals(unlockaccform.getConfirmNewPwd()))) {
			return "password and confirm Password should be same";
		}
		UserAccountEnitity entity = repo.findByEmailAndPazzword(unlockaccform.getEmail(), unlockaccform.getPassword());
		if (entity == null) {
			return "Incorrect Tempory PAssword ";
		}
		entity.setPazzword(unlockaccform.getNewPWd());
		entity.setAccStatus("UNLOCKED");
		repo.save(entity);

		return "account is unlocked";
	}

	@Override
	public String forgotPwd(String email) {
		// TODO Auto-generated method stub
		UserAccountEnitity entity = repo.findByEmail(email);
		if (entity == null) {
			return "invalid email id";

		}

		// TODO EMAIL REQUIRMENT
		String  fileName="RECOVER-PASSWORD-EMAIL-BODY.txt";
		String body=readMailBodyContent(fileName, entity);
		String subject="Recovery Password -Ashok IT";
		boolean isSent=emailutils.sendEmail(email, subject, body);
		if(isSent) {
			return "Password sent to register email";
		}

		return null;
	}

	@Override
	public Map<Integer, String> getCountry() {
		// TODO Auto-generated method stub
		List<CountryMasterEntity> countryList = cmrepo.findAll();

		Map<Integer, String> mapContry = new HashMap<Integer, String>();
		for (CountryMasterEntity obj : countryList) {
			mapContry.put(obj.getCountryId(), obj.getCountryCode());

		}

		return mapContry;
	}

	@Override
	public Map<Integer, String> getState(Integer countryId) {
		List<StateMasterEntity> statelist = stmrepo.findAll();
		Map<Integer, String> mapStateList = new HashMap<Integer, String>();

		for (StateMasterEntity obj : statelist) {
			mapStateList.put(obj.getStateId(), obj.getStateCode());
		}
		// TODO Auto-generated method stub
		return mapStateList;
	}

	@Override
	public Map<Integer, String> getCity(Integer stateId) {
		List<CityMasterEntiy> cityList = ctrepo.findAll();
		Map<Integer, String> mapCityList = new HashMap<Integer, String>();

		for (CityMasterEntiy obj : cityList) {
			mapCityList.put(obj.getCityId(), obj.getCityName());
		}
		// TODO Auto-generated method stub
		return mapCityList;

	}

	private String readMailBodyContent(String fileName, UserAccountEnitity entity) {
		String mailBody = "";
		try {
			StringBuffer sb = new StringBuffer();
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();// reading first line data
			while (line != null) {
				sb.append(line);// append line data to buffer obj
				line = br.readLine(); // readlin next line data

			}

			mailBody = sb.toString();
			mailBody = mailBody.replace("{FNAME}", entity.getFirstName());
			mailBody = mailBody.replace("{LNAME}", entity.getLastName());
			mailBody = mailBody.replace("{TEMP-PWD}", entity.getPazzword());
			mailBody = mailBody.replace("{EMAIL}", entity.getEmail());
			mailBody=mailBody.replace("{PWD}", entity.getPazzword());
			br.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return mailBody;

	}
}
